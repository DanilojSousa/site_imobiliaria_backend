package br.com.tecnologia.sistema.acesso.model;

import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario_email", schema = "acesso")
public class UsuarioEmailEntity implements Serializable {

    private Long usmCodigo;
    private UsuarioEntity usuario;
    private EmailEntity email;

    public UsuarioEmailEntity() {
        usuario = new UsuarioEntity();
        email = new EmailEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usm_codigo")
    public Long getUsmCodigo() {
        return usmCodigo;
    }

    public void setUsmCodigo(Long usmCodigo) {
        this.usmCodigo = usmCodigo;
    }

    @ManyToOne
    @JoinColumn(name="usr_codigo")
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
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
        UsuarioEmailEntity that = (UsuarioEmailEntity) o;
        return Objects.equals(usmCodigo, that.usmCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usmCodigo);
    }
}
