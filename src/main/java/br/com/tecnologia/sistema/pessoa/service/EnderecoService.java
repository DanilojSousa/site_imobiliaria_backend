package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.dto.EnderecoDTO;
import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import br.com.tecnologia.sistema.pessoa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository dao;
    @Autowired
    private CidadeService cidadeService;

    public EnderecoEntity salvar(EnderecoEntity endereco){
        return dao.save(endereco);
    }
}
