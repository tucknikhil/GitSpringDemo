/**
 * Please refer to https://www.justanalytics.com/guzzle/eula for current EULA
 */
package com.valens.spring.config

import javax.annotation.PostConstruct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.core.convert.ConversionService
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.{HttpSecurity, WebSecurity}
import org.springframework.security.config.annotation.web.configuration.{EnableWebSecurity, WebSecurityConfigurerAdapter}
import org.springframework.security.config.http.SessionCreationPolicy

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig @Autowired()(authenticationManagerBuilder: AuthenticationManagerBuilder,
                                  conversionService: ConversionService) extends WebSecurityConfigurerAdapter {

  override def configure(web: WebSecurity): Unit = {
    web.ignoring()
      .antMatchers(HttpMethod.OPTIONS, "/api/**")
  }

  @Bean
  override def authenticationManager(): AuthenticationManager = super.authenticationManager()

  override def configure(http: HttpSecurity): Unit = {
    http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      .authorizeRequests()
      .antMatchers("/apitest/**").permitAll()
      .antMatchers("/api/**").authenticated()

  }

}