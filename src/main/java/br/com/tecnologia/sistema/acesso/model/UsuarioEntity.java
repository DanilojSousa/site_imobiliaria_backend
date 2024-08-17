package br.com.tecnologia.sistema.acesso.model;

import br.com.tecnologia.sistema.acesso.enuns.RoleEnum;
import br.com.tecnologia.sistema.geral.model.EmpresaEntity;
import br.com.tecnologia.sistema.pessoa.model.SituacaoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario", schema = "acesso")
@EqualsAndHashCode(of = "usrCodigo")
public class UsuarioEntity implements UserDetails {
    private Long usrCodigo;
    private Date usrNascimento;
    private String usrNome;
    private String usrLogin;
    private String usrPassword;
    private byte[] usrImagem;
    private Date usrDataRegistro;
    private SituacaoEntity situacao;
    private Boolean usrDelete;
    private EmpresaEntity empresa;
    private String id_google;
    private String usrCpf;
    private RoleEnum role;

    public UsuarioEntity() {
        this.situacao = new SituacaoEntity();
        this.empresa = new EmpresaEntity();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usr_codigo")
    public Long getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(Long usrCodigo) {
        this.usrCodigo = usrCodigo;
    }
    @Column(name = "usr_nascimento")
    @NotNull(message = "Data de nascimento é obrigatório")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUsrNascimento() {
        return usrNascimento;
    }

    public void setUsrNascimento(Date usrNascimento) {
        this.usrNascimento = usrNascimento;
    }
    @Column(name = "usr_nome", unique = true)
    @NotNull
    public String getUsrNome() {
        return usrNome;
    }

    public void setUsrNome(String usrNome) {
        this.usrNome = usrNome;
    }
    @Column(name = "usr_login", unique = true)
    @NotNull
    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }
    @Column(name = "usr_password")
    @NotNull(message = "A senha não pode ser nulo")
    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }
    @Column(name = "usr_imagem")
    public byte[] getUsrImagem() {
        return usrImagem;
    }

    public void setUsrImagem(byte[] usrImagem) {
        this.usrImagem = usrImagem;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usr_data_registro")
    public Date getUsrDataRegistro() {
        return usrDataRegistro;
    }

    public void setUsrDataRegistro(Date usrDataRegistro) {
        this.usrDataRegistro = usrDataRegistro;
    }

    @ManyToOne
    @JoinColumn(name="stc_codigo")
    public SituacaoEntity getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEntity situacao) {
        this.situacao = situacao;
    }

    @Column(name = "usr_delete")
    public Boolean getUsrDelete() {
        return usrDelete;
    }

    public void setUsrDelete(Boolean usrDelete) {
        this.usrDelete = usrDelete;
    }

    @ManyToOne
    @JoinColumn(name="emp_codigo")
    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    @Column(name = "id_google")
    public String getId_google() {
        return id_google;
    }

    public void setId_google(String id_google) {
        this.id_google = id_google;
    }

    @CPF
    @Column(name = "usr_cpf", unique = true)
    @NotNull(message = "O CPF não pode ser nulo")
    public String getUsrCpf() {
        return usrCpf;
    }

    public void setUsrCpf(String usrCpf) {
        this.usrCpf = usrCpf;
    }
    @Column(name = "usr_role")
    @Enumerated(EnumType.STRING)
    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role.equals(RoleEnum.ADMIN)){
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                           new SimpleGrantedAuthority("ROLE_USER"));
        }else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Transient
    @Override
    public String getPassword() {
        return this.usrPassword;
    }
    @Transient
    @Override
    public String getUsername() {
        return this.usrNome != null
                ? this.usrNome :  this.usrCpf != null
                ? this.usrCpf : null;
    }
    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Transient
    @Override
    public boolean isEnabled() {
        return true;
    }

}
