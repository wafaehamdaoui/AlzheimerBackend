package ma.wafae.ta3aounyati.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.wafae.ta3aounyati.exceptions.ResourceNotFound;
import ma.wafae.ta3aounyati.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader(AUTHORIZATION);
        String username ;
        String jwt ;

        if (authHeader==null || !authHeader.startsWith(BEARER)){
            filterChain.doFilter(request,response);
            return;
        }
        jwt = authHeader.substring(7);
        username = jwtUtils.extractUsername(jwt);
        if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails = userRepository.findByUsername(username);
            if (userDetails!=null){
                if (jwtUtils.isTokenValidate(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }
            }else {
                throw new ResourceNotFound("No user found by username: "+username);
            }
        }
        filterChain.doFilter(request,response);
    }
}
