package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.SituacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository<SituacaoEntity, Long> {

}
