package br.com.tecnologia.sistema.geral.service;

import br.com.tecnologia.sistema.geral.model.ModuloEntity;
import br.com.tecnologia.sistema.geral.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository dao;

    public Optional<ModuloEntity> getAllPorEmpCodigo(Long empCodigo){
        return dao.getAllPorEmpCodigo(empCodigo);
    }
}
