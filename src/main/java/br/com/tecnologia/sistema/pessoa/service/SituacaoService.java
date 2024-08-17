package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.model.SituacaoEntity;
import br.com.tecnologia.sistema.pessoa.repository.SituacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SituacaoService {

    @Autowired
    private SituacaoRepository dao;

    public SituacaoEntity findById(Long stcCodigo){
        return dao.findById(stcCodigo).orElseThrow(() -> new IllegalStateException("Situação não encontrada"));
    }

}
