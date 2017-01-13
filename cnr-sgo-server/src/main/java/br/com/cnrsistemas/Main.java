package br.com.cnrsistemas;

import java.util.List;

import br.com.cnrsistemas.bean.administrativo.CadastrosBean;
import br.com.cnrsistemas.model.administrativo.Marca;

public class Main {

	public static void main(String[] args) {
		
		try{

			CadastrosBean bean = new CadastrosBean();
			List<Marca> marcas = bean.listarMarcas();
			
			for(Marca marca : marcas){
				System.out.println(marca.getId());
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		System.exit(0);
	}
}
