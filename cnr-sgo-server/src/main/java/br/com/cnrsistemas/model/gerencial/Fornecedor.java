package br.com.cnrsistemas.model.gerencial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="FORNECEDOR")
public class Fornecedor extends Papel{

	private static final long serialVersionUID = 1L;
}
