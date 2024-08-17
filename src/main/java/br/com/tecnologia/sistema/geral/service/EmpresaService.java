package br.com.tecnologia.sistema.geral.service;

import br.com.tecnologia.sistema.geral.dto.EmpresaDTO;
import br.com.tecnologia.sistema.geral.model.EmpresaEntity;
import br.com.tecnologia.sistema.geral.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpresaService {

	@Autowired
	private EmpresaRepository dao;
	
	public EmpresaDTO getByIdDto(Long empCodigo) {
		return dao.getByIdDto(empCodigo);
	}

	public EmpresaEntity getById(Long empCodigo) {
		return dao.findById(empCodigo).get();
	}
}
