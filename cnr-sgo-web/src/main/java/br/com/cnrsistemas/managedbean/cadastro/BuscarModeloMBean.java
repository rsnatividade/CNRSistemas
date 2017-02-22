package br.com.cnrsistemas.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.cnrsistemas.dao.administrativo.AdministrativoSessionFacade;
import br.com.cnrsistemas.model.administrativo.Modelo;

@ManagedBean
@ViewScoped
public class BuscarModeloMBean {
	
	private AdministrativoSessionFacade admSession;
	
	private List<Modelo> modelos;
	
	@PostConstruct
	public void init(){		
		admSession = new AdministrativoSessionFacade();
		modelos = admSession.listarModelosAtivos();			
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}
	
	public void selecionar(Modelo modelo) {
		System.out.println(modelo.getNome() + "1");
		RequestContext.getCurrentInstance().closeDialog(modelo);
	}

}
