package lwen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class DeptZuul9527 {
    public static void main(String[] args) {
        SpringApplication.run(DeptZuul9527.class, args);
    }
}
