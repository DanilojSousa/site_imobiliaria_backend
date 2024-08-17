package br.com.tecnologia.sistema.geral.dto;

import br.com.tecnologia.sistema.geral.model.SubMenuEntity;
import lombok.Data;

@Data
public class SubMenuDTO {
    private String smeDescricao;
    private String smeIcon;
    private String smeLink;

    public SubMenuDTO(SubMenuEntity subMenu) {
        this.smeDescricao = subMenu.getSmeDescricao();
        this.smeIcon = subMenu.getSmeIcon();
        this.smeLink = subMenu.getSmeLink();
    }
}
