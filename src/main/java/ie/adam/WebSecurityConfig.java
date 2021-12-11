package ie.adam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**").authenticated()
                .antMatchers( "/", "/student/**").hasAnyRole("MENTOR", "REVIEWER")
                .antMatchers(  "/newstudent", "/newnote", "allstudents/nonote").hasRole("MENTOR")
                .antMatchers(  "/stats",  "/allstudents/over4notes").hasRole("REVIEWER")
                .antMatchers("/myapi/**", "/api/**").hasRole("API")
                .anyRequest().authenticated()
                .and()
                .formLogin() // authenticate by login form
                .and()
                .httpBasic() // and by basic http request
                .and().exceptionHandling().accessDeniedPage("/403");
        http.csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
