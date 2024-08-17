package br.com.tecnologia.sistema.acesso.service;

import br.com.tecnologia.sistema.acesso.dto.UsuarioAlterarSenhaDTO;
import br.com.tecnologia.sistema.acesso.dto.UsuarioDTO;
import br.com.tecnologia.sistema.acesso.enuns.RoleEnum;
import br.com.tecnologia.sistema.acesso.model.*;
import br.com.tecnologia.sistema.geral.service.EmpresaService;
import br.com.tecnologia.sistema.pessoa.model.*;
import br.com.tecnologia.sistema.acesso.repository.UsuarioRepository;
import br.com.tecnologia.sistema.pessoa.service.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	@Autowired
	private UsuarioRepository dao;
	@Autowired
	private UsuarioEmailService usuarioEmailService;
	@Autowired
	private UsuarioEnderecoService usuarioEnderecoService;
	@Autowired
	private UsuarioContatoService usuarioContatoService;
	@Autowired
	private UsuarioRedeSocialService usuarioRedeSocialService;
	@Autowired
	private SituacaoService situacaoService;
	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private ContatoService contatoService;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private RedeSocialService redeSocialService;

	public UserDetails findByUsrLogin(String usrLogin){
		return dao.findByUsrLogin(usrLogin);
	}
	public UserDetails findByUsrPassword(String usrPassword){
		return dao.findByUsrPassword(usrPassword);
	}

	public UsuarioDTO salvar(UsuarioDTO usuario) {

		UsuarioEntity user = modelMapper.map(usuario, UsuarioEntity.class);
		user.setUsrPassword(new BCryptPasswordEncoder().encode(usuario.getUsrPassword()));
		user.setRole(RoleEnum.USER);

		EmailEntity email = emailService.salvar(modelMapper.map(usuario.getEmail(), EmailEntity.class));
		EnderecoEntity endereco = enderecoService.salvar(modelMapper.map(usuario.getEndereco(), EnderecoEntity.class));
		ContatoEntity contato = contatoService.salvar(modelMapper.map(usuario.getContato(), ContatoEntity.class));
		RedeSocialEntity redeSocial = redeSocialService.salvar(modelMapper.map(usuario, RedeSocialEntity.class));

		if(usuario.getUsrCodigo() == null) {
			UsuarioEmailEntity usuarioEmail = new UsuarioEmailEntity();
			usuarioEmail.setUsuario(user);
			usuarioEmail.setEmail(email);
			usuarioEmailService.salva(usuarioEmail);

			UsuarioEnderecoEntity usuarioEndereco = new UsuarioEnderecoEntity();
			usuarioEndereco.setUsuario(user);
			usuarioEndereco.setEndereco(endereco);
			usuarioEnderecoService.salva(usuarioEndereco);

			UsuarioContatoEntity usuarioContato = new UsuarioContatoEntity();
			usuarioContato.setUsuario(user);
			usuarioContato.setContato(contato);
			usuarioContatoService.salva(usuarioContato);

			UsuarioRedeSocialEntity usuarioRedeSocial = new UsuarioRedeSocialEntity();
			usuarioRedeSocial.setUsuario(user);
			usuarioRedeSocial.setRedeSocial(redeSocial);
			usuarioRedeSocialService.salva(usuarioRedeSocial);
		}
		return dao.getByIdDtoGeral(user.getUsrCodigo())
				                       .orElseThrow(() ->
										  new IllegalStateException("O usuario %s não foi salvo".formatted(user.getUsrNome())));
	}


	public void excluir(UsuarioEntity usuario) {
		dao.delete(usuario);
	}

	public UsuarioDTO getById(Long usrCodigo) {
		return new UsuarioDTO(dao.findById(usrCodigo)
				.orElseThrow(() -> new IllegalStateException("Usuário não encontrado")));
	}

	public void aletrarSenha(UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
		UsuarioEntity user = dao.findById(usuarioAlterarSenhaDTO.getUsrCodigo()).orElse(null);
		if(user != null){
			user.setUsrPassword(new BCryptPasswordEncoder().encode(usuarioAlterarSenhaDTO.getUsrPassword()));
			dao.save(user);
		}
	}
}
