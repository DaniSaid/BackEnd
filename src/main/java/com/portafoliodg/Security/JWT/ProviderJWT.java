package com.portafoliodg.Security.JWT;


import com.portafoliodg.Security.Entity.MainUser;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

//Genera el token y valida si está bien armado

@Component
public class ProviderJWT {
    
    private final static Logger logger = LoggerFactory.getLogger(ProviderJWT.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication){
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername())
                .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }
    
    public String getUserNameFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        //Si el header, el payload o la firma del token no se armaron correctamente entonces..
        catch(MalformedJwtException e){
            logger.error("Token mal formado");
        }
        catch(UnsupportedJwtException e){
            logger.error("Token no soportado");
        }
        catch(ExpiredJwtException e){
            logger.error("Token ha expirado");
        }
        catch(IllegalArgumentException e){
            logger.error("Token vacío");
        }
        catch(SignatureException e){
            logger.error("La firma del token no es válida");
        }
        return false;
    }
}
