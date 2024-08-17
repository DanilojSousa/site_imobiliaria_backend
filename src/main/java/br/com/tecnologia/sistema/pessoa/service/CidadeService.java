package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.model.CidadeEntity;
import br.com.tecnologia.sistema.pessoa.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository dao;

    public CidadeEntity getById(Long cidCodigo){
        return dao.findById(cidCodigo)
                    .orElseThrow(() -> new IllegalStateException("Cidade não encontrada"));
    }

}
