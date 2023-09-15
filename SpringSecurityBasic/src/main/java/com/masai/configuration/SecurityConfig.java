package com.masai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain appSecurityConfig(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) -> auth.requestMatchers("/welcome").permitAll()
				.requestMatchers("/welcome/secured").authenticated()).httpBasic();
		
		return http.build();
	}
	
	/*Creating in memory user. User stored in application. Password encoder is necessary, would not work without that.*/
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
		
		UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("12345").authorities("read").build();
		
		userDetailsService.createUser(admin);
		userDetailsService.createUser(user);
		
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
}
