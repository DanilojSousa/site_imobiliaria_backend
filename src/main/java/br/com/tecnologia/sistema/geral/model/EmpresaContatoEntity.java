package br.com.tecnologia.sistema.geral.model;

import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa_contato", schema = "geral")
public class EmpresaContatoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long emcCodigo;
    private EmpresaEntity empresa;
    private ContatoEntity contato;

    public EmpresaContatoEntity() {
        this.empresa = new EmpresaEntity();
        this.contato = new ContatoEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "emc_codigo")
    public Long getEmcCodigo() {
        return emcCodigo;
    }
    public void setEmcCodigo(Long emcCodigo) {
        this.emcCodigo = emcCodigo;
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
    @JoinColumn(name="cnt_codigo")
    public ContatoEntity getContato() {
        return contato;
    }
    public void setContato(ContatoEntity contato) {
        this.contato = contato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaContatoEntity that = (EmpresaContatoEntity) o;
        return Objects.equals(emcCodigo, that.emcCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emcCodigo);
    }
}
