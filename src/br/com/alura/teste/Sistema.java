package br.com.alura.teste;

import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.alura.model.Produto;

public class Sistema {
	public static void main(String[] args) throws Exception {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Document parse = factory.newDocumentBuilder().parse("src/vendas.xml");

		String exp = "/vendas/produtos/produto";
		XPath path = XPathFactory.newInstance().newXPath();
		XPathExpression expression = path.compile(exp);
		
		NodeList produtos = (NodeList) expression.evaluate(parse, XPathConstants.NODESET);

		List<Produto> listaProdutos = new ArrayList<>();

		for (int i = 0; i < produtos.getLength(); i++) {
			Element item = (Element) produtos.item(i);
			String nome = item.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(item.getElementsByTagName("preco").item(0).getTextContent());
			listaProdutos.add(new Produto(nome, preco));
		}

		for (Produto produto : listaProdutos) {
			System.out.println(produto);
		}

	}
}
