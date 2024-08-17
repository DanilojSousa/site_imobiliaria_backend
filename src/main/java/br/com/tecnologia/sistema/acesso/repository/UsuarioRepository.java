package br.com.tecnologia.sistema.acesso.repository;

import br.com.tecnologia.sistema.acesso.dto.UsuarioDTO;
import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	UserDetails findByUsrCodigo(Long usrCodigo);
	UserDetails findByUsrLogin(String usrLogin);
	UserDetails findByUsrCpf(String usrCpf);
	UserDetails findByUsrPassword(String usrPassword);
	@Query(" SELECT u FROM UsuarioEntity u WHERE u.usrDelete = false AND u.situacao.stcCodigo = 1 ")
	Page<UsuarioEntity> getAllAtivos(Pageable page);

	@Query(" SELECT new br.com.tecnologia.sistema.acesso.dto.UsuarioDTO(u)" +
			" FROM UsuarioEntity u WHERE u.usrCodigo = :usrCodigo AND u.usrDelete = false  AND u.situacao.stcCodigo = 1 ")
	Optional<UsuarioDTO> getByIdDto(Long usrCodigo);

	@Query(" SELECT new br.com.tecnologia.sistema.acesso.dto.UsuarioDTO(u, ue.endereco, ur.redeSocial, uc.contato, um.email)" +
			" FROM UsuarioEntity u " +
			" INNER JOIN UsuarioEnderecoEntity ue ON ue.usuario.usrCodigo = u.usrCodigo " +
			" INNER JOIN UsuarioContatoEntity uc ON uc.usuario.usrCodigo = u.usrCodigo " +
			" INNER JOIN UsuarioEmailEntity um ON um.usuario.usrCodigo = u.usrCodigo " +
			" INNER JOIN UsuarioRedeSocialEntity ur ON ur.usuario.usrCodigo = u.usrCodigo " +
			" WHERE u.usrCodigo = :usrCodigo AND u.usrDelete = false  AND u.situacao.stcCodigo = 1 ")
	Optional<UsuarioDTO> getByIdDtoGeral(Long usrCodigo);

	@Query(" SELECT u FROM UsuarioEntity u " +
			" INNER JOIN UsuarioEmailEntity um ON um.usuario.usrCodigo = u.usrCodigo " +
			" WHERE um.email.emaEmail = :emaEmail " +
			" AND u.usrDelete = false  " +
			" AND u.situacao.stcCodigo = 1 ")
	UsuarioEntity getByUsuarioPorEmaEmail(String emaEmail);

	@Query(" SELECT u FROM UsuarioEntity u " +
			" INNER JOIN UsuarioEmailEntity um ON um.usuario.usrCodigo = u.usrCodigo " +
			" WHERE (u.usrCpf = :cpfEmail or um.email.emaEmail = :cpfEmail) " +
			" AND u.usrDelete = false  " +
			" AND u.situacao.stcCodigo = 1 ")
	Optional<UsuarioEntity> getByCpfOrEmail(String cpfEmail);


}
