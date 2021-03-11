package by.compit.yauheni.zhukovich.business_initiative.service.exception;

public class NonexistentBankingProductCardException extends Throwable {

    private static final String NONEXISTENT_BANKING_PRODUCT_CARD_EXCEPTION =
            "There is no banking product card with this ID.";

    public NonexistentBankingProductCardException() {
        super(NONEXISTENT_BANKING_PRODUCT_CARD_EXCEPTION);
    }

}
