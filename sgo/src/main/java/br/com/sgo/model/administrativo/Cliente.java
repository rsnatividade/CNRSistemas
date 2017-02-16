package br.com.sgo.model.administrativo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.sgo.model.gerencial.Papel;

@Entity
@DiscriminatorValue(value="CLIENTE")
public class Cliente extends Papel {
	private static final long serialVersionUID = 1L;
}
