package by.belinvest.panel.admin.config;

import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@EnableCaching
public class DataSourceConfiguration {

    @Bean(name = "catalogDatasource", destroyMethod = "")
    public DataSource catalogDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/belinvestbankCTL");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
//                        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//                        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//                        dataSourceBuilder.url("jdbc:oracle:thin:@//10.0.0.238:1521/orclpdb");
//                        dataSourceBuilder.username("ctl");
//                        dataSourceBuilder.password("ctl");
//                        return dataSourceBuilder.build();
    }

    @Bean(name = "settings", destroyMethod = "")
    public DataSource settingsDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/belinvestbankNSI");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
//                        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//                        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//                        dataSourceBuilder.url("jdbc:oracle:thin:@//10.0.0.238:1521/orclpdb");
//                        dataSourceBuilder.username("nsi");
//                        dataSourceBuilder.password("NSI");
//                        return dataSourceBuilder.build();
    }

    @Bean(name = "nsiDatasource", destroyMethod = "")
    public DataSource nsiDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/belinvestbankNSI");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
//                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//                dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//                dataSourceBuilder.url("jdbc:oracle:thin:@//10.0.0.238:1521/orclpdb");
//                dataSourceBuilder.username("nsi");
//                dataSourceBuilder.password("NSI");
//                return dataSourceBuilder.build();
    }

    @Bean(name = "auditDatasource", destroyMethod = "")
    public DataSource auditDataSource() throws NamingException, SQLException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/belinvestbankAUDIT_CTL");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
//                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//                dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
//                dataSourceBuilder.url("jdbc:oracle:thin:@//10.0.0.238:1521/orclpdb");
//                dataSourceBuilder.username("audit_ctl");
//                dataSourceBuilder.password("audit_ctl");
//                return dataSourceBuilder.build();
    }

    /*@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("listbi");
    }*/
}
