package br.com.sgo.model.gerencial;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PESSOA_JURIDICA")
public class PessoaJuridica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(name="tx_cnpj")
	private String cnpj;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
}
