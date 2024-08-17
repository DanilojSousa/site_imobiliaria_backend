package br.com.tecnologia.sistema.geral.controller;

import br.com.tecnologia.sistema.geral.dto.EmpresaDTO;
import br.com.tecnologia.sistema.geral.service.EmpresaService;
import br.com.tecnologia.sistema.util.UrlFrontEnd;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = UrlFrontEnd.URL_FRONTEND)
@RequestMapping(path="/empresa")
public class EmpresaController {
	
	@Autowired
	private EmpresaService dao;
	
	@GetMapping(path = "/getById")
	public EmpresaDTO getById(@RequestParam @Valid Long empCodigo){
		return dao.getByIdDto(empCodigo);
	}

}
