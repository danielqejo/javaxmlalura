package br.com.alura.jaxb;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBHandler {
	
	@SuppressWarnings("unchecked")
	public static <T> T getTypeFromFile(Class<T> returnedClass, String pathFile) throws JAXBException{
		return (T) getUnmarshaller(returnedClass).unmarshal(new File(pathFile));
	}
	
	public static <T> String transformTypeToXML(Class<T> classType, T object) throws JAXBException{
		StringWriter writer = new StringWriter();
		getMarshaller(classType).marshal(object, writer);
		return writer.toString();
	}
	
	private static <T> Unmarshaller getUnmarshaller(Class<T> returnedClass) throws JAXBException{
		return JAXBContext.newInstance(returnedClass).createUnmarshaller();
	}
	
	private static <T> Marshaller getMarshaller(Class<T> returnedClass) throws JAXBException{
		return JAXBContext.newInstance(returnedClass).createMarshaller();
	}

}
