package br.com.tecnologia.sistema.pessoa.repository;

import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
}
