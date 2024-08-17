package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "situacao", schema = "pessoa")
public class SituacaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long stcCodigo;
    private String stcDescricao;

    public SituacaoEntity() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "stc_codigo")
    public Long getStcCodigo() {
        return stcCodigo;
    }

    public void setStcCodigo(Long stcCodigo) {
        this.stcCodigo = stcCodigo;
    }
    @Column(name = "stc_descricao", length = 30)
    @NotNull
    public String getStcDescricao() {
        return stcDescricao;
    }

    public void setStcDescricao(String stcDescricao) {
        this.stcDescricao = stcDescricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SituacaoEntity that = (SituacaoEntity) o;
        return Objects.equals(stcCodigo, that.stcCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stcCodigo);
    }
}
