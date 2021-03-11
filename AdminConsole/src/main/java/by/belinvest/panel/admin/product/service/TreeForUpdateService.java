package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.product.Product;
import by.belinvest.panel.admin.entity.product.ProductElement;
import by.belinvest.panel.admin.entity.product.TreeElement;
import by.belinvest.panel.admin.product.repository.TreeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class TreeForUpdateService {
    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private ProductService productService;

    @Transactional
    public TreeElement getThirdLevelTree(Long pg1, Long pg2, Long pg3, String lineName){
        List<TreeElement> elementList = treeRepository.getTree(pg1,pg2,pg3);

        /**Filter tree by line name**/
        if(lineName!=null){
            elementList.removeIf(element -> element.getLev() == 4 && !element.getName().equals(lineName));
        }
        return shapeTree(elementList);
    }

    @Transactional
    public TreeElement getFifthTree(Long pg1, Long pg2, Long pg3, Long pg4, Long pg5, String currency,String status){
        List<TreeElement> productGroupList = treeRepository.getFifthLevelTree(pg1, pg2, pg3, pg4, pg5);
        List<Product> productList = productService.findAll();
        if(currency != null){
            productList = productService.filterProductsByCurrency(productList,currency);
        }
        if(status != null){
            productList = productService.filterProductsByStatus(productList,status);
        }

        for (Product product : productList) {
            String hiId;
            Byte lev;
            if (product.getBnId() == null && product.getDbId() == null) {
                hiId = product.getProductGroup().getId().toString();
                lev = 4;
            } else if (product.getBnId() != null && product.getDbId() == null) {
                hiId = product.getBnId().toString();
                lev = 5;
            } else {
                hiId = product.getDbId().toString();
                lev = 6;
            }

            for (TreeElement productGroup : productGroupList) {
                if (productGroup.getId().equals(hiId)) {
                    productGroup.getChild().add(
                            TreeElement.builder()
                                    .id(product.getId().toString())
                                    .hiId(hiId)
                                    .lev(lev)
                                    .name(productService.getNameOfProductById(product.getProductGroup().getTableName(),product.getProductGroup().getProductName(),product.getProductId()))
                                    .typ((byte) 2)
                                    .productElement(ProductElement.builder()
                                            .code(product.getProductCode())
                                            .productId(product.getProductGroup().getId())
                                            .bnId(product.getBnId())
                                            .dbId(product.getDbId())
                                            .build()
                                    )
                                    .child(new ArrayList<>())
                                    .build()
                    );
                }
            }

        }


        /*productList.forEach( product -> {
            if(product.getBnId() == null && product.getDbId() == null){
                productGroupList.forEach(productGroup->{
                    if(productGroup.getId().equals(product.getProductGroup().getId().toString())){

                    }
                });
            }else if(product.getBnId() != null && product.getDbId() == null){
                productGroupList.forEach(productGroup->{
                    if(productGroup.getId().equals(product.getBnId().toString())){

                    }
                });
            }else {
                productGroupList.forEach(productGroup->{
                    if(productGroup.getId().equals(product.getDbId().toString())){

                    }
                });
            }
                }
        );*/
        /*productGroupList.forEach(group -> {
            List<Product> productList;
            if (group.getLev() == 3) {

                productList = productService.findAll(group.getRealId(), pg4, pg5);

                if (currency != null) {
                    productList = productService.filterProductsByCurrency(productList, currency);
                }

                group.setChild(productList.stream().map(product ->

                        ).collect(Collectors.toList())
                );
            }
        });*/

        return shapeTree(productGroupList);
    }


    private TreeElement shapeTree(List<TreeElement> elementList){
        TreeElement tree = TreeElement.builder().child(new ArrayList<>()).build();
        int lastLevel = elementList.stream().mapToInt(TreeElement::getLev).max().orElseThrow(NoSuchElementException::new);
        for(int i = lastLevel;i > 1; i--){
            int temp = i;
            List<TreeElement> leafs = elementList.stream().filter(treeElement -> treeElement.getLev()==temp).collect(Collectors.toList());
            leafs.forEach(leafElement -> {
                elementList.forEach(treeElement -> {
                    if(treeElement.getId().equals(leafElement.getHiId())){
                        treeElement.getChild().add(leafElement);
                    }
                });
            });

        }
        elementList.forEach(treeElement -> {
            if(treeElement.getLev() == 1){
                tree.getChild().add(treeElement);
            }
        });


        //rec(tree.getChild());

        return tree;
    }

    private void rec(List<TreeElement> list){
        if (!list.isEmpty()){
            for (TreeElement treeElement: list) {
                if (treeElement.getLev() == 1){
                    System.out.println(treeElement.getId() + " " +treeElement.getName() + " " + treeElement.getLev());

                }
                if (!treeElement.getChild().isEmpty()){
                    rec(treeElement.getChild());
                }

            }
        }
    }
}

