package br.com.sgo.model.gerencial;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="PESSOA_FISICA")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	
	@Column(name="tx_cpf")
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
