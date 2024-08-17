package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa_modulo", schema = "geral")
public class EmpresaModuloEntity implements Serializable {
    private Long emdCodigo;
    private EmpresaEntity empresa;
    private ModuloEntity modulo;

    public EmpresaModuloEntity() {
        this.empresa = new EmpresaEntity();
        this.modulo = new ModuloEntity();
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
    @JoinColumn(name = "emp_codigo")
    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }
    @ManyToOne
    @JoinColumn(name = "mod_codigo")
    public ModuloEntity getModulo() {
        return modulo;
    }

    public void setModulo(ModuloEntity modulo) {
        this.modulo = modulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaModuloEntity that = (EmpresaModuloEntity) o;
        return Objects.equals(emdCodigo, that.emdCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emdCodigo);
    }
}
