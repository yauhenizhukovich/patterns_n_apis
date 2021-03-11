package by.compit.yauheni.zhukovich.business_initiative.service.util.conversion.business_offer;

import org.example.TBOProduct;

import by.compit.yauheni.zhukovich.business_initiative.repository.model.business_offer.Product;

public class ProductConversionUtil {

    public static Product convertDTOToDatabaseObject(TBOProduct productDTO) {
        Product product = new Product();
        String processModel = productDTO.getProcessModel();
        if (processModel != null) {
            product.setProcessModel(processModel);
        }
        String productDesc = productDTO.getProductDesc();
        if (productDesc != null) {
            product.setProductDesc(productDesc);
        }
        String techProcessDesc = productDTO.getTechProcessDesc();
        if (techProcessDesc != null) {
            product.setTechProcessDesc(techProcessDesc);
        }
        return product;
    }

    public static TBOProduct convertDatabaseObjectToDTO(Product product) {
        TBOProduct productDTO = new TBOProduct();
        String productDesc = product.getProductDesc();
        if (productDesc != null) {
            productDTO.setProductDesc(productDesc);
        }
        String techProcessDesc = product.getTechProcessDesc();
        if (techProcessDesc != null) {
            productDTO.setTechProcessDesc(techProcessDesc);
        }
        String processModel = product.getProcessModel();
        if (processModel != null) {
            productDTO.setProcessModel(processModel);
        }
        return productDTO;
    }

}
