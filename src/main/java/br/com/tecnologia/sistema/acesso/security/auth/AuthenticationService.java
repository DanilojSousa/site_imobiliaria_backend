package br.com.tecnologia.sistema.acesso.security.auth;

import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import br.com.tecnologia.sistema.acesso.security.DTO.AuthenticationRequest;
import br.com.tecnologia.sistema.acesso.security.DTO.AuthenticationResponse;
import br.com.tecnologia.sistema.acesso.security.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService{
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                request.login(),
                                request.password()));
        UsuarioEntity usuario = (UsuarioEntity) user.getPrincipal();

        Optional.of(usuario).filter(f -> !f.getUsrDelete())
                            .orElseThrow(() -> new IllegalStateException("Usuário não existe"));
        Optional.of(usuario).filter(f -> f.getSituacao().getStcCodigo() == 1)
                            .orElseThrow(() -> new IllegalStateException("Usuário está inativo"));

        var jwtToken = tokenService.generateToken(usuario);
        return new AuthenticationResponse(jwtToken,
                                         ((UsuarioEntity)user.getPrincipal()).getUsrLogin(),
                                         ((UsuarioEntity)user.getPrincipal()).getRole().toString());
    }
}