package br.com.tecnologia.sistema.geral.repository;

import br.com.tecnologia.sistema.geral.dto.SubMenuDTO;
import br.com.tecnologia.sistema.geral.model.SubMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenuEntity, Long> {

    @Query(" SELECT new br.com.tecnologia.sistema.geral.dto.SubMenuDTO(s)" +
            " FROM SubMenuEntity s WHERE s.menu.menCodigo = :menCodigo")
    List<SubMenuDTO> getAllPorMenCodigo(Long menCodigo);
}
