package br.com.tecnologia.sistema.geral.model;

import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa_endereco", schema = "geral")
public class EmpresaEnderecoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long emdCodigo;
    private EmpresaEntity empresa;
    private EnderecoEntity endereco;

    public EmpresaEnderecoEntity() {
        this.empresa = new EmpresaEntity();
        this.endereco = new EnderecoEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emd_codigo")
    public Long getEmdCodigo() {
        return emdCodigo;
    }

    public void setEmdCodigo(Long emdCodigo) {
        this.emdCodigo = emdCodigo;
    }
    @ManyToOne
    @JoinColumn(name="emp_codigo")
    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }
    @ManyToOne
    @JoinColumn(name="end_codigo")
    public EnderecoEntity getEndereco() {
        return endereco;
    }
    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEnderecoEntity that = (EmpresaEnderecoEntity) o;
        return Objects.equals(emdCodigo, that.emdCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emdCodigo);
    }
}
