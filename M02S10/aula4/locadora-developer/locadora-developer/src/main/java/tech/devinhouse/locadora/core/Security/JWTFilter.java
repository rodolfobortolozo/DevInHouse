package tech.devinhouse.locadora.core.Security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {
  private  final JWTUtil jwtUtil;
  private final MyUserDetailsService userDetailsService;

  public JWTFilter(JWTUtil jwtUtil, MyUserDetailsService userDetailsService) {
    this.jwtUtil = jwtUtil;
    this.userDetailsService = userDetailsService;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain)
          throws ServletException, IOException {


    String authHeader = request.getHeader("Authorization");


    if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){

      String jwt = authHeader.substring(7);
      if(jwt == null || jwt.isBlank()){

        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "JWT Token no Bearer Header Inválido");
      }else {
        try{
          // Verify token and extract email
          String email = jwtUtil.validateTokenAndRetrieveSubject(jwt);

          UserDetails userDetails = userDetailsService.loadUserByUsername(email);

          UsernamePasswordAuthenticationToken authToken =
                  new UsernamePasswordAuthenticationToken(email, userDetails.getPassword(), userDetails.getAuthorities());

          if(SecurityContextHolder.getContext().getAuthentication() == null){
            SecurityContextHolder.getContext().setAuthentication(authToken);
          }
        }catch(JWTVerificationException exc){
          response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Token Inválido");
        }
      }
    }

    filterChain.doFilter(request, response);
  }
}
