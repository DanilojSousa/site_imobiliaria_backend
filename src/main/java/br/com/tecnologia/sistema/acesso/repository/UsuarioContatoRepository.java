package br.com.tecnologia.sistema.acesso.repository;

import br.com.tecnologia.sistema.acesso.model.UsuarioContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioContatoRepository extends JpaRepository<UsuarioContatoEntity, Long> {
}
