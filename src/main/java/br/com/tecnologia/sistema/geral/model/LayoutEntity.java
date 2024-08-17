package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "layout", schema = "geral")
public class LayoutEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long layCodigo;
    private String layCorPrimaria;
    private String layCorSecundaria;
    private String layFonte;

    public LayoutEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "lay_codigo")
    public Long getLayCodigo() {
        return layCodigo;
    }

    public void setLayCodigo(Long layCodigo) {
        this.layCodigo = layCodigo;
    }
    @Column(name = "lay_cor_primaria")
    public String getLayCorPrimaria() {
        return layCorPrimaria;
    }

    public void setLayCorPrimaria(String layCorPrimaria) {
        this.layCorPrimaria = layCorPrimaria;
    }
    @Column(name = "lay_cor_secundaria")
    public String getLayCorSecundaria() {
        return layCorSecundaria;
    }

    public void setLayCorSecundaria(String layCorSecundaria) {
        this.layCorSecundaria = layCorSecundaria;
    }
    @Column(name = "lay_fonte")
    public String getLayFonte() {
        return layFonte;
    }

    public void setLayFonte(String layFonte) {
        this.layFonte = layFonte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LayoutEntity that = (LayoutEntity) o;
        return Objects.equals(layCodigo, that.layCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(layCodigo);
    }
}
