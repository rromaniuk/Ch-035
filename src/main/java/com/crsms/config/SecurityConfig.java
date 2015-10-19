package com.crsms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("admin@gmail.com").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("student@gmail.com").password("student").roles("STUDENT");
		auth.inMemoryAuthentication().withUser("teacher@gmail.com").password("teacher").roles("TEACHER");
		auth.inMemoryAuthentication().withUser("manager@gmail.com").password("manager").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("anonymous@gmail.com").password("anonymous").roles("ANONYMOUS");
		
//		.userDetailsService(userDetailsService);
//		.passwordEncoder(passwordEncoder());
		
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
			.antMatchers("/admin/**")
				.access("hasRole('ROLE_ADMIN')")
				.and()
				.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				.logout()
				.logoutSuccessUrl("/login?logout")
				.and()
				.csrf()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/403")
				.and()
				.formLogin()  
		        .loginPage("/login")
		        .permitAll();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}