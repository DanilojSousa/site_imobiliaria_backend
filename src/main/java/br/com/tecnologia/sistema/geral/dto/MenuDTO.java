package br.com.tecnologia.sistema.geral.dto;

import br.com.tecnologia.sistema.geral.model.MenuEntity;
import br.com.tecnologia.sistema.geral.model.SubMenuEntity;
import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {

    private Long menCodigo;
    private String menDescricao;
    private String menIcon;
    private List<SubMenuDTO> subMenu;

    public MenuDTO(MenuEntity menu) {
        this.menCodigo = menu.getMenCodigo();
        this.menDescricao = menu.getMenDescricao();
        this.menIcon = menu.getMenIcon();
    }
}
