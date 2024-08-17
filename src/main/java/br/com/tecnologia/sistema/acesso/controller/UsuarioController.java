package br.com.tecnologia.sistema.acesso.controller;

import br.com.tecnologia.sistema.acesso.dto.UsuarioAlterarSenhaDTO;
import br.com.tecnologia.sistema.acesso.dto.UsuarioDTO;
import br.com.tecnologia.sistema.acesso.service.UsuarioService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {
	@Autowired
	private UsuarioService dao;

	@PostMapping("/salvar")
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Valid UsuarioDTO usuario) {
		return new ResponseEntity<>(dao.salvar(usuario), HttpStatus.OK);
	}

	@GetMapping("/getById")
	public ResponseEntity<UsuarioDTO> getById(@RequestParam @Valid Long usrCodigo) {
		return new ResponseEntity<>(dao.getById(usrCodigo), HttpStatus.OK);
	}
	@PutMapping("/alterarSenha")
	public void alterarSenha(@RequestBody @Valid UsuarioAlterarSenhaDTO usuarioAlterarSenhaDTO) {
		dao.aletrarSenha(usuarioAlterarSenhaDTO);
	}

}
