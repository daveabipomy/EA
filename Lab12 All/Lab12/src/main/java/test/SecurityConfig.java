package test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.ws.rs.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}123").roles("USER","ADMIN").and()
                .withUser("user").password("{noop}123").roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests().antMatchers("/books/add", HttpMethod.GET).hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/books/delete", HttpMethod.GET).hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/books/{id}", HttpMethod.GET).hasRole("ADMIN").and()
                .authorizeRequests().antMatchers(HttpMethod.POST).hasRole("ADMIN").and()
                .authorizeRequests().antMatchers("/books", HttpMethod.GET).hasRole("USER").and()
                .formLogin().permitAll().and()
                .logout();
    }

        @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**").and()
                .debug(true);
    }
}