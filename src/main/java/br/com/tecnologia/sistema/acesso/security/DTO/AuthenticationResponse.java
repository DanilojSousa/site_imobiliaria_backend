package br.com.tecnologia.sistema.acesso.security.DTO;

public record AuthenticationResponse(String token, String usrLogin, String role) {
}
