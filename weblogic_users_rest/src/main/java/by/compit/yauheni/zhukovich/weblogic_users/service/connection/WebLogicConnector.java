package by.compit.yauheni.zhukovich.weblogic_users.service.connection;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.naming.Context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

class WebLogicConnector implements Closeable, AutoCloseable {

    private static final String DOMAIN_RUNTIME_SERVICE_MBEAN_CLASS = "com.bea:Name=DomainRuntimeService,Type=weblogic.management.mbeanservers.domainruntime.DomainRuntimeServiceMBean";
    private static final String MBEAN_TYPE_SERVICE_CLASS = "com.bea:Name=MBeanTypeService,Type=weblogic.management.mbeanservers.MBeanTypeService";
    private static final String DOMAIN_CONFIGURATION_ATTRIBUTE = "DomainConfiguration";
    private static final String SECURITY_CONFIGURATION_ATTRIBUTE = "SecurityConfiguration";
    private static final String DEFAULT_REALM_ATTRIBUTE = "DefaultRealm";
    private static final String AUTHENTICATION_PROVIDERS_ATTRIBUTE = "AuthenticationProviders";

    private final JMXConnector connector;
    private final ObjectName mBeanTypeService;
    private final ObjectName[] atnProviders;
    private final MBeanServerConnection connection;

    public WebLogicConnector() throws IOException, MalformedObjectNameException, AttributeNotFoundException, MBeanException, ReflectionException, InstanceNotFoundException {
        String hostname;
        String port;
        String username;
        String password;
        try (InputStream input = WebLogicConnector.class.getClassLoader().getResourceAsStream("weblogic.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            hostname = prop.getProperty("hostname");
            port = prop.getProperty("port");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
        }
        JMXServiceURL serviceURL = new JMXServiceURL("t3", hostname,
                Integer.parseInt(port), "/jndi/weblogic.management.mbeanservers.domainruntime");
        Hashtable<String, String> h = new Hashtable<>();
        h.put(Context.SECURITY_PRINCIPAL, username);
        h.put(Context.SECURITY_CREDENTIALS, password);
        h.put(JMXConnectorFactory.PROTOCOL_PROVIDER_PACKAGES, "weblogic.management.remote");
        connector = JMXConnectorFactory.connect(serviceURL, h);
        connection = connector.getMBeanServerConnection();
        ObjectName service = new ObjectName(DOMAIN_RUNTIME_SERVICE_MBEAN_CLASS);
        mBeanTypeService = new ObjectName(MBEAN_TYPE_SERVICE_CLASS);
        ObjectName domainMBean = (ObjectName) connection.getAttribute(service, DOMAIN_CONFIGURATION_ATTRIBUTE);
        ObjectName securityConfiguration = (ObjectName) connection.getAttribute(domainMBean, SECURITY_CONFIGURATION_ATTRIBUTE);
        ObjectName defaultRealm = (ObjectName) connection.getAttribute(securityConfiguration, DEFAULT_REALM_ATTRIBUTE);
        atnProviders = (ObjectName[]) connection.getAttribute(defaultRealm, AUTHENTICATION_PROVIDERS_ATTRIBUTE);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Override
    public void close() throws IOException {
        connector.close();
    }

    ObjectName getMBeanTypeService() {
        return mBeanTypeService;
    }

    ObjectName[] getAtnProviders() {
        return atnProviders;
    }

    MBeanServerConnection getConnection() {
        return connection;
    }

}
