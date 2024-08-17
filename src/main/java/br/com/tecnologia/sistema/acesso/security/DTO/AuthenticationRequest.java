package br.com.tecnologia.sistema.acesso.security.DTO;

public record AuthenticationRequest(
        String login,
        String password) {
}
