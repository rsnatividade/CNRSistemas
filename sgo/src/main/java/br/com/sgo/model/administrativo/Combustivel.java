package br.com.sgo.model.administrativo;

public enum Combustivel {
	
	GASOLINA("Gasolina"),
	ALCOOL("Álcool"),
	FLEX("Flex");
	
	private String descricao;
	
	private Combustivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
