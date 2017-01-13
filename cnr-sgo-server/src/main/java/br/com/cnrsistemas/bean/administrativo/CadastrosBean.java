package br.com.cnrsistemas.bean.administrativo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.cnrsistemas.model.administrativo.Marca;
import br.com.cnrsistemas.remote.administrativo.CadastrosBeanRemote;
import br.com.cnrsistemas.utils.UtilConexao;

public class CadastrosBean implements CadastrosBeanRemote {

	EntityManager em = UtilConexao.getEntityManager();
	
	@Override
	public List<Marca> listarMarcas() {
		List<Marca> marcas = new ArrayList<Marca>();
		try{
			Query qry = em.createQuery("from Marca");
			marcas.addAll(qry.getResultList());
			em.close();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
		return marcas;
	}

	
}
