//ANTONIO JOSE FERNANDEZ BELLURE

//prueba04 de las del corrector de Alicia(supuestamente)

import java.io.*;
import java.util.ArrayList;

public class p04{

	public static void main(String[] args) {

		Coleccion colec = new Coleccion();

		colec.lectura(args[0]);//este fichero solo tiene el mapa

		Localidad localidad = new Localidad("Fnatic City");
		InfoTur info = new InfoTur(2,5,1,2,true);
		String top="*** e-Sports Reckless stadium";
		info.setTop(top);

		localidad.setInfo(info);
		localidad.setCoor(2,5,colec.getMapa());

		System.out.println(localidad);
		System.out.println(colec);

		colec.getLocalidades().add(localidad);

		System.out.println(colec);
	}
}

