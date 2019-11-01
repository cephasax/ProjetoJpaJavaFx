package br.ufrn.imd.main;

import java.util.Calendar;

import br.ufrn.imd.dao.GenericDAO;
import br.ufrn.imd.model.Carro;

public class Principal {

	
	public static void main(String[] args) {
		GenericDAO gdao = new GenericDAO();
		Calendar data = Calendar.getInstance();
		//Inserir objetos no banco
		
		Carro carro1 = new Carro();
		carro1.setModelo("Astra");
		carro1.setDataFabricacao(data.getTime());
		carro1.setApelido("Astra bonito");
		carro1.setPlaca("AAA-0000");
		
		Carro carro2 = new Carro();
		carro2.setModelo("Celta");
		carro2.setDataFabricacao(data.getTime());
		carro2.setApelido("Celta preto rebaixado");
		carro1.setPlaca("XXX-9999");
		
		gdao.inserir(carro1);
		gdao.inserir(carro2);
	}
	

}
