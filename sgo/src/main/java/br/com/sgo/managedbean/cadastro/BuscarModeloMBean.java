package br.com.sgo.managedbean.cadastro;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.sgo.dao.administrativo.AdministrativoSessionFacade;
import br.com.sgo.model.administrativo.Modelo;

@ManagedBean
@ViewScoped
public class BuscarModeloMBean {

	private AdministrativoSessionFacade admSession;

	private List<Modelo> modelos;

	@PostConstruct
	public void init() {
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
		RequestContext.getCurrentInstance().closeDialog(modelo);
	}

}
