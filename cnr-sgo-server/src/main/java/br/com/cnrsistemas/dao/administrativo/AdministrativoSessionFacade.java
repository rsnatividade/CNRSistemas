package br.com.cnrsistemas.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cnrsistemas.model.administrativo.Marca;

public class AdministrativoSessionFacade {

	private EntityManager em;
	
	public AdministrativoSessionFacade(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sgo-pu");
		em = emf.createEntityManager();
	}
	
	public List<Marca> listarMarcasAtivas(){
		MarcaDao marcaDao = new MarcaDao(em);
		return marcaDao.listarMarcasAtivas();
	}
	
	public void salvarMarca(Marca marca){
		MarcaDao marcaDao = new MarcaDao(em);
		marcaDao.salvar(marca);
	}
}
