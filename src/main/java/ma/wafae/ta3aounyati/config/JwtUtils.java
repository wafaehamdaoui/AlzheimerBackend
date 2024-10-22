package ma.wafae.ta3aounyati.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import ma.wafae.ta3aounyati.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtils {
    //@Value("${auth.jwt.signing.key}")
    private String jwtSigningKey = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970" ;
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public boolean hasClaim(String token, String claimName){
        final Claims claims = extractAllClaims(token);
        return claims.get(claimName) != null;
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSigningKey)
                .parseClaimsJws(token)
                .getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }

    public String generateToken(User userDetails){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, User user) {
        return Jwts.builder().setClaims(claims)
                .setSubject(user.getUsername())
                .claim("authorities", user.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ TimeUnit.HOURS.toMillis(200)))
                .signWith(SignatureAlgorithm.HS256, jwtSigningKey).compact();
    }

    public Boolean isTokenValidate(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

}

