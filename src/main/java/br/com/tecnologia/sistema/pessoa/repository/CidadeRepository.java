package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.CidadeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
}
