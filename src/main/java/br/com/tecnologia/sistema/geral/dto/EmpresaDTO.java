package br.com.tecnologia.sistema.geral.dto;

import br.com.tecnologia.sistema.geral.model.EmpresaEntity;
import br.com.tecnologia.sistema.geral.model.LayoutEntity;
import br.com.tecnologia.sistema.pessoa.dto.CidadeDTO;
import lombok.Data;

import java.util.Optional;

@Data
public class EmpresaDTO {

	private Long empCodigo;
	private String empRazaoSocial;
	private String empCnpj;
	private String empIe;
	private String empFantasia;
	private byte[] empLogo;
	private byte[] empIcone;
	private LayoutDTO layout;

	public EmpresaDTO(EmpresaEntity empresa) {
		this.empLogo = empresa.getEmpLogo();
		this.empIcone = empresa.getEmpIcone();
		this.empIcone = empresa.getEmpIcone();
		this.empRazaoSocial = empresa.getEmpRazaoSocial();
		this.empFantasia = empresa.getEmpFantasia();
		this.empCnpj = empresa.getEmpCnpj();
		this.layout = Optional.ofNullable(empresa.getLayout())
							  .map(LayoutDTO::new)
				              .orElse(null);
	}
}
