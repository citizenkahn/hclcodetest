package com.petedkahn.app

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

import javax.inject.Named

/**
 * Created by pkahn on 3/14/17.
 */

@Configuration
class ApplicationConfig {
    @Named
    static class JerseyConfig extends ResourceConfig {
        JerseyConfig() {
            this.packages("com.peterdkahn.rest")
        }
    }

    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate()
        return restTemplate
    }
}
