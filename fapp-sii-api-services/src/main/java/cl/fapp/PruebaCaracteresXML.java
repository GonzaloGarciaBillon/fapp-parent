package cl.fapp;

import cl.fapp.common.xml.XMLUtils;

public class PruebaCaracteresXML {

	public static void main(String[] args) {
		//String prueba1 = "Empresas A&B \"Limitada\" y 'todos los demas'";
		String prueba2 = "A este no hay que hacerle nada";
		
		System.out.println("Original=" + prueba2 + ", Convertido=" + XMLUtils.replaceSiiEspecialChars(prueba2));

	}

}
