package br.com.tecnologia.sistema.acesso.security.auth;

import br.com.tecnologia.sistema.acesso.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = usuarioRepository.findByUsrLogin(username);
        if(user == null){
            user = usuarioRepository.findByUsrCpf(username);
        }
        if(user == null){
            user = usuarioRepository.getByUsuarioPorEmaEmail(username);
        }
        return user;
    }
}
