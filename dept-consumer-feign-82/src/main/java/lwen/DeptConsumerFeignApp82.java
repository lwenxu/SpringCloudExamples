package lwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients("lwen.service")
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumerFeignApp82 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeignApp82.class, args);
    }
}
