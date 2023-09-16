/**
 * 
 */
package com.sada.jpacrud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.sada.jpacrud.RequestFilter;
import com.sada.jpacrud.service.UserRoleService;

/**
 * @author sadanand chavan
 *
 * Nov 13, 2022 1:31:06 PM
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	Logger logger   = LoggerFactory.getLogger(SecurityConfig.class);


	@Autowired
	private RequestFilter requestFilter;
	@Autowired
	private UserRoleService service;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("SecurityConfig success");

		//Below code is working without auth
		
		http.authorizeRequests(authorizeRequests ->
        authorizeRequests.anyRequest().permitAll());
		 
		


		/*
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/api/v1/sp/sp", "/api/v1/sp/spLogin","/home","/api/v1/sp/sp","/api/v1/user/user","/api/v1/user/userLogin",
				"/index.html","/static/**").permitAll()
		.anyRequest().authenticated()
		.and().exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/index.html", "/", "/home", "/api/v1/serviceprovider/login").permitAll()
		.anyRequest().authenticated();
		
		*/
		


	}
	/*
	 public void addCorsMappings(CorsRegistry registry) {
		 logger.info("addCorsMappings success");
	        registry.addMapping("/**")
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //or whichever methods you want to allow
	                .allowedOrigins("*") //or www.example.com if you want to be more specific
	                .allowedHeaders("Content_Type", "Authorization"); //i also put Authorization since i saw you probably want to do so
	    }
	 */
	
	 @Override
     public void configure(WebSecurity web) throws Exception {
         web
                 .ignoring()
                 .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**","/vendor/**","/fonts/**");
     }
}
