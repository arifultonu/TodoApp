package com.smefinance.todoapp.securityconfiguration.basicAuth;


import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

//@Override
//protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests((requests) -> {
//        ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated().antMatchers(HttpMethod.OPTIONS, "/**");
//    });
    //http.formLogin();
    //http.httpBasic();
//    http
//            .csrf().disable()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated().and().httpBasic();
//
//
//
//
//}

}
