package in.sp.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	//Spring finds your implementation:MyUserDetailsService
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
		.csrf(customizer -> customizer.disable())
		.authorizeHttpRequests(request -> request.anyRequest().authenticated())//login required
		.httpBasic(Customizer.withDefaults()) //to remove html contents in postman and  then in Postman go to: Authorization → Basic Auth Enter your Spring Security username and password.
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.build();
		//http.formLogin(Customizer.withDefaults());
		
	}
//	@Bean
//	public UserDetailsService userDetailService() {
//		UserDetails user1=User
//				//UserDetails is an interface and User implements that
//				.withDefaultPasswordEncoder()
//				.username("joshu")
//				.password("josh@123")
//				.roles("USER")
//				.build();
//		UserDetails user2=User
//				//UserDetails is an interface and User implements that
//				.withDefaultPasswordEncoder()
//				.username("tanvi")
//				.password("tan@123")
//				.roles("ADMIN")
//				.build();
//		return new InMemoryUserDetailsManager(user1, user2);//UserDetailsService is an interface and InMemoryUserDetailsManager() implements that
		//hard coded values
	
	//for database connectivity
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider(userDetailsService);
		//Get the user's details from UserDetailsService, then check the password."
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());//dont use any passwordEncoder
//		provider.setUserDetailsService(userDetailsService);
		return provider;
		
		
		
//		.httpBasic(Customizer.withDefaults())-This tells Spring Security:"For authentication, accept username and password through HTTP Basic Authentication."
	
	}
}
