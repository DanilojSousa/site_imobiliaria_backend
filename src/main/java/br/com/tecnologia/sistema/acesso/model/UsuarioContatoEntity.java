package br.com.tecnologia.sistema.acesso.model;

import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario_contato", schema = "acesso")
public class UsuarioContatoEntity implements Serializable {

    private Long uscCodigo;
    private UsuarioEntity usuario;
    private ContatoEntity contato;

    public UsuarioContatoEntity() {
        usuario = new UsuarioEntity();
        contato = new ContatoEntity();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usc_codigo")
    public Long getUscCodigo() {
        return uscCodigo;
    }

    public void setUscCodigo(Long uscCodigo) {
        this.uscCodigo = uscCodigo;
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
        UsuarioContatoEntity that = (UsuarioContatoEntity) o;
        return Objects.equals(uscCodigo, that.uscCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uscCodigo);
    }
}
