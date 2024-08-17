package br.com.tecnologia.sistema.acesso.service;

import br.com.tecnologia.sistema.acesso.model.UsuarioEnderecoEntity;
import br.com.tecnologia.sistema.acesso.repository.UsuarioEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioEnderecoService {

    @Autowired
    private UsuarioEnderecoRepository dao;

    public UsuarioEnderecoEntity salva(UsuarioEnderecoEntity usuarioEndereco){
        return dao.save(usuarioEndereco);
    }
}
