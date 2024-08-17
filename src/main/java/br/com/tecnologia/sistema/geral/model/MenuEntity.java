package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "menu",schema = "geral")
public class MenuEntity implements Serializable {

    private Long menCodigo;
    private String menDescricao;
    private String menIcon;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "men_codigo")
    public Long getMenCodigo() {
        return menCodigo;
    }

    public void setMenCodigo(Long menCodigo) {
        this.menCodigo = menCodigo;
    }
    @Column(name = "men_descricao")
    public String getMenDescricao() {
        return menDescricao;
    }

    public void setMenDescricao(String menDescricao) {
        this.menDescricao = menDescricao;
    }
    @Column(name = "men_icon")
    public String getMenIcon() {
        return menIcon;
    }

    public void setMenIcon(String menIcon) {
        this.menIcon = menIcon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return Objects.equals(menCodigo, that.menCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menCodigo);
    }
}
