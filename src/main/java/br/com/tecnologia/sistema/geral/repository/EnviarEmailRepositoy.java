package br.com.tecnologia.sistema.geral.repository;

import br.com.tecnologia.sistema.geral.model.EnviarEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnviarEmailRepositoy extends JpaRepository<EnviarEmailEntity, Long> {

    @Query("SELECT e FROM EnviarEmailEntity e WHERE e.evmEnviado = false ")
    List<EnviarEmailEntity> getAllEmailNaoEnviado();
}
