package br.com.sgo.dao.administrativo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sgo.model.administrativo.Marca;
import br.com.sgo.model.administrativo.Modelo;
import br.com.sgo.model.administrativo.Orcamento;
import br.com.sgo.model.administrativo.Veiculo;
import br.com.sgo.model.operacional.Produto;

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
	
	public void salvarModelo(Modelo modelo){
		ModeloDao modeloDao = new ModeloDao(em);
		modeloDao.salvar(modelo);
	}
	
	public void removerModelo(Modelo modelo){
		ModeloDao modeloDao = new ModeloDao(em);
		modeloDao.excluir(modelo);
	}

	public List<Modelo> listarModelosAtivos(){
		ModeloDao modeloDao = new ModeloDao(em);
		return modeloDao.listarModelosAtivos();
	}
	
	public List<Produto> listarProdutos(){
		ProdutoDao produtoDao = new ProdutoDao(em);
		return produtoDao.listarProdutosAtivos();
	}
	
	public List<Orcamento> listarOrcamentosAbertos() {
		OrcamentoDao orcamentoDao = new OrcamentoDao(em);
		return orcamentoDao.listarOrcamentosAbertos();
	}
	
	public void salvarOrcamento(Orcamento orcamento) {
		OrcamentoDao orcamentoDao = new OrcamentoDao(em);
		orcamentoDao.salvar(orcamento);
	}
	
	public void removerOrcamento(Orcamento orcamento) {
		OrcamentoDao orcamentoDao = new OrcamentoDao(em);
		orcamentoDao.excluir(orcamento);
	}
}
