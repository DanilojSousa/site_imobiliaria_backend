package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.model.RedeSocialEntity;
import br.com.tecnologia.sistema.pessoa.repository.RedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedeSocialService {

    @Autowired
    private RedeSocialRepository dao;

    public RedeSocialEntity salvar(RedeSocialEntity redeSocial){
        return dao.save(redeSocial);
    }
}
