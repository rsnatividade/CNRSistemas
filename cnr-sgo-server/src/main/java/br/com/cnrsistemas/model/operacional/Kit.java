package br.com.cnrsistemas.model.operacional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="KIT")
public class Kit extends Produto {

	private static final long serialVersionUID = 1L;
	
}
