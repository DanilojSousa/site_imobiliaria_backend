package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Long> {
    @Query(" SELECT c FROM ContatoEntity c " +
           " INNER JOIN EmpresaContatoEntity ec ON ec.contato.cntCodigo = c.cntCodigo" +
           " WHERE ec.empresa.empCodigo = :empCodigo " +
           "       AND c.cntPrincipal = true")
    Optional<ContatoEntity> getPrincipalPorEmpCodigo(Long empCodigo);
}
