package br.com.sgo.usuario.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.sgo.model.UsuarioModel;
import br.com.sgo.repository.UsuarioRepository;
import br.com.sgo.repository.entity.UsuarioEntity;
import br.com.sgo.utils.Utils;

@Named(value="usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioModel usuarioModel;

	@Inject
	private UsuarioRepository usuarioRepository;

	@Inject
	private UsuarioEntity usuarioEntity;

	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}
	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}

	public UsuarioModel GetUsuarioSession(){

		FacesContext facesContext = FacesContext.getCurrentInstance();
		return (UsuarioModel)facesContext.getExternalContext().getSessionMap().get("usuarioAutenticado");
	}

	public String Logout(){

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/index.xhtml?faces-redirect=true";
	}

	public String EfetuarLogin(){

		if(StringUtils.isEmpty(usuarioModel.getUsuario()) || StringUtils.isBlank(usuarioModel.getUsuario())){

			Utils.Mensagem("Favor Informar o Login!");
			return null;
		} else if(StringUtils.isEmpty(usuarioModel.getSenha()) || StringUtils.isBlank(usuarioModel.getSenha())){

			Utils.Mensagem("Favor Informar a Senha!");
			return null;
		} else {	

			usuarioEntity = usuarioRepository.ValidaUsuario(usuarioModel);

			if(usuarioEntity!= null){

				usuarioModel.setSenha(null);
				usuarioModel.setCodigo(usuarioEntity.getCodigo());

				FacesContext facesContext = FacesContext.getCurrentInstance();

				facesContext.getExternalContext().getSessionMap().put("usuarioAutenticado", usuarioModel);

				return "pages/home?faces-redirect=true";
			} else {

				Utils.Mensagem("Usuário ou Senha Inválido!");
				return null;
			}
		}
	}
}
