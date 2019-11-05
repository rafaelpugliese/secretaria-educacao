package com.fat.pweb2.secretaria.educacao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()

                .anyRequest().authenticated()

                .and().formLogin()

                .loginPage("/loginSecretaria").permitAll()

                .loginProcessingUrl("/entrar")

                .defaultSuccessUrl("/home", true)

                .failureUrl("/errologin")

                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                .logoutSuccessUrl("/loginSecretaria").permitAll()

                .deleteCookies("JSESSIONID")

                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/lib/**", "/imagem/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()

                .withUser("professor").password("{noop}teste").roles("PROFESSOR")

                .and()

                .withUser("aluno").password("{noop}teste").roles("ALUNO");
    }

}
