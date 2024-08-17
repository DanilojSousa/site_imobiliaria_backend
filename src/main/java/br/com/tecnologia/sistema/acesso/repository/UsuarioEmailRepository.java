package br.com.tecnologia.sistema.acesso.repository;

import br.com.tecnologia.sistema.acesso.model.UsuarioEmailEntity;
import br.com.tecnologia.sistema.acesso.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmailRepository extends JpaRepository<UsuarioEmailEntity, Long> {

    @Query("SELECT ue FROM UsuarioEmailEntity ue WHERE ue.email.emaEmail = :emaEmail")
    UsuarioEmailEntity getByPorEmaEmail(String emaEmail);
}
