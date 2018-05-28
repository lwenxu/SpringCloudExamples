package lwen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
@MapperScan("lwen.dao")
public class DeptHystrixApp8003 {
    public static void main(String[] args) {
        SpringApplication.run(DeptHystrixApp8003.class, args);
    }
}
