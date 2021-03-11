package by.compit.yauheni.zhukovich.nsi_product.service.util;

import by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl.Product;
import by.compit.yauheni.zhukovich.nsi_product.service.exception.NonexistentProductException;

public class CheckUtil {

    public static void checkProductForNotNull(Product product) throws NonexistentProductException {
        if (product == null) {
            throw new NonexistentProductException();
        }
    }

}
