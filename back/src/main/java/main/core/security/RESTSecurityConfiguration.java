package main.core.security;

import main.util.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class RESTSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    private RESTAuthenticationFailureHandler authenticationFailureHandler;
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    private CORSFilter filter;

    @Autowired
    public RESTSecurityConfiguration(
            final RESTAuthenticationEntryPoint authenticationEntryPoint, final RESTAuthenticationFailureHandler authenticationFailureHandler, PasswordEncoder passwordEncoder,
            final RESTAuthenticationSuccessHandler authenticationSuccessHandler, final CORSFilter filter, final UserDetailsService userDetailsService) {
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFailureHandler = authenticationFailureHandler;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
        this.filter = filter;
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder builder) throws Exception {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        builder.authenticationProvider(authProvider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/user/**").authenticated();
        http.addFilterBefore(filter, ChannelProcessingFilter.class);
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);
    }
}
