package br.com.tecnologia.sistema.acesso.service;

import br.com.tecnologia.sistema.acesso.model.UsuarioRedeSocialEntity;
import br.com.tecnologia.sistema.acesso.repository.UsuarioRedeSocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRedeSocialService {

    @Autowired
    private UsuarioRedeSocialRepository dao;

    public UsuarioRedeSocialEntity salva(UsuarioRedeSocialEntity usuarioRedeSocial){
        return dao.save(usuarioRedeSocial);
    }
}
