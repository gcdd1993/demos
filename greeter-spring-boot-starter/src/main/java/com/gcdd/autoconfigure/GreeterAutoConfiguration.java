package com.gcdd.autoconfigure;

import com.gcdd.library.greet.Greeter;
import com.gcdd.library.greet.GreetingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.gcdd.library.greet.GreeterConfigParams.*;

/**
 * @author gaochen
 * @date 2019/3/18
 */
@Configuration
@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(GreeterProperties.class)
public class GreeterAutoConfiguration {
    @Autowired
    private GreeterProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreetingConfig greeterConfig() {

        String userName = greeterProperties.getUserName() == null
                ? System.getProperty("user.name")
                : greeterProperties.getUserName();
        GreetingConfig greetingConfig = new GreetingConfig();
        greetingConfig.put(USER_NAME, userName);
        if (greeterProperties.getMorningMessage() != null) {
            greetingConfig.put(MORNING_MESSAGE, greeterProperties.getMorningMessage());
        }
        if (greeterProperties.getAfternoonMessage() != null) {
            greetingConfig.put(AFTERNOON_MESSAGE, greeterProperties.getAfternoonMessage());
        }
        if (greeterProperties.getEveningMessage() != null) {
            greetingConfig.put(EVENING_MESSAGE, greeterProperties.getEveningMessage());
        }
        if (greeterProperties.getNightMessage() != null) {
            greetingConfig.put(NIGHT_MESSAGE, greeterProperties.getNightMessage());
        }

        return greetingConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greeter greeter(GreetingConfig greetingConfig) {
        return new Greeter(greetingConfig);
    }
}
