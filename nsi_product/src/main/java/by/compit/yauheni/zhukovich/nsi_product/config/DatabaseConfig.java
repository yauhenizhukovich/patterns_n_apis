package by.compit.yauheni.zhukovich.nsi_product.config;

import java.util.Properties;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class DatabaseConfig {

    @Autowired
    Environment env;
    @Value("${spring.primary.hibernate.dialect}")
    private String dialect;

    @Primary
    @Bean(name = "ctlDataSource", destroyMethod = "")
    @ConfigurationProperties(prefix = "spring.primary")
    public DataSource ctlDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName(env.getProperty("spring.primary.jndi-name"));
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
        //                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //                dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        //                dataSourceBuilder.url("jdbc:oracle:thin:@10.0.0.238:1521/orclpdb");
        //                dataSourceBuilder.username("ctl");
        //                dataSourceBuilder.password("ctl");
        //                return dataSourceBuilder.build();
    }

    @Primary
    @Bean(name = "ctlEntityManager")
    public LocalContainerEntityManagerFactoryBean ctlEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("ctlDataSource") DataSource ds) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        LocalContainerEntityManagerFactoryBean em = builder
                .dataSource(ds)
                .packages("by.compit.yauheni.zhukovich.nsi_product.repository.model.ctl")
                .persistenceUnit("ctlPU")
                .build();
        em.setJpaProperties(properties);
        return em;
    }

    @Bean(name = "nsiDataSource", destroyMethod = "")
    @ConfigurationProperties(prefix = "spring.secondary")
    public DataSource nsiDataSource() throws NamingException {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName(env.getProperty("spring.secondary.jndi-name"));
        bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
        return (DataSource) bean.getObject();
        //                DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //                dataSourceBuilder.driverClassName("oracle.jdbc.driver.OracleDriver");
        //                dataSourceBuilder.url("jdbc:oracle:thin:@10.0.0.238:1521/orclpdb");
        //                dataSourceBuilder.username("nsi");
        //                dataSourceBuilder.password("NSI");
        //                return dataSourceBuilder.build();
    }

    @Bean(name = "nsiEntityManager")
    public LocalContainerEntityManagerFactoryBean nsiEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("nsiDataSource") DataSource ds) {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        LocalContainerEntityManagerFactoryBean em = builder
                .dataSource(ds)
                .packages("by.compit.yauheni.zhukovich.nsi_product.repository.model.nsi")
                .persistenceUnit("nsiPU")
                .build();
        em.setJpaProperties(properties);
        return em;
    }

}