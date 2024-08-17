package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.dto.ContatoDTO;
import br.com.tecnologia.sistema.pessoa.model.ContatoEntity;
import br.com.tecnologia.sistema.pessoa.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository dao;

    public ContatoEntity salvar(ContatoEntity contato){
        return dao.save(contato);
    }

    public ContatoEntity getPrincipalPorEmpCodigo(Long empCodigo){
        return dao.getPrincipalPorEmpCodigo(empCodigo)
                        .orElseThrow(() -> new IllegalStateException("Contato principal não encontrado"));
    }
}
