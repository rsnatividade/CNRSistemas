package br.com.sgo.model.operacional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="SERVICO")
public class Servico extends Item {

	private static final long serialVersionUID = 1L;
	
}
