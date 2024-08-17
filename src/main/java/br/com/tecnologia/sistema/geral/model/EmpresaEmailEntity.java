package br.com.tecnologia.sistema.geral.model;

import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "empresa_email", schema = "geral")
public class EmpresaEmailEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long emeCodigo;
    private EmpresaEntity empresa;
    private EmailEntity email;

    public EmpresaEmailEntity() {
        this.empresa = new EmpresaEntity();
        this.email = new EmailEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "eme_codigo")
    public Long getEmeCodigo() {
        return emeCodigo;
    }
    public void setEmeCodigo(Long emeCodigo) {
        this.emeCodigo = emeCodigo;
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
    @JoinColumn(name="ema_codigo")
    public EmailEntity getEmail() {
        return email;
    }
    public void setEmail(EmailEntity email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpresaEmailEntity that = (EmpresaEmailEntity) o;
        return Objects.equals(emeCodigo, that.emeCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emeCodigo);
    }
}
