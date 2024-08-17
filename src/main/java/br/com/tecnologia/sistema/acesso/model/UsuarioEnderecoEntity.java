package br.com.tecnologia.sistema.acesso.model;

import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "usuario_endereco", schema = "acesso")
public class UsuarioEnderecoEntity implements Serializable {

    private Long useCodigo;
    private UsuarioEntity usuario;
    private EnderecoEntity endereco;

    public UsuarioEnderecoEntity() {
        usuario = new UsuarioEntity();
        endereco = new EnderecoEntity();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "use_codigo")
    public Long getUseCodigo() {
        return useCodigo;
    }

    public void setUseCodigo(Long useCodigo) {
        this.useCodigo = useCodigo;
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
        UsuarioEnderecoEntity that = (UsuarioEnderecoEntity) o;
        return Objects.equals(useCodigo, that.useCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(useCodigo);
    }
}
