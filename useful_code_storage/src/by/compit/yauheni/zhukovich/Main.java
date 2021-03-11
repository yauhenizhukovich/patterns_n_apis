package by.compit.yauheni.zhukovich;

public class Main {

    public static void main(String[] args) {

    }

    /** Spring datasource Oracle DB properties **/
    /*spring.datasource.url=jdbc:oracle:thin:@10.0.0.238:1521/orclpdb
    spring.datasource.username=ctl
    spring.datasource.password=ctl
    spring.datasource.driver-class=oracle.jdbc.driver.OracleDriver*/

    /** WebLogic datasource properties **/
    /*initial.context.factory=weblogic.jndi.WLInitialContextFactory
    provider.url=t3://127.0.0.1:7001
    security.principal=weblogic
    security.credentials=welcome1
    datasource.name=jdbc/belinvestbankCTL2*/

    /** Using WebLogic datasource **/
    /*@Bean
    public DataSource dataSource() throws NamingException {
        Hashtable<String, String> map = new Hashtable<String, String>(7);
        map.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        map.put(Context.PROVIDER_URL, "t3://127.0.0.1:7001");
        map.put(Context.SECURITY_PRINCIPAL, "weblogic");
        map.put(Context.SECURITY_CREDENTIALS, "welcome1");
        InitialContext context = new InitialContext(map);
        return (javax.sql.DataSource) context.lookup("jdbc/belinvestbankCTL2");
    }*/

    /** SOAP with no auto WSDL **/
    /*@Bean(name = "businessOffer")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema businessOfferSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BusinessOfferPort");
        wsdl11Definition.setLocationUri("/soap");
        wsdl11Definition.setTargetNamespace("http://www.example.org");
        wsdl11Definition.setSchema(businessOfferSchema);
        return wsdl11Definition;
    }*/

    /** SOAP with manual WSDL **/
    /*@Bean(name = "businessOfferWsdlBean")
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("businessOffer.wsdl")); //your wsdl location
        return wsdl11Definition;
    }*/

    /** WebLogic datasource old **/
    /*@Primary
    @Bean(name = "dataSource", destroyMethod = "")
    public DataSource dataSource() throws NamingException {
        String initialContextFactory = environment.getProperty("initial.context.factory");
        String providerUrl = environment.getProperty("provider.url");
        String securityPrincipal = environment.getProperty("security.principal");
        String securityCredentials = environment.getProperty("security.credentials");
        String datasourceName = environment.getProperty("datasource.name");
        Hashtable<String, String> map = new Hashtable<>(7);
        map.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
        map.put(Context.PROVIDER_URL, providerUrl);
        map.put(Context.SECURITY_PRINCIPAL, securityPrincipal);
        map.put(Context.SECURITY_CREDENTIALS, securityCredentials);
        InitialContext context = new InitialContext(map);
        return (javax.sql.DataSource) context.lookup(datasourceName);
    }*/

    /** External Datasource by JNDI **/
//    spring.datasource.jndi-name=jdbc/belinvestbankCTL

}
