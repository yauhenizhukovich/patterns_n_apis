package by.compit.yauheni.zhukovich.business_initiative.service.exception;

public class NonexistentMonitorProductReportException extends Throwable {

    private static final String NONEXISTENT_MONITOR_PRODUCT_REPORT_EXCEPTION =
            "There is no monitor product report with this ID.";

    public NonexistentMonitorProductReportException() {
        super(NONEXISTENT_MONITOR_PRODUCT_REPORT_EXCEPTION);
    }

}
