package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "email", schema = "pessoa")
public class EmailEntity implements Serializable {

    private Long emaCodigo;
    private String emaEmail;
    private String emaSenha;
    private Boolean emaPrincipal;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ema_codigo")
    public Long getEmaCodigo() {
        return emaCodigo;
    }

    public void setEmaCodigo(Long emaCodigo) {
        this.emaCodigo = emaCodigo;
    }
    @NotNull(message = "O e-mail não pode ser nulo")
    @Email(message = "E-mail deve ser válido")
    @Column(name = "ema_email", unique = true)
    public String getEmaEmail() {
        return emaEmail;
    }

    public void setEmaEmail(String emaEmail) {
        this.emaEmail = emaEmail;
    }
    @Column(name = "ema_senha")
    public String getEmaSenha() {
        return emaSenha;
    }

    public void setEmaSenha(String emaSenha) {
        this.emaSenha = emaSenha;
    }
    @Column(name = "ema_principal")
    public Boolean getEmaPrincipal() {
        return emaPrincipal;
    }

    public void setEmaPrincipal(Boolean emaPrincipal) {
        this.emaPrincipal = emaPrincipal;
    }
}
