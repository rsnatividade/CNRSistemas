package br.com.cnrsistemas.model.administrativo;

public enum Status {

	PENDENTE("Pendente"),
	APROVADA("Aprovada"),
	RECURSADA("Recusada");
	
	private String descricao;
	
	private Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
