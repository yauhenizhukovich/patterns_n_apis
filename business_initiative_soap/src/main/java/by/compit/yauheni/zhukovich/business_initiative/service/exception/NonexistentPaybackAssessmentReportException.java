package by.compit.yauheni.zhukovich.business_initiative.service.exception;

public class NonexistentPaybackAssessmentReportException extends Throwable {

    private static final String NONEXISTENT_PAYBACK_ASSESSMENT_REPORT_EXCEPTION =
            "There is no payback assessment report with this ID.";

    public NonexistentPaybackAssessmentReportException() {
        super(NONEXISTENT_PAYBACK_ASSESSMENT_REPORT_EXCEPTION);
    }

}
