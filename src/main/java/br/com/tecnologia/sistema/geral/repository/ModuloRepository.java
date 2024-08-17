package br.com.tecnologia.sistema.geral.repository;

import br.com.tecnologia.sistema.geral.model.ModuloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuloRepository extends JpaRepository<ModuloEntity, Long> {
    @Query("SELECT m FROM ModuloEntity m" +
            " INNER JOIN EmpresaModuloEntity em on em.modulo.modCodigo = m.modCodigo" +
            " WHERE em.empresa.empCodigo = :empCodigo ")
    Optional<ModuloEntity> getAllPorEmpCodigo(Long empCodigo);
}
