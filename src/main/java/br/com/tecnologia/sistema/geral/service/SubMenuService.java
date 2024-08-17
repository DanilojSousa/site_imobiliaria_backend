package br.com.tecnologia.sistema.geral.service;

import br.com.tecnologia.sistema.geral.dto.SubMenuDTO;
import br.com.tecnologia.sistema.geral.repository.SubMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubMenuService {

    @Autowired
    private SubMenuRepository dao;

    public List<SubMenuDTO> getAllPorMenCodigo(Long menCodigo){
        return dao.getAllPorMenCodigo(menCodigo);
    }
}
