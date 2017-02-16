package br.com.cnrsistemas.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.cnrsistemas.model.administrativo.Marca;
import br.com.cnrsistemas.model.administrativo.Veiculo;

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
	
	public void removerMarca(Marca marca){
		MarcaDao marcaDao = new MarcaDao(em);
		marcaDao.excluir(marca);
	}
	
	public List<Veiculo> listarVeiculosAtivos() {
		VeiculoDao veiculoDao = new VeiculoDao(em);
		return veiculoDao.listarVeiculosAtivos();
	}
	
	public void salvarVeiculo(Veiculo veiculo) {
		VeiculoDao veiculoDao = new VeiculoDao(em);
		veiculoDao.salvar(veiculo);
	}

	public void removerVeiculo(Veiculo veiculo) {
		VeiculoDao veiculoDao = new VeiculoDao(em);
		veiculoDao.excluir(veiculo);
	}
}
