package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cidade", schema = "pessoa")
public class CidadeEntity implements Serializable {

    private Long cidCodigo;
    private String cidDescricao;
    private EstadoEntity estado;

    public CidadeEntity() {
        estado = new EstadoEntity();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cid_codigo")
    public Long getCidCodigo() {
        return cidCodigo;
    }

    public void setCidCodigo(Long cidCodigo) {
        this.cidCodigo = cidCodigo;
    }
    @Column(name = "cid_descricao")
    @NotNull
    public String getCidDescricao() {
        return cidDescricao;
    }

    public void setCidDescricao(String cidDescricao) {
        this.cidDescricao = cidDescricao;
    }
    @ManyToOne
    @JoinColumn(name="est_codigo")
    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CidadeEntity that = (CidadeEntity) o;
        return Objects.equals(cidCodigo, that.cidCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidCodigo);
    }
}
