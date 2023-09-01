    package ativis;

	import org.w3c.dom.*;
	import javax.xml.parsers.*;
	import java.io.*;

	public class App {
	    public static void main(String[] args) {
	        try {
	            File inputFile = new File("cliente.xml");
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(inputFile);

	            doc.getDocumentElement().normalize();

	            NodeList nodeList = doc.getElementsByTagName("cliente");
				System.out.println("Total de passageiros: " + nodeList.getLength());

	            for (int i = 0; i < nodeList.getLength(); i++) {
	                Node node = nodeList.item(i);

	                if (node.getNodeType() == Node.ELEMENT_NODE) {
	                    Element element = (Element) node;
	                    String origem = element.getElementsByTagName("origem").item(0).getTextContent();
	                    System.out.println("Origem: " + origem);
						String destino = element.getElementsByTagName("destino").item(0).getTextContent();
	                    System.out.println("Destino: " + destino);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}