package br.com.tecnologia.sistema.acesso.model;

import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario_rede_social", schema = "acesso")
public class UsuarioRedeSocialEntity implements Serializable {

    private Long ursCodigo;
    private UsuarioEntity usuario;
    private RedeSocialEntity redeSocial;

    public UsuarioRedeSocialEntity() {
        usuario = new UsuarioEntity();
        redeSocial = new RedeSocialEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "urs_codigo")
    public Long getUrsCodigo() {
        return ursCodigo;
    }

    public void setUrsCodigo(Long ursCodigo) {
        this.ursCodigo = ursCodigo;
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
        UsuarioRedeSocialEntity that = (UsuarioRedeSocialEntity) o;
        return Objects.equals(ursCodigo, that.ursCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ursCodigo);
    }
}
