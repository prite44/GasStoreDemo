package com.GasStore.app.Config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private UserDetailsService userService;
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login","/signup","/signup/**").permitAll()
		.antMatchers(HttpMethod.POST,"/signup").permitAll()
		.antMatchers("/test","/customer/**","/inventory/**","/receipt/**","/private/**").hasAuthority("ADMIN")
		.antMatchers(HttpMethod.POST,"/customer/**","/inventory/**","/receipt/**").hasAuthority("ADMIN")
		.anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login").failureUrl("/login?error").and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		 http.csrf().disable();
		// go accessDeniedPage
		/* .and().exceptionHandling().accessDeniedPage("/403"); */
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/public/**");
	}

}
