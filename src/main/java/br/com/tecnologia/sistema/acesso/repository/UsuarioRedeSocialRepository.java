package br.com.tecnologia.sistema.acesso.repository;

import br.com.tecnologia.sistema.acesso.model.UsuarioRedeSocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRedeSocialRepository extends JpaRepository<UsuarioRedeSocialEntity, Long> {
}
