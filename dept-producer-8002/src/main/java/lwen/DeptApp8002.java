package lwen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("lwen.dao")
public class DeptApp8002 {
    public static void main(String[] args) {
        SpringApplication.run(DeptApp8002.class, args);
    }
}