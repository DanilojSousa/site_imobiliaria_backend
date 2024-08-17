package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.EstadoEntity;
import lombok.Data;

@Data
public class EstadoDTO {

    private Long estCodigo;
    private String estDescricao;
    private String estSigla;

    public EstadoDTO(EstadoEntity estado) {
        this.estCodigo = estado.getEstCodigo();
        this.estDescricao = estado.getEstDescricao();
        this.estSigla = estado.getEstSigla();
    }
}
