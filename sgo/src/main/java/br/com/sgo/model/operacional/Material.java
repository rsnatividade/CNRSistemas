package br.com.sgo.model.operacional;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="MATERIAL")
public class Material extends Item {

	private static final long serialVersionUID = 1L;
}
