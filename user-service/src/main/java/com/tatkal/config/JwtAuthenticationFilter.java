package com.tatkal.config;

import com.tatkal.user_service.CustomUserDetailsService;
import com.tatkal.utility.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    // private final AntPathMatcher pathMatcher = new AntPathMatcher();

    private final JwtUtil jwtUtils;
    private final CustomUserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtUtil jwtUtils, CustomUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        System.out.println("🔥 JwtAuthenticationFilter: Inside doFilterInternal"+path);

        return path.equals("/api/users/login") ||
               path.equals("/api/users/register") ||
               path.equals("/test/check");
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
                System.out.println("🔥 JwtAuthenticationFilter: Inside doFilterInternal");

                String path = request.getRequestURI();
                
                System.out.println("URI Path:" + path);
                

// Skip JWT processing for public endpoints
// if (pathMatcher.match("/api/users/register", path) ||
// pathMatcher.match("/api/users/login", path) ||
// pathMatcher.match("/test/**", path)) {
// chain.doFilter(request, response);
// return;
// }

if (shouldNotFilter(request)) {
    chain.doFilter(request, response);
    return;
}

        String token = extractJwtFromRequest(request);
        if (token != null) {
            try {
                String username = jwtUtils.extractClaims(token).getSubject();  // Extract username
                if (jwtUtils.validateToken(token, username)) {  // Pass both parameters
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                System.out.println("JWT Authentication failed: " + e.getMessage());  // Logging for debugging
            }
        }
        chain.doFilter(request, response);
    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
