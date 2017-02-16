package br.com.sgo.model.operacional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="TIPO")
public class Tipo extends Categoria {

	private static final long serialVersionUID = 1L;
	
}
