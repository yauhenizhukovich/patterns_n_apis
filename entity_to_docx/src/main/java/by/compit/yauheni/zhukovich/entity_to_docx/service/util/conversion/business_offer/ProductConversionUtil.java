package by.compit.yauheni.zhukovich.entity_to_docx.service.util.conversion.business_offer;

import by.compit.yauheni.zhukovich.entity_to_docx.repository.model.business_offer.Product;
import org.example.TBOProduct;

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
        return productDTO;
    }

}
