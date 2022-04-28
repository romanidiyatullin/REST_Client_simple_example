package com.idiyrom.rest.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.idiyrom.rest.client")
public class SpringConfiguration {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
