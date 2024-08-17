package br.com.tecnologia.sistema.acesso.security.token;

import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import br.com.tecnologia.sistema.pessoa.service.EmailService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    @Autowired
    private EmailService emailService;
    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private String jwtExpiration;

    public String generateToken(UsuarioEntity usuario){
        try {
            EmailEntity userMail = emailService.getPrincipalPorUsrCodigo(usuario.getUsrCodigo());
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                      .withIssuer("auth-api")
                      .withSubject(userMail.getEmaEmail())
                      .withExpiresAt(genExpirationDate())
                      .sign(algorithm);
        }catch (JWTCreationException e){
            throw new RuntimeException("Erro ao gerar o token - "+ e);
        }
    }
    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.require(algorithm)
                      .withIssuer("auth-api")
                      .build()
                      .verify(token)
                      .getSubject();

        }catch (JWTVerificationException e) {
            return "";
        }

    }

    private Instant genExpirationDate(){
        return LocalDateTime.now()
                            .plusSeconds(Long.parseLong(jwtExpiration) / 1000)
                            .toInstant(ZoneOffset.of("-03:00"));
    }
}


