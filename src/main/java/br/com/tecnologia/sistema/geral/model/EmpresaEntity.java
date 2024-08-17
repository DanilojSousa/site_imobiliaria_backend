package br.com.tecnologia.sistema.geral.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import br.com.tecnologia.sistema.pessoa.model.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "empresa", schema = "geral")
public class EmpresaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long empCodigo;
	private String empRazaoSocial;
	private String empCnpj;
	private String empIe;
	private String empFantasia;
	private Date empDataRegistro;
	private Boolean empDelete;
	private byte[] empCertificado;
	private byte[] empLogo;
	private SituacaoEntity situacao;
	private String empSenhaCertificado;
	private byte[] empIcone;
	private LayoutEntity  layout;

	public EmpresaEntity() {
		situacao = new SituacaoEntity();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "emp_codigo")
	public Long getEmpCodigo() {
		return empCodigo;
	}

	public void setEmpCodigo(Long empCodigo) {
		this.empCodigo = empCodigo;
	}
	@Column(name = "emp_razao_social")
	@NotNull
	public String getEmpRazaoSocial() {
		return empRazaoSocial;
	}

	public void setEmpRazaoSocial(String empRazaoSocial) {
		this.empRazaoSocial = empRazaoSocial;
	}
	@Column(name = "emp_cnpj")
	@NotNull(message = "O CNPJ não pode ser nulo")
	@Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}")
	public String getEmpCnpj() {
		return empCnpj;
	}

	public void setEmpCnpj(String empCnpj) {
		this.empCnpj = empCnpj;
	}
	@Column(name = "emp_ie")
	public String getEmpIe() {
		return empIe;
	}

	public void setEmpIe(String empIe) {
		this.empIe = empIe;
	}
	@Column(name = "emp_fantasia")
	@NotNull
	public String getEmpFantasia() {
		return empFantasia;
	}

	public void setEmpFantasia(String empFantasia) {
		this.empFantasia = empFantasia;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "emp_data_registro")
	public Date getEmpDataRegistro() {
		return empDataRegistro;
	}

	public void setEmpDataRegistro(Date empDataRegistro) {
		this.empDataRegistro = empDataRegistro;
	}

	@Column(name = "emp_delete")
	public Boolean getEmpDelete() {
		return empDelete;
	}

	public void setEmpDelete(Boolean empDelete) {
		this.empDelete = empDelete;
	}

	@Column(name = "emp_certificado")
	public byte[] getEmpCertificado() {
		return empCertificado;
	}

	public void setEmpCertificado(byte[] empCertificado) {
		this.empCertificado = empCertificado;
	}

	@Column(name = "emp_logo")
	public byte[] getEmpLogo() {
		return empLogo;
	}

	public void setEmpLogo(byte[] empLogo) {
		this.empLogo = empLogo;
	}
	@ManyToOne
	@JoinColumn(name="stc_codigo")
	public SituacaoEntity getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEntity situacao) {
		this.situacao = situacao;
	}

	@Column(name = "emp_senha_certificado")
	public String getEmpSenhaCertificado() {
		return empSenhaCertificado;
	}
	public void setEmpSenhaCertificado(String empSenhaCertificado) {
		this.empSenhaCertificado = empSenhaCertificado;
	}
	@Column(name = "emp_icone")
	public byte[] getEmpIcone() {
		return empIcone;
	}
	public void setEmpIcone(byte[] empIcone) {
		this.empIcone = empIcone;
	}

	@ManyToOne
	@JoinColumn(name="lay_codigo")
	public LayoutEntity getLayout() {
		return layout;
	}

	public void setLayout(LayoutEntity layout) {
		this.layout = layout;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmpresaEntity that = (EmpresaEntity) o;
		return Objects.equals(empCodigo, that.empCodigo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(empCodigo);
	}
}
