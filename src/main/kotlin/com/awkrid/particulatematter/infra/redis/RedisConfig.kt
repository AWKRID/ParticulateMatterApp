package com.awkrid.particulatematter.infra.redis

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig(
    @Value("\${redis.host}") private val host: String,
    @Value("\${redis.port}") private val port: Int,
) {

    @Bean
    fun redisConnectionFactory(): LettuceConnectionFactory {
        return LettuceConnectionFactory(host, port)
    }

    @Bean
    fun redisTemplate(redisConnectionFactory: RedisConnectionFactory): RedisTemplate<String, String> {
        val template = RedisTemplate<String, String>()
        template.connectionFactory = redisConnectionFactory

        template.keySerializer = StringRedisSerializer()
        template.valueSerializer = StringRedisSerializer()

        template.hashKeySerializer = StringRedisSerializer()
        template.hashValueSerializer = StringRedisSerializer()

        return template
    }
}