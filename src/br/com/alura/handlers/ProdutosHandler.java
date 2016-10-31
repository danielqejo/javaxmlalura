package br.com.alura.handlers;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import br.com.alura.model.Produto;

public class ProdutosHandler extends DefaultHandler {
	
	private List<Produto> produtos = new ArrayList<>();
	private Produto produto;
	private StringBuilder stringBuilder;
	
	@Override
	public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
			throws SAXException {
		if(paramString3.equals("produto")){
			produto = new Produto();
		}
		
		stringBuilder = new StringBuilder();
	}
	
	@Override
	public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2) throws SAXException {
		stringBuilder.append(new String(paramArrayOfChar,paramInt1,paramInt2));
	}
	
	@Override
	public void endElement(String paramString1, String paramString2, String paramString3) throws SAXException {
		if(paramString3.equals("produto")){
			produtos.add(produto);
		}else if(paramString3.equals("nome")) {
			produto.setNome(stringBuilder.toString());
		}else if(paramString3.equals("preco")){
			produto.setPreco(Double.parseDouble(stringBuilder.toString()));
		}
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
