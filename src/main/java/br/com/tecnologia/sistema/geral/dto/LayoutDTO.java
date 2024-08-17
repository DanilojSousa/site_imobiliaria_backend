package br.com.tecnologia.sistema.geral.dto;

import br.com.tecnologia.sistema.geral.model.LayoutEntity;
import lombok.Data;

@Data
public class LayoutDTO {

    private Long layCodigo;
    private String layCorPrimaria;
    private String layCorSecundaria;
    private String layFonte;

    public LayoutDTO(LayoutEntity layout) {
        this.layCodigo = layout.getLayCodigo();
        this.layCorPrimaria = layout.getLayCorPrimaria();
        this.layCorSecundaria = layout.getLayCorSecundaria();
        this.layFonte = layout.getLayFonte();
    }
}
