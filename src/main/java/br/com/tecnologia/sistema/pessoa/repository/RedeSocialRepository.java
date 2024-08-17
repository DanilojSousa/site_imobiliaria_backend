package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedeSocialRepository extends JpaRepository<RedeSocialEntity, Long> {
}
