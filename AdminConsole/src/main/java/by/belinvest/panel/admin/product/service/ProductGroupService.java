package by.belinvest.panel.admin.product.service;

import by.belinvest.panel.admin.entity.SendProductView;
import by.belinvest.panel.admin.entity.product.ProductGroup;
import by.belinvest.panel.admin.product.dto.ProductGroupTreeDTO;
import by.belinvest.panel.admin.product.repository.ProductGroupRepository;
import by.belinvest.panel.admin.product.repository.ProductGroupTreeRepository;
import by.belinvest.panel.admin.product.repository.ProductJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductGroupService {

    @Autowired
    private ProductGroupTreeRepository productGroupTreeRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductJDBCRepository productJDBCRepository;

    public List<ProductGroupTreeDTO> getProductGroupTreeDTOList(){
        return productGroupTreeRepository.getThirdLevelProductGroupTree();
    }

    public List<ProductGroupTreeDTO> getFifthLevelGroups(){
        return productGroupTreeRepository.getFifthLevelProductGroupTree();
    }

    public List<ProductGroup> findAll(){
        return productGroupRepository.findAll();
    }

    public ProductGroup findById(Long id){
        return productGroupRepository.findById(id).get();
    }

    public void createProductView(SendProductView sendProductView){
        Long hiId = null;
        if (sendProductView.getViewProduct()!=null){
            hiId = Long.parseLong(sendProductView.getViewProduct());
        } else if (sendProductView.getGroupProduct()!=null){
            hiId = Long.parseLong(sendProductView.getGroupProduct());
        }else if (sendProductView.getClassProduct()!=null){
            hiId = Long.parseLong(sendProductView.getClassProduct());
        }else if (sendProductView.getBusinessDirections()!=null){
            hiId = Long.parseLong(sendProductView.getBusinessDirections());
        }
        ProductGroup productGroup = new ProductGroup();
        productGroup.setProductCurr("");
        productGroup.setProductCode("");
        productGroup.setProductName("");
        productGroup.setTableName("");
        productGroup.setName(sendProductView.getInputField());
        productGroup.setHiId(hiId);

        productJDBCRepository.saveProductGroup(productGroup);
    }

    public void updateProductView(SendProductView sendProductView,Integer id){

        Long hiId = null;
        if (sendProductView.getViewProduct()!=null){
            hiId = Long.parseLong(sendProductView.getViewProduct());
        } else if (sendProductView.getGroupProduct()!=null){
            hiId = Long.parseLong(sendProductView.getGroupProduct());
        }else if (sendProductView.getClassProduct()!=null){
            hiId = Long.parseLong(sendProductView.getClassProduct());
        }else if (sendProductView.getBusinessDirections()!=null){
            hiId = Long.parseLong(sendProductView.getBusinessDirections());
        }
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(id.longValue());
        productGroup.setProductCurr("");
        productGroup.setProductCode("");
        productGroup.setProductName("");
        productGroup.setTableName("");
        productGroup.setName(sendProductView.getInputField());
        productGroup.setHiId(hiId);


        productJDBCRepository.updateProductView(productGroup);

    }

    public void deleteProductView(Integer id) {
        productJDBCRepository.deleteProductView(id);
    }
}
