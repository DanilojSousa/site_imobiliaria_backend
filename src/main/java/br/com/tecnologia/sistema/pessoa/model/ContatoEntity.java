package br.com.tecnologia.sistema.pessoa.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

@Entity
@Table(name = "contato", schema = "pessoa")
public class ContatoEntity {

    private Long cntCodigo;
    private String cntTelefone;
    private String cntWhatsapp;
    private Boolean cntPrincipal;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cnt_codigo")
    public Long getCntCodigo() {
        return cntCodigo;
    }

    public void setCntCodigo(Long cntCodigo) {
        this.cntCodigo = cntCodigo;
    }

    @NotNull(message = "O telefone não pode ser nulo")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
    @Column(name = "cnt_telefone")
    public String getCntTelefone() {
        return cntTelefone;
    }

    public void setCntTelefone(String cntTelefone) {
        this.cntTelefone = cntTelefone;
    }

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}")
    @Column(name = "cnt_whatsapp")
    public String getCntWhatsapp() {
        return cntWhatsapp;
    }

    public void setCntWhatsapp(String cntWhatsapp) {
        this.cntWhatsapp = cntWhatsapp;
    }
    @Column(name = "cnt_principal")
    public Boolean getCntPrincipal() {
        return cntPrincipal;
    }

    public void setCntPrincipal(Boolean cntPrincipal) {
        this.cntPrincipal = cntPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoEntity that = (ContatoEntity) o;
        return Objects.equals(cntCodigo, that.cntCodigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cntCodigo);
    }
}
