package com.system.StudentSystemApplication.service;


import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.ExpiredJwtException;

@Service
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private StudentServiceImpl serviceImpl;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                final String authorizationHeader = request.getHeader("token");
                String email = null;
                String token = null;
                if(authorizationHeader!=null){
                    token = authorizationHeader;	
                    try {
                        email = jwtUtil.extractEmail(token);
                    }catch(ExpiredJwtException ex) {
                    	response.setContentType("application/json");
                    	response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                		response.getOutputStream().println("{\"error\": \"Token Expired\"}");
                		response.getOutputStream().close();
                		return;
                    }
                }

                if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
                    UserDetails userDetails = this.serviceImpl.loadUserByUsername(email);
                    if(jwtUtil.validateToken(token, userDetails)){
                        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    }
                }
                filterChain.doFilter(request, response);
        
    }

    
    
}

