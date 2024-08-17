package br.com.tecnologia.sistema.geral.repository;

import br.com.tecnologia.sistema.geral.dto.MenuDTO;
import br.com.tecnologia.sistema.geral.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    @Query(" SELECT new br.com.tecnologia.sistema.geral.dto.MenuDTO(m)" +
           " FROM MenuEntity m ")
    List<MenuDTO> getAll();
}
