package br.com.tecnologia.sistema.pessoa.service;

import br.com.tecnologia.sistema.pessoa.dto.EmailDTO;
import br.com.tecnologia.sistema.pessoa.model.EmailEntity;
import br.com.tecnologia.sistema.pessoa.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private EmailRepository dao;

    public EmailEntity salvar(EmailEntity email){
        return dao.save(email);
    }

    public EmailEntity getPrincipalPorEmpCodigo(Long empCodigo){
        return dao.getPrincipalPorEmpCodigo(empCodigo)
                    .orElseThrow(() -> new IllegalStateException("Email principal não encontrado"));
    }
    public EmailEntity getPrincipalPorUsrCodigo(Long usrCodigo){
        return dao.getPrincipalPorUsrCodigo(usrCodigo)
                .orElseThrow(() -> new IllegalStateException("Email principal não encontrado"));
    }

    public EmailEntity findByEmaEmail(String emaEmail) {
        return dao.findByEmaEmail(emaEmail);
    }
}
