package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "modulo", schema = "geral")
public class ModuloEntity implements Serializable {

    private Long modCodigo;
    private String modDescricao;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mod_codigo")
    public Long getModCodigo() {
        return modCodigo;
    }
    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }
    @Column(name = "mod_descricao")
    public String getModDescricao() {
        return modDescricao;
    }
    public void setModDescricao(String modDescricao) {
        this.modDescricao = modDescricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModuloEntity that = (ModuloEntity) o;
        return Objects.equals(modCodigo, that.modCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modCodigo);
    }
}
