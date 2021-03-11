package by.compit.yauheni.zhukovich.entity_to_docx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(scanBasePackages = "by.compit.yauheni.zhukovich.entity_to_docx", exclude = JmxAutoConfiguration.class)
public class EntityToDocxApplication {

    public static void main(String[] args) {
        SpringApplication.run(EntityToDocxApplication.class, args);
    }

}
