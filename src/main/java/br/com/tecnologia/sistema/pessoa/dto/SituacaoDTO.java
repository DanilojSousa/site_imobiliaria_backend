package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.SituacaoEntity;
import lombok.Data;

@Data
public class SituacaoDTO {

    private Long stcCodigo;
    private String stcDescricao;

    public SituacaoDTO(SituacaoEntity situacao) {
        this.stcCodigo = situacao.getStcCodigo();
        this.stcDescricao = situacao.getStcDescricao();
    }


}
