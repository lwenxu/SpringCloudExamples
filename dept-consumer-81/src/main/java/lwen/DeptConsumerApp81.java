package lwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import rules.MyRuleConfig;

// @RibbonClient(name = "CLOUD-DEPT")
@RibbonClient(name = "CLOUD-DEPT",configuration = MyRuleConfig.class)
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumerApp81 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerApp81.class, args);
    }
}
