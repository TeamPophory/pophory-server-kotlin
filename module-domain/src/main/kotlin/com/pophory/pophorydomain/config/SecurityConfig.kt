package com.pophory.pophorydomain.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic().disable()
            .formLogin().disable()
            .csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests()
            .requestMatchers("/health").permitAll()
            .anyRequest().permitAll()
            .and()
            .build()
    }
}