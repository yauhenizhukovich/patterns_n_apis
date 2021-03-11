package by.compit.yauheni.zhukovich.business_initiative.service.connection;

import java.util.ResourceBundle;

class WebLogicPropertiesReader {

    private static final String RESOURCE_BUNDLE_FILE = "application";

    private static final WebLogicPropertiesReader instance = new WebLogicPropertiesReader();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_FILE);

    private WebLogicPropertiesReader() {}

    static WebLogicPropertiesReader getInstance() {
        return instance;
    }

    String getKey(String key) {
        return resourceBundle.getString(key);
    }
}
