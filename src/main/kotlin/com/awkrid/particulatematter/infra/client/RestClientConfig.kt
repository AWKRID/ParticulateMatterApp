package com.awkrid.particulatematter.infra.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig {

    @Bean
    fun restClient(): RestClient {
        return RestClient.builder()
            .messageConverters {
                it.add(MarshallingHttpMessageConverter())
            }
            .build()
    }
}