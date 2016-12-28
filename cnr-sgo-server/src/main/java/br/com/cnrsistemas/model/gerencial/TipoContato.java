package br.com.cnrsistemas.model.gerencial;

public enum TipoContato {

	RESIDENCIAL("Residencial"),
	COMERCIAL("Comercial"),
	RECADO("Recado");
	
	private String descricao;
	
	private TipoContato(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
