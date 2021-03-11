package by.compit.yauheni.zhukovich.nsi_product.service.exception;

public class NonexistentProductException extends Throwable {

    private static final String NONEXISTENT_PRODUCT_EXCEPTION =
            "There is no product with this ID.";

    public NonexistentProductException() {
        super(NONEXISTENT_PRODUCT_EXCEPTION);
    }

}
