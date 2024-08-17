package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.CidadeEntity;
import lombok.Data;

@Data
public class CidadeDTO {

    private Long cidCodigo;
    private String cidDescricao;
    private EstadoDTO estado;

    public CidadeDTO(CidadeEntity cidade) {
        this.cidCodigo = cidade.getCidCodigo();
        this.cidDescricao = cidade.getCidDescricao();
        this.estado = new EstadoDTO(cidade.getEstado());
    }
}
