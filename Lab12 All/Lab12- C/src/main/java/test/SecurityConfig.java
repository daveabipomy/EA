package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;
import javax.ws.rs.HttpMethod;

@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.jdbcAuthentication()
//                .usersByUsernameQuery("select username, password, 1 from user where username=?")
//                .authoritiesByUsernameQuery("select u.username, r.name from user u inner join user_authority ur on(u.id=ur.user_id) inner join authority r on(ur.authority_id=r.id) where u.username=?")
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder());

        auth.jdbcAuthentication()
                .dataSource(dataSource);
//                .withDefaultSchema();


    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
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