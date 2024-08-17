package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "estado", schema = "pessoa")
public class EstadoEntity implements Serializable {

    private Long estCodigo;
    private String estDescricao;
    private String estSigla;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "est_codigo")
    public Long getEstCodigo() {
        return estCodigo;
    }

    public void setEstCodigo(Long estCodigo) {
        this.estCodigo = estCodigo;
    }
    @Column(name = "est_descricao")
    @NotNull
    public String getEstDescricao() {
        return estDescricao;
    }

    public void setEstDescricao(String estDescricao) {
        this.estDescricao = estDescricao;
    }

    @Column(name = "est_sigla")
    public String getEstSigla() {
        return estSigla;
    }

    public void setEstSigla(String estSigla) {
        this.estSigla = estSigla;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoEntity that = (EstadoEntity) o;
        return Objects.equals(estCodigo, that.estCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estCodigo);
    }
}
