package br.com.tecnologia.sistema.geral.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "enviar_email", schema = "geral")
public class EnviarEmailEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long evmCodigo;
	private String evmDestinatario;
	private String evmAssunto;
	private String evmConteudo;
	private Boolean evmEnviado;
	private Date evmData;
	private Date evmDataEnvio;
	private EmpresaEntity empresa;
	
	public EnviarEmailEntity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "evm_codigo")
	public Long getEvmCodigo() {
		return evmCodigo;
	}

	public void setEvmCodigo(Long evmCodigo) {
		this.evmCodigo = evmCodigo;
	}
	@NotNull
	@Column(name = "evm_destinatario")
	public String getEvmDestinatario() {
		return evmDestinatario;
	}

	public void setEvmDestinatario(String evmDestinatario) {
		this.evmDestinatario = evmDestinatario;
	}
	@NotNull
	@Column(name = "evm_assunto", length = 225)
	public String getEvmAssunto() {
		return evmAssunto;
	}

	public void setEvmAssunto(String evmAssunto) {
		this.evmAssunto = evmAssunto;
	}
	@NotNull
	@Column(name = "evm_conteudo",columnDefinition = "TEXT")
	public String getEvmConteudo() {
		return evmConteudo;
	}

	public void setEvmConteudo(String evmConteudo) {
		this.evmConteudo = evmConteudo;
	}
	@Column(name = "evm_enviado")
	public Boolean getEvmEnviado() {
		return evmEnviado;
	}

	public void setEvmEnviado(Boolean evmEnviado) {
		this.evmEnviado = evmEnviado;
	}
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "evm_data")
	public Date getEvmData() {
		return evmData;
	}

	public void setEvmData(Date evmData) {
		this.evmData = evmData;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "evm_data_envio")
	public Date getEvmDataEnvio() {
		return evmDataEnvio;
	}

	public void setEvmDataEnvio(Date evmDataEnvio) {
		this.evmDataEnvio = evmDataEnvio;
	}

	@ManyToOne
	@JoinColumn(name = "emp_codigo")
	public EmpresaEntity getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaEntity empresa) {
		this.empresa = empresa;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnviarEmailEntity that = (EnviarEmailEntity) o;
		return Objects.equals(evmCodigo, that.evmCodigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(evmCodigo);
	}
}
