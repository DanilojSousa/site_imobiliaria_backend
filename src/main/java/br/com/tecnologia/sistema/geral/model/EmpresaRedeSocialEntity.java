package br.com.tecnologia.sistema.geral.model;

import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa_rede_social", schema = "geral")
public class EmpresaRedeSocialEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long ersCodigo;
    private EmpresaEntity empresa;
    private RedeSocialEntity redeSocial;

    public EmpresaRedeSocialEntity() {
        this.empresa = new EmpresaEntity();
        this.redeSocial = new RedeSocialEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ers_codigo")
    public Long getErsCodigo() {
        return ersCodigo;
    }
    public void setErsCodigo(Long ersCodigo) {
        this.ersCodigo = ersCodigo;
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
    @JoinColumn(name="rso_codigo")
    public RedeSocialEntity getRedeSocial() {
        return redeSocial;
    }
    public void setRedeSocial(RedeSocialEntity redeSocial) {
        this.redeSocial = redeSocial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaRedeSocialEntity that = (EmpresaRedeSocialEntity) o;
        return Objects.equals(ersCodigo, that.ersCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ersCodigo);
    }
}
