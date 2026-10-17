package in.sp.main.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import in.sp.main.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter{

	@Autowired 
	private JWTService jwtService;
	//abstract class so we have to implement
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//Bearer token
		String authHeader=request.getHeader("Authorization");
		String token=null;
		String username=null;
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);
			username=jwtService.extractUserName(token);
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
		}
		
		
		
	}

}
