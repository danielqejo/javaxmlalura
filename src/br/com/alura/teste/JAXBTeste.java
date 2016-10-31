package br.com.alura.teste;

import javax.xml.bind.JAXBException;

import br.com.alura.jaxb.JAXBHandler;
import br.com.alura.model.Venda;

public class JAXBTeste {
	public static void main(String[] args) throws Exception {
		
		Venda venda = getVenda();
		
		//mostraVenda(venda);
		
		mostraVendaEmXML(venda);

	}

	private static void mostraVendaEmXML(Venda venda) throws JAXBException {
		System.out.println(JAXBHandler.transformTypeToXML(Venda.class, venda));
	}

	private static void mostraVenda(Venda venda) {
		System.out.println(venda);
	}

	private static Venda getVenda() throws JAXBException {
		return JAXBHandler.getTypeFromFile(Venda.class, "src/vendas.xml");
	}
}
