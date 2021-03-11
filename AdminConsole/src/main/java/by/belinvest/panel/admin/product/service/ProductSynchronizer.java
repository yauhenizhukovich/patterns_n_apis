package by.belinvest.panel.admin.product.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import by.belinvest.panel.admin.entity.product.Product;
import by.belinvest.panel.admin.product.dto.ProductDTO;
import by.belinvest.panel.admin.product.repository.ProductJDBCRepository;
import by.belinvest.panel.admin.product.repository.ProductRepository;
import by.belinvest.panel.admin.product.service.exception.BRISRequestStatusFieldException;
import by.belinvest.panel.admin.product.service.exception.UrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static by.belinvest.panel.admin.product.service.constant.ProductConstant.CARD;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.CREDIT;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.DEBIT;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URCRED;
import static by.belinvest.panel.admin.product.service.constant.ProductConstant.URDEP;

@Service
public class ProductSynchronizer {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductJDBCRepository productJDBCRepository;
    @Autowired
    private BankProductService bankProductService;

    @Transactional
    public String synchronize(List<Long> productsId) throws BRISRequestStatusFieldException, UrException {
        List<Product> products = productRepository.findAllByIdIn(productsId);
        if (products.isEmpty()) {
            return "Продукты отсутствуют в таблице PRODUCT.";
        }
        System.out.println("Products to synchronize: " + products.size() + ".");
        List<ProductDTO> productDTOList = getRealProducts(products);
        if (productDTOList.isEmpty()) {
            return "Отсутствует реальное представление о продуктах CARD, CREDIT, DEBIT.";
        }
        int countOfSynchronized = 0;
        for (ProductDTO productDTO : productDTOList) {
            Map<String, Object> realProduct = productDTO.getRealProduct();
            String tableName = productDTO.getProduct().getProductGroup().getTableName();
            System.out.println(productDTO.getProduct());
            Byte isSynchronized = productDTO.getProduct().getfSynchroniz();
            System.out.println(tableName + " product. Is synchronized - " + isSynchronized);
            boolean isAdded = synchronizeByTableName(realProduct, tableName, isSynchronized);
            if (isAdded) {
                productDTO.getProduct().setfSynchroniz((byte) 1);
                countOfSynchronized++;
            }
        }
        if (countOfSynchronized == 0) {
            return "Продукты не синхронизированы.";
        }
        return "Синхронизировано продуктов: " + countOfSynchronized + ".";
    }

    private List<ProductDTO> getRealProducts(List<Product> products) {
        return products
                .stream()
                .filter(product -> product.getProductGroup().getTableName() != null)
                .map(product -> ProductDTO
                        .builder()
                        .product(product)
                        .realProduct(productJDBCRepository.getProductAsMapById(product.getProductId(),
                                product.getProductGroup().getTableName()))
                        .build())
                .filter(product -> !product.getRealProduct().isEmpty())
                .collect(Collectors.toList());
    }

    private boolean synchronizeByTableName(Map<String, Object> realProduct, String tableName, Byte isSynchronized) throws BRISRequestStatusFieldException, UrException {
        boolean isAdded;
        switch (tableName) {
            case URCRED:
                isAdded = synchronizeUrCred(realProduct, isSynchronized);
                break;
            case URDEP:
                isAdded = synchronizeUrDep(realProduct, isSynchronized);
                break;
            case CREDIT:
                isAdded = synchronizeCredit(realProduct, isSynchronized);
                break;
            case DEBIT:
                isAdded = synchronizeDebit(realProduct, isSynchronized);
                break;
            case CARD:
                isAdded = synchronizeCard(realProduct, isSynchronized);
                break;
            default:
                System.out.println("Unsupported table name: " + tableName);
                throw new UnsupportedOperationException("Отсутствует таблица с именем " + tableName + ".");
        }
        return isAdded;
    }

    private boolean synchronizeCard(Map<String, Object> realProduct, Byte isSynchronized) throws BRISRequestStatusFieldException {
        if (isSynchronized == null || isSynchronized == 0) {
            return bankProductService.addCard(realProduct);
        } else {
            return bankProductService.updateCard(realProduct);
        }
    }

    private boolean synchronizeDebit(Map<String, Object> realProduct, Byte isSynchronized) throws BRISRequestStatusFieldException {
        if (isSynchronized == null || isSynchronized == 0) {
            return bankProductService.addDebit(realProduct);
        } else {
            return bankProductService.updateDebit(realProduct);
        }
    }

    private boolean synchronizeCredit(Map<String, Object> realProduct, Byte isSynchronized) throws BRISRequestStatusFieldException {
        if (isSynchronized == null || isSynchronized == 0) {
            return bankProductService.addCredit(realProduct);
        } else {
            return bankProductService.updateCredit(realProduct);
        }
    }

    private boolean synchronizeUrDep(Map<String, Object> realProduct, Byte isSynchronized) throws BRISRequestStatusFieldException, UrException {
        if (isSynchronized == null || isSynchronized == 0) {
            return bankProductService.addUrDep(realProduct);
        } else {
            return bankProductService.updateUrDep(realProduct);
        }
    }

    private boolean synchronizeUrCred(Map<String, Object> realProduct, Byte isSynchronized) throws BRISRequestStatusFieldException, UrException {
        if (isSynchronized == null || isSynchronized == 0) {
            return bankProductService.addUrCred(realProduct);
        } else {
            return bankProductService.updateUrCred(realProduct);
        }
    }

}
