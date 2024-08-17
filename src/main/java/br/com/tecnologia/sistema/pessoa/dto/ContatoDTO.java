package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import lombok.Data;

@Data
public class ContatoDTO {

    private Long cntCodigo;
    private String cntTelefone;
    private String cntWhatsapp;

    public ContatoDTO(ContatoEntity contato) {
        this.cntCodigo = contato.getCntCodigo();
        this.cntTelefone = contato.getCntTelefone();
        this.cntWhatsapp = contato.getCntWhatsapp();
    }
}
