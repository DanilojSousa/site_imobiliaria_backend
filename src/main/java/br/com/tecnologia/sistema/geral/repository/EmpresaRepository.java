package br.com.tecnologia.sistema.geral.repository;

import br.com.tecnologia.sistema.geral.dto.EmpresaDTO;
import br.com.tecnologia.sistema.geral.model.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaEntity, Long> {

    @Query("SELECT new br.com.tecnologia.sistema.geral.dto.EmpresaDTO(e) " +
            " FROM EmpresaEntity e WHERE e.empCodigo = :empCodigo")
    EmpresaDTO getByIdDto(Long empCodigo);
}
