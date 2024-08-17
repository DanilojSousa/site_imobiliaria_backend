package br.com.tecnologia.sistema.pessoa.dto;

import br.com.tecnologia.sistema.pessoa.model.EnderecoEntity;
import lombok.Data;

@Data
public class EnderecoDTO {

    private Long endCodigo;
    private String endEndereco;
    private String endComplemento;
    private String endNumero;
    private String endCep;
    private String endBairro;
    private CidadeDTO cidade;

    public EnderecoDTO(EnderecoEntity endereco) {
        this.endCodigo = endereco.getEndCodigo();
        this.endEndereco = endereco.getEndEndereco();
        this.endComplemento = endereco.getEndComplemento();
        this.endNumero = endereco.getEndNumero();
        this.endCep = endereco.getEndCep();
        this.endBairro = endereco.getEndBairro();
        this.cidade = new CidadeDTO(endereco.getCidade());
    }
}
