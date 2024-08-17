package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {

    EmailEntity findByEmaEmail(String emaEmail);

    @Query(" SELECT e FROM EmailEntity e " +
           " INNER JOIN EmpresaEmailEntity ee ON ee.email.emaCodigo = e.emaCodigo" +
           " WHERE ee.empresa.empCodigo = :empCodigo " +
            "      AND e.emaPrincipal = true")
    Optional<EmailEntity> getPrincipalPorEmpCodigo(Long empCodigo);
    @Query(" SELECT e FROM EmailEntity e " +
            " INNER JOIN UsuarioEmailEntity ue ON ue.email.emaCodigo = e.emaCodigo" +
            " WHERE ue.usuario.usrCodigo = :usrCodigo " +
            "      AND e.emaPrincipal = true")
    Optional<EmailEntity> getPrincipalPorUsrCodigo(Long usrCodigo);
}
