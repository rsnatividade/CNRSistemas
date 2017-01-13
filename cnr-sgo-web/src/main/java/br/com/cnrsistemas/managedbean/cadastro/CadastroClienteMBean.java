package br.com.cnrsistemas.managedbean.cadastro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cnrsistemas.model.administrativo.Cliente;
import br.com.cnrsistemas.model.gerencial.Cargo;

@ManagedBean
@ViewScoped
public class CadastroClienteMBean {

	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	@PostConstruct
	public void init(){
		Cliente cliente = new Cliente();
		cliente.setId(Double.valueOf((Math.random() * 1000)).intValue());
		cliente.setDescricao("Robson Schneider da Natividade");
		Cargo cargo = new Cargo();
		cargo.setId(Double.valueOf((Math.random() * 1000)).intValue());
		cargo.setDescricao("Colaborador");
		cliente.setCargo(cargo);
		
		clientes.add(cliente);
	}

	public void incluirCliente(){
		Cliente cliente = new Cliente();
		cliente.setId(Double.valueOf((Math.random() * 1000)).intValue());
		cliente.setDescricao("Robson Schneider da Natividade");
		Cargo cargo = new Cargo();
		cargo.setId(Double.valueOf((Math.random() * 1000)).intValue());
		cargo.setDescricao("Colaborador");
		cliente.setCargo(cargo);
		
		clientes.add(cliente);
	}
	
	public void editarCliente(Cliente cliente){
		
	}
	
	public void excluirCliente(Cliente cliente){
		
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
