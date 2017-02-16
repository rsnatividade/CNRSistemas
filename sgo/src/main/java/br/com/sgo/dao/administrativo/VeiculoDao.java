package br.com.sgo.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sgo.dao.ObjectDao;
import br.com.sgo.model.administrativo.Veiculo;

public class VeiculoDao extends ObjectDao {
	
	private EntityManager em;
	
	public VeiculoDao(EntityManager em) {
		super(em);
		this.em = em;
	}
	
	public List<Veiculo> listarVeiculosAtivos() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("from Veiculo v");
		Query qry = em.createQuery(sb.toString());
		List<Veiculo> veiculos = qry.getResultList(); 
		return veiculos;		
	}

}
