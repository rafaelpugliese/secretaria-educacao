package com.fat.pweb2.gestaofesta.config;

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

                // Define que para acessar todas as páginas deve estar autenticado
                .anyRequest().authenticated()

                .and().formLogin()

                // Define a página de login
                .loginPage("/loginfat").permitAll()

                // Define qual url o springsecurity utilizará para realizar o login
                .loginProcessingUrl("/entrar")

                // Define qual a url que será utilizada para o login com sucesso, definindo que sempre será redirecionado
                .defaultSuccessUrl("/convidados/listar", true)

                // Define qual url será redirecionado quando ocorrer um erro no login (erro de login e senha por exemplo)
                .failureUrl("/errologin")

                // Define a url de logout
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                // Define qual url o usuário será redirecionado em caso de sucesso
                .logoutSuccessUrl("/loginfat").permitAll()

                // Deleta variável da sessão onde armazena o ID da sessão
                .deleteCookies("JSESSIONID")

                // Invalida sessão
                .invalidateHttpSession(true);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // ignora as url para acesso, geralmente são adicionadas outras urls como /css/**, /img/** ...
        web.ignoring().antMatchers("/lib/**");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()

                // Adiciona o usuário pedro em memória
                .withUser("pedro").password("{noop}teste").roles("ADMIN")

                .and()

                // Adiciona o usuário felipe em memória
                .withUser("felipe").password("{noop}teste").roles("USER");
    }

}
