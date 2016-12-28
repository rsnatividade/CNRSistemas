package br.com.cnrsistemas.model.gerencial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="COLABORADOR")
public class Colaborador extends Papel {

	private static final long serialVersionUID = 1L;
}
