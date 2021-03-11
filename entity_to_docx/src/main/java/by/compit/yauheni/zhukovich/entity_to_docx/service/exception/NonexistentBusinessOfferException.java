package by.compit.yauheni.zhukovich.entity_to_docx.service.exception;

public class NonexistentBusinessOfferException extends Throwable {

    private static final String NONEXISTENT_BUSINESS_OFFER_EXCEPTION =
            "There is no business offer with this ID.";

    public NonexistentBusinessOfferException() {
        super(NONEXISTENT_BUSINESS_OFFER_EXCEPTION);
    }

}
