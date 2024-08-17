package br.com.tecnologia.sistema.acesso.dto;

import br.com.tecnologia.sistema.acesso.enuns.RoleEnum;
import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import br.com.tecnologia.sistema.pessoa.dto.*;
import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UsuarioDTO {

    private Long usrCodigo;
    private Date usrNascimento;
    private String usrNome;
    private String usrLogin;
    private String usrPassword;
    private String usrCpf;
    private EmailDTO email;
    private byte[] usrImagem;
    private SituacaoDTO situacao;
    private String id_google;
    private EnderecoDTO endereco;
    private RedeSocialDTO redeSocial;
    private ContatoDTO contato;
    private RoleEnum roles;

    public UsuarioDTO(UsuarioEntity usuario) {
        this.usrNascimento = usuario.getUsrNascimento();
        this.usrNome = usuario.getUsrNome();
        this.usrLogin = usuario.getUsrNome();
        this.usrCpf = usuario.getUsrCpf();
        this.usrImagem = usuario.getUsrImagem();
        this.situacao = new SituacaoDTO(usuario.getSituacao());
        this.id_google = usuario.getId_google();
        this.usrPassword = usuario.getUsrPassword();
        this.roles = usuario.getRole();
    }
    public UsuarioDTO(UsuarioEntity usuario, EnderecoEntity endereco, RedeSocialEntity redeSocial,
                      ContatoEntity contato, EmailEntity email) {
        this.usrNascimento = usuario.getUsrNascimento();
        this.usrNome = usuario.getUsrNome();
        this.usrLogin = usuario.getUsrNome();
        this.usrCpf = usuario.getUsrCpf();
        this.usrImagem = usuario.getUsrImagem();
        this.situacao = new SituacaoDTO(usuario.getSituacao());
        this.id_google = usuario.getId_google();
        this.endereco = new EnderecoDTO(endereco);
        this.redeSocial = new RedeSocialDTO(redeSocial);
        this.contato = new ContatoDTO(contato);
        this.usrPassword = usuario.getUsrPassword();
        this.email = new EmailDTO(email);
        this.roles = usuario.getRole();
    }

    public UsuarioDTO(Long usrCodigo, Date usrNascimento, String usrNome, String usrLogin,
                      String usrPassword, String usrCpf, EmailDTO email, byte[] usrImagem,
                      SituacaoDTO situacao, String id_google, EnderecoDTO endereco,
                      RedeSocialDTO redeSocial, ContatoDTO contato, RoleEnum roles) {
        this.usrCodigo = usrCodigo;
        this.usrNascimento = usrNascimento;
        this.usrNome = usrNome;
        this.usrLogin = usrLogin;
        this.usrPassword = usrPassword;
        this.usrCpf = usrCpf;
        this.email = email;
        this.usrImagem = usrImagem;
        this.situacao = situacao;
        this.id_google = id_google;
        this.endereco = endereco;
        this.redeSocial = redeSocial;
        this.contato = contato;
        this.roles = roles;
    }
}
