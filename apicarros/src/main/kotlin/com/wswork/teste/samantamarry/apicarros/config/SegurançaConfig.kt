package com.wswork.teste.samantamarry.apicarros.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer

@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@Configuration
class SegurançaConfig : WebSecurityConfigurerAdapter() {
    @Value("\${seguranca.config.username}")
    private val username: String? = null

    @Value("\${seguranca.config.password}")
    private val password: String? = null

    @Value("\${seguranca.config.roles}")
    private val roles: String? = null


    @Bean
    @Throws(Exception::class)
    protected override fun authenticationManager(): AuthenticationManager {
        return super.authenticationManager()
    }

    @Throws(Exception::class)
    protected override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser(username)
            .password(password)
            .roles(roles)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return NoOpPasswordEncoder.getInstance()
    }
}