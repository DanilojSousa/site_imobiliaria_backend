package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import lombok.Data;

@Data
public class EmailDTO {
    private Long emaCodigo;
    private String emaEmail;
    private String emaSenha;

    public EmailDTO(EmailEntity email) {
        this.emaCodigo = email.getEmaCodigo();
        this.emaEmail = email.getEmaEmail();
        this.emaSenha = email.getEmaSenha();
    }
}
