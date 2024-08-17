package br.com.tecnologia.sistema.acesso.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioAlterarSenhaDTO {

    private Long usrCodigo;
    private String usrPassword;
}
