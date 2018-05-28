package lwen.rules;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRuleConfig {
    @Bean
    public IRule iRule() {
        // return new MyLBRule1();
        // return new RandomRule();
        return new RandomRule_ZY();

    }
}
