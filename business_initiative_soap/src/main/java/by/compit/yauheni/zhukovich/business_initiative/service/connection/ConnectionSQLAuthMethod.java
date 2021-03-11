package by.compit.yauheni.zhukovich.business_initiative.service.connection;

import java.io.Closeable;
import java.io.IOException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.modelmbean.ModelMBeanInfo;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.WebLogicException;

public class ConnectionSQLAuthMethod implements Closeable, AutoCloseable {

    private static final String GET_SUBTYPES_METHOD = "getSubtypes";
    private static final String USER_EDITOR_MBEAN_CLASS = "weblogic.management.security.authentication.UserEditorMBean";
    private static final String STRING_CLASS = "java.lang.String";
    private static final String INTERFACE_CLASS_NAME = "interfaceClassName";

    private final WebLogicConnector webLogicConnector;

    public ConnectionSQLAuthMethod() throws WebLogicException {
        webLogicConnector = new WebLogicConnector();
    }

    public MBeanServerConnection getConnection() {
        return webLogicConnector.getConnection();
    }

    public ObjectName getUserEditor() throws WebLogicException {

        ObjectName userEditor = null;
        ObjectName[] atnProviders = webLogicConnector.getAtnProviders();
        ObjectName mBeanTypeService = webLogicConnector.getMBeanTypeService();
        MBeanServerConnection connection = webLogicConnector.getConnection();
        try {
            for (ObjectName provider : atnProviders) {
                if (userEditor == null) {
                    ModelMBeanInfo info = (ModelMBeanInfo) connection.getMBeanInfo(provider);
                    String className = (String) info.getMBeanDescriptor().getFieldValue(INTERFACE_CLASS_NAME);
                    if (className != null) {
                        String[] beans = (String[]) connection.invoke(mBeanTypeService,
                                GET_SUBTYPES_METHOD,
                                new Object[] {USER_EDITOR_MBEAN_CLASS},
                                new String[] {STRING_CLASS}
                        );
                        for (String bean : beans) {
                            if (bean.equals(className)) {
                                userEditor = provider;
                            }
                        }
                    }
                }
            }
        } catch (IOException | ReflectionException | IntrospectionException | InstanceNotFoundException | MBeanException e) {
            throw new WebLogicException(e);
        }

        return userEditor;
    }

    @Override
    public void close() throws IOException {
        webLogicConnector.close();
    }

}
