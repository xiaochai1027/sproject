package com.cfc.commons.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther fangchen.chai ON 2018/1/24
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue Queue(){
        return new Queue("hello");
    }

}
