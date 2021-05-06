package com.ipsas.WebService.Security;

import com.ipsas.WebService.Enums.Role;
import com.ipsas.WebService.Services.UserPrincipalDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserPrincipalDetailsService userPrincipalDetailsService;

    public WebSecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth
                .authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/v1/florists/**").hasRole("ADMIN")
                .antMatchers("/api/v1/clients/**").hasRole("ADMIN")
                .antMatchers("/api/v1/flowers/").hasAnyRole("CLIENT","FLORIST","ADMIN")
                .antMatchers("/api/v1/flowers/**").hasAnyRole("FLORIST","ADMIN")
                .antMatchers("/api/v1/bouquets/").hasAnyRole("CLIENT","FLORIST","ADMIN")
                .antMatchers("/api/v1/bouquets/**").hasAnyRole("FLORIST","ADMIN")
                .antMatchers("/api/v1/commandes/").hasAnyRole("CLIENT","FLORIST","ADMIN")
                .antMatchers("/api/v1/commandes/**").hasAnyRole("FLORIST","ADMIN")
                .anyRequest().authenticated()
                .and()
               .httpBasic();
        http.csrf().disable();
    }

    @Bean
    PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(PasswordEncoder());

        return daoAuthenticationProvider;
    }

}
