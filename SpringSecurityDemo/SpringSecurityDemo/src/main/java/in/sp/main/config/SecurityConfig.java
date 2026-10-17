package in.sp.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//go with this configuration not the default one
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		//return http.build();
		//this disables the default login page as we have created our own security using @EnableWebSecurity
		return http
		.csrf(customizer -> customizer.disable())
		.authorizeHttpRequests(request -> request.anyRequest().authenticated())//login required
		.httpBasic(Customizer.withDefaults()) //to remove html contents in postman and  then in Postman go to: Authorization → Basic Auth Enter your Spring Security username and password.
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.build();
		//http.formLogin(Customizer.withDefaults());
		//return http.build();
//		Customizer<CsrfConfigurer<HttpSecurity>> custCsrf=new Customizer<CsrfConfigurer<HttpSecurity>>() {
//			
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//				customizer.disable();
//			}
//		};
//		http.csrf(custCsrf);
	}
}
//Spring Security creates a Session
//↓
//Session remembers that you are logged in
//↓
//Next request → Session tells Spring Security you're authenticated.So you are telling Spring Security:
//
//"Don't use that session to remember the login."
/*
 * Simple way to remember
 * 
 * STATEFUL → Server remembers you using a session.
 * 
 * STATELESS → Server does not remember you using a session; each request
 * carries the required authentication information.
 */
//build()->It means "finish the configuration and create the object."