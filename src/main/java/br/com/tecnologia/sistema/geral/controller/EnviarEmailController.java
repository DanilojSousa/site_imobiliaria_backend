package br.com.tecnologia.sistema.geral.controller;

import br.com.tecnologia.sistema.geral.model.EnviarEmailEntity;
import br.com.tecnologia.sistema.geral.service.EnviarEmailService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path = "/email")
public class EnviarEmailController {

	@Autowired
	private EnviarEmailService dao;
	
	@GetMapping("/esqueceuSenha")
	public void esqueceuSenha(@RequestParam String email) {
	    dao.esqueceuSenha(email);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		dao.excluir(dao.getById(id));
	}
	
	@GetMapping(path = "/getAll")
	public List<EnviarEmailEntity> getAll() {
		return dao.getAll();
	}
	
	@GetMapping(path = "/getById")
	public EnviarEmailEntity getById(Long id) {
		return  dao.getById(id);
	}

}
