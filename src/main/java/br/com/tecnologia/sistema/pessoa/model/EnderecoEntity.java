package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "endereco", schema = "pessoa")
public class EnderecoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long endCodigo;
    private String endEndereco;
    private String endCep;
    private String endNumero;
    private String endBairro;
    private String endComplemento;
    private CidadeEntity cidade;

    public EnderecoEntity() {
        cidade = new CidadeEntity();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "end_codigo")
    public Long getEndCodigo() {
        return endCodigo;
    }

    public void setEndCodigo(Long endCodigo) {
        this.endCodigo = endCodigo;
    }
    @Column(name = "end_endereco")
    @NotNull
    public String getEndEndereco() {
        return endEndereco;
    }

    public void setEndEndereco(String endEndereco) {
        this.endEndereco = endEndereco;
    }
    @Column(name = "end_cep")
    @NotNull
    public String getEndCep() {
        return endCep;
    }

    public void setEndCep(String endCep) {
        this.endCep = endCep;
    }
    @Column(name = "end_numero")
    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }
    @Column(name = "end_bairro")
    @NotNull
    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    @Column(name = "end_complemento")
    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    @ManyToOne
    @JoinColumn(name="cid_codigo")
    public CidadeEntity getCidade() {
        return cidade;
    }

    public void setCidade(CidadeEntity cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoEntity that = (EnderecoEntity) o;
        return Objects.equals(endCodigo, that.endCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endCodigo);
    }
}
