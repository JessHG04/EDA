//ANTONIO JOSE FERNANDEZ BELLURE

//prueba04 de las del corrector de Alicia(supuestamente)

import java.io.*;
import java.util.ArrayList;

public class p05{

	public static void main(String[] args) {

		Coleccion colec = new Coleccion();

		colec.lectura(args[0]);//este fichero tiene el mapa y diferentes localidades con la misma ubicacion

		System.out.println(colec);

		
	}
}