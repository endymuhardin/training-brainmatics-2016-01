package com.braimatics.training;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, enabled from s_user where username = ?")
                .authoritiesByUsernameQuery("select s_user.username, s_permission.nama as authority\n"
                        + "from s_user inner join s_user_group on s_user.id = s_user_group.id_user\n"
                        + "inner join s_group on s_user_group.id_group = s_group.id\n"
                        + "inner join s_group_permission on s_group.id = s_group_permission.id_group\n"
                        + "inner join s_permission on s_permission.id = s_group_permission.id_permission\n"
                        + "where s_user.username = ?");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/materi/list").hasRole("VIEW_MATERI")
                .antMatchers("/materi/form").hasRole("EDIT_MATERI")
                .anyRequest().authenticated()
                .and()
                .logout()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/materi/list")
                .permitAll();
    }
}
