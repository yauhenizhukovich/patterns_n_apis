package by.compit.yauheni.zhukovich.weblogic_users.service.connection;

import java.io.Closeable;
import java.io.IOException;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.modelmbean.ModelMBeanInfo;

public class ConnectionSQLAuthMethod implements Closeable, AutoCloseable {

    private static final String USER_EDITOR_MBEAN_CLASS = "weblogic.management.security.authentication.UserEditorMBean";

    private final WebLogicConnector webLogicConnector;

    public ConnectionSQLAuthMethod() throws MalformedObjectNameException, InstanceNotFoundException, IOException, ReflectionException, AttributeNotFoundException, MBeanException {
        webLogicConnector = new WebLogicConnector();
    }

    public MBeanServerConnection getConnection() {
        return webLogicConnector.getConnection();
    }

    public ObjectName getUserEditor() throws IntrospectionException, ReflectionException, InstanceNotFoundException, IOException, MBeanException {
        ObjectName userEditor = null;
        ObjectName[] atnProviders = webLogicConnector.getAtnProviders();
        ObjectName mBeanTypeService = webLogicConnector.getMBeanTypeService();
        MBeanServerConnection connection = webLogicConnector.getConnection();
        for (ObjectName provider : atnProviders) {
            if (userEditor == null) {
                ModelMBeanInfo info = (ModelMBeanInfo) connection.getMBeanInfo(provider);
                String className = (String) info.getMBeanDescriptor().getFieldValue("interfaceClassName");
                if (className != null) {
                    String[] beans = (String[]) connection.invoke(mBeanTypeService,
                            "getSubtypes",
                            new Object[] {USER_EDITOR_MBEAN_CLASS},
                            new String[] {"java.lang.String"}
                    );
                    for (String bean : beans) {
                        if (bean.equals(className)) {
                            userEditor = provider;
                        }
                    }
                }
            }
        }
        return userEditor;
    }

    @Override
    public void close() throws IOException {
        webLogicConnector.close();
    }

}
