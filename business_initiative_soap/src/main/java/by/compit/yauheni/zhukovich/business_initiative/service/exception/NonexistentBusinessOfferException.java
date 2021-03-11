package by.compit.yauheni.zhukovich.business_initiative.service.exception;

public class NonexistentBusinessOfferException extends Throwable {

    private static final String NONEXISTENT_BUSINESS_OFFER_EXCEPTION =
            "There is no business offer with this this ID.";

    public NonexistentBusinessOfferException() {
        super(NONEXISTENT_BUSINESS_OFFER_EXCEPTION);
    }

}
