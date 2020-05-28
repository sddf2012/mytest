package my.test;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liu peng bo
 * date: 2020/5/28 16:37
 */

@Configuration
public class TestAutoConfig {

    @Bean
    @ConditionalOnProperty(value = "testAutoConfig.testBean")
    public TestBean testBean() {
        return new TestBean();
    }
}
