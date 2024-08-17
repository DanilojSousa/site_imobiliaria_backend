package br.com.tecnologia.sistema.acesso.service;

import br.com.tecnologia.sistema.acesso.model.UsuarioContatoEntity;
import br.com.tecnologia.sistema.acesso.repository.UsuarioContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioContatoService {

    @Autowired
    private UsuarioContatoRepository dao;

    public UsuarioContatoEntity salva(UsuarioContatoEntity usuarioContato){
        return dao.save(usuarioContato);
    }
}
