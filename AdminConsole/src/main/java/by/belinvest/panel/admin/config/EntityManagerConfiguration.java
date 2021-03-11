package by.belinvest.panel.admin.config;

import java.util.Properties;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EntityScan(basePackages = "by.belinvest.panel.admin.entity")
@EnableJpaRepositories(
        basePackages = {"by.belinvest.panel.admin.product.repository"},
        entityManagerFactoryRef = "productHierarchyEntityManagerFactory",
        transactionManagerRef = "productTransactionManager")
public class EntityManagerConfiguration {

    public DataSource dataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("jdbc/belinvestbankCTL");
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
        //        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //        dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        //        dataSourceBuilder.url("jdbc:oracle:thin:@//10.0.0.238:1521/orclpdb");
        //        dataSourceBuilder.username("ctl");
        //        dataSourceBuilder.password("ctl");
        //        return dataSourceBuilder.build();
    }

    @Bean(name = "productHierarchyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean productHierarchyEntityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource());
        entityManager.setPackagesToScan("by.belinvest.panel.admin.entity");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        entityManager.setJpaProperties(properties);
        return entityManager;
    }

    @Bean(name = "productTransactionManager")
    public PlatformTransactionManager productHierarchyTransactionManager() throws NamingException {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(productHierarchyEntityManagerFactory().getObject());
        return jpaTransactionManager;
    }

}
