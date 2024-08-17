package br.com.tecnologia.sistema.geral.service;

import br.com.tecnologia.sistema.geral.dto.MenuDTO;
import br.com.tecnologia.sistema.geral.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    private MenuRepository dao;
    @Autowired
    private SubMenuService subMenuService;

    public List<MenuDTO> getAll(){
        List<MenuDTO> menus = dao.getAll();
        menus.parallelStream().forEach(m -> {
            synchronized (m) {
                m.getSubMenu().addAll(subMenuService.getAllPorMenCodigo(m.getMenCodigo()));
            }
        });
        return menus;
    }
}
