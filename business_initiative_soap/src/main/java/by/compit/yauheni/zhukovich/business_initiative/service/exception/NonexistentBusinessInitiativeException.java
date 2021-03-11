package by.compit.yauheni.zhukovich.business_initiative.service.exception;

public class NonexistentBusinessInitiativeException extends Throwable {

    private static final String NONEXISTENT_BUSINESS_INITIATIVE_EXCEPTION =
            "There is no business initiative with this ID.";

    public NonexistentBusinessInitiativeException() {
        super(NONEXISTENT_BUSINESS_INITIATIVE_EXCEPTION);
    }

}
