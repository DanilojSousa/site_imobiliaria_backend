package br.com.tecnologia.sistema.acesso.repository;

import br.com.tecnologia.sistema.acesso.model.UsuarioEnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEnderecoRepository extends JpaRepository<UsuarioEnderecoEntity, Long> {
}
