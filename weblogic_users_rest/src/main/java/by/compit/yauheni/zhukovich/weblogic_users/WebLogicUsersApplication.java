package by.compit.yauheni.zhukovich.weblogic_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(scanBasePackages = "by.compit.yauheni.zhukovich", exclude = JmxAutoConfiguration.class)
public class WebLogicUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLogicUsersApplication.class, args);
    }

}
