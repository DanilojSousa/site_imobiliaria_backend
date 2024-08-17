package br.com.tecnologia.sistema.geral.service;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.tecnologia.sistema.acesso.model.UsuarioEmailEntity;
import br.com.tecnologia.sistema.acesso.service.UsuarioEmailService;
import br.com.tecnologia.sistema.geral.model.EmpresaEntity;
import br.com.tecnologia.sistema.geral.model.EnviarEmailEntity;
import br.com.tecnologia.sistema.geral.model.LayoutEntity;
import br.com.tecnologia.sistema.geral.repository.EnviarEmailRepositoy;
import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import br.com.tecnologia.sistema.pessoa.service.ContatoService;
import br.com.tecnologia.sistema.pessoa.service.EmailService;
import br.com.tecnologia.sistema.acesso.service.UsuarioService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import br.com.tecnologia.sistema.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EnviarEmailService {

	@Autowired
	private EnviarEmailRepositoy dao;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UsuarioEmailService usuarioEmailService;
	@Autowired
	private ContatoService contatoService;

	public EnviarEmailEntity salvar(EnviarEmailEntity enviarEmail) {
		return dao.save(enviarEmail);
	}

	public void excluir(EnviarEmailEntity enviarEmail) {
		dao.delete(enviarEmail);
	}

	public List<EnviarEmailEntity> getAll() {
		return dao.findAll();
	}

	public EnviarEmailEntity getById(Long id) {
		return dao.findById(id).orElse(null);
	}

	public void enviarEmail(EnviarEmailEntity enviarEmail) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

			EmailEntity email = emailService.getPrincipalPorEmpCodigo(enviarEmail.getEmpresa().getEmpCodigo());

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getEmaEmail(), email.getEmaSenha());
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getEmaEmail()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(enviarEmail.getEvmDestinatario()));
            message.setSubject(enviarEmail.getEvmAssunto());
            message.setContent(enviarEmail.getEvmConteudo(), "text/html; charset=UTF-8");

            Transport.send(message);

            enviarEmail.setEvmEnviado(Boolean.TRUE);
            enviarEmail.setEvmDataEnvio(new Date());
            salvar(enviarEmail);
        } catch (MessagingException e) {
            enviarEmail.setEvmEnviado(Boolean.FALSE);
			salvar(enviarEmail);
        }
	}

	public List<EnviarEmailEntity> getAllEmailNaoEnviado() {
		return dao.getAllEmailNaoEnviado();
	}

	@Scheduled(fixedRate = 60000)
	public void enviaEmailAutomatico() {
		List<EnviarEmailEntity> listaEnviarEmail = getAllEmailNaoEnviado();
		if(!listaEnviarEmail.isEmpty()) {
			listaEnviarEmail.parallelStream().forEach(this::enviarEmail);
		}
	}

	public void esqueceuSenha(String email) {
		UsuarioEntity usuario = Optional.ofNullable(usuarioEmailService.getByPorEmaEmail(email))
										.map(UsuarioEmailEntity::getUsuario)
										.orElse(null);
		Optional.ofNullable(usuario)
				.orElseThrow(() -> new IllegalStateException("Usuário não encontrado"));

		EnviarEmailEntity emails = new EnviarEmailEntity();
		ContatoEntity contato = contatoService.getPrincipalPorEmpCodigo(usuario.getEmpresa().getEmpCodigo());
		emails.setEvmAssunto("Recuperar senha");
		emails.setEvmDestinatario(email);
		emails.setEvmEnviado(Boolean.FALSE);
		String logo = Base64.getEncoder().encodeToString(usuario.getEmpresa().getEmpLogo());
		String url = "";
		try {
			url = UrlFrontEnd.URL_RECUPERACAO_SENHA + Util.encode(usuario.getUsrCodigo().toString(), 60000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String corpo = "";

		corpo +="<html lang='pt-br'>";
		corpo +="<body>";
		corpo +="<div>";
		corpo +="<span style='margin-left: 25%'><img src='data:image/png;base64,"+logo+"'width='120' height='41'></span>";
		corpo +="</div>";
		corpo +="<br/>";
		corpo +="Olá: &nbsp <strong>"+ usuario.getUsrNome() +"</strong><br/>";
		corpo +="<br/>";
		corpo +="&nbsp &nbsp Recebemos uma solicitação para restaurar sua senha de acesso em nosso site,";
		corpo +="se você reconhece essa ação, você pode prosseguir:<br/>";
		corpo +="<br/>";
		corpo +="&nbsp &nbsp Para alterar sua senha, clique aqui:";
		corpo +="<br/>";
		corpo +="<br/>";
		corpo +="<a style=' padding: 5px; background-color: "+usuario.getEmpresa().getLayout().getLayCorPrimaria() +"color:#ffffff; border-radius: 10px; cursor:pointer; text-decoration: none' href='"+url+"'>Trocar Senha</a><br/>";
		corpo +="<br/>";
		corpo +="Anteciosamente;<br/>";
		corpo +="<br/>";
		corpo +="<span>&nbsp &nbsp <a style='cursor:pointer;' href='http://localhost:4200/inicio'>"+usuario.getEmpresa().getEmpRazaoSocial()+"</a></span><br/>";
		corpo +="<span>&nbsp &nbsp Contato:&nbsp "+ email +" </span><br/>";
		corpo +="<span>&nbsp &nbsp Fone:&nbsp "+ contato.getCntTelefone() +"</span><br/>";
		corpo +="</body>";
		corpo += "</html>";
		emails.setEvmData(new Date());
		emails.setEvmConteudo(corpo);
		emails.setEmpresa(usuario.getEmpresa());
		emails = salvar(emails);
		enviarEmail(emails);
	}

}
