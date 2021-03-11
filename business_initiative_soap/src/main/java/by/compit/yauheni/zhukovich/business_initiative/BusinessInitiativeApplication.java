package by.compit.yauheni.zhukovich.business_initiative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.BASE_PACKAGES;

@SpringBootApplication(scanBasePackages = BASE_PACKAGES, exclude = JmxAutoConfiguration.class)
public class BusinessInitiativeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessInitiativeApplication.class, args);
    }

}
