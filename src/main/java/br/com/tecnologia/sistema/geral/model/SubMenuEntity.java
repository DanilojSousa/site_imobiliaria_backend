package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;

import java.awt.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "sub_menu",schema = "geral")
public class SubMenuEntity implements Serializable {

    private Long smeCodigo;
    private String smeDescricao;
    private String smeIcon;
    private String smeLink;
    private MenuEntity menu;

    public SubMenuEntity() {
        this.menu = new MenuEntity();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "sme_codigo")
    public Long getSmeCodigo() {
        return smeCodigo;
    }
    public void setSmeCodigo(Long smeCodigo) {
        this.smeCodigo = smeCodigo;
    }
    @Column(name = "sme_descricao")
    public String getSmeDescricao() {
        return smeDescricao;
    }
    public void setSmeDescricao(String smeDescricao) {
        this.smeDescricao = smeDescricao;
    }
    @Column(name = "sme_icon")
    public String getSmeIcon() {
        return smeIcon;
    }
    public void setSmeIcon(String smeIcon) {
        this.smeIcon = smeIcon;
    }
    @Column(name = "sme_link")
    public String getSmeLink() {
        return smeLink;
    }
    public void setSmeLink(String smeLink) {
        this.smeLink = smeLink;
    }
    @ManyToOne
    @JoinColumn(name = "men_codigo")
    public MenuEntity getMenu() {
        return menu;
    }
    public void setMenu(MenuEntity menu) {
        this.menu = menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubMenuEntity that = (SubMenuEntity) o;
        return Objects.equals(smeCodigo, that.smeCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(smeCodigo);
    }
}
