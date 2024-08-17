package br.com.tecnologia.sistema.acesso.service;

import br.com.tecnologia.sistema.acesso.model.UsuarioEmailEntity;
import br.com.tecnologia.sistema.acesso.repository.UsuarioEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEmailService {

    @Autowired
    private UsuarioEmailRepository dao;

    public UsuarioEmailEntity salva(UsuarioEmailEntity usuarioEmail){
        return dao.save(usuarioEmail);
    }

    public UsuarioEmailEntity getByPorEmaEmail(String emaEmail){
        return dao.getByPorEmaEmail(emaEmail);
    }
}
