package by.compit.yauheni.zhukovich.business_initiative.config;

import java.lang.invoke.MethodHandles;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.MODEL_PACKAGE;

@Configuration
public class DatabaseConfig {

    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan(MODEL_PACKAGE);
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        logger.info("Entity manager bean initialized and ready to use.");
        return entityManager;
    }

}
