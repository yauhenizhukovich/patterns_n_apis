package by.compit.yauheni.zhukovich.nsi_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "by.compit.yauheni.zhukovich.nsi_product")
@EnableSwagger2
public class NsiProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(NsiProductApplication.class, args);
    }

}
