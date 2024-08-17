package br.com.tecnologia.sistema.acesso.security.auth;

import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import br.com.tecnologia.sistema.acesso.security.DTO.AuthenticationRequest;
import br.com.tecnologia.sistema.acesso.security.DTO.AuthenticationResponse;
import br.com.tecnologia.sistema.acesso.security.token.TokenService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
