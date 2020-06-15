//23900715N HERNANDEZ GOMEZ, JESSICA
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Coleccion {
	private ArrayList<ArrayList<Character>> mapa;
	private ArrayList<Localidad> localidades;

	public Coleccion() {
		mapa = new ArrayList<ArrayList<Character>>();
		localidades = new ArrayList<Localidad>();
	}

	public void lectura(String f) {
		FileReader fichero = null;
		BufferedReader lectura = null;
		String linea;
		String[] elementos;
		String separador = "[ ]+";
		Localidad l;
		InfoTur it;

		int museo = -1;
		int monumento = -1;
		int hotel = -1;
		int restaurante = -1;
		boolean ae = false;
		String top = "";

		try {
			fichero = new FileReader(f);
			lectura = new BufferedReader(fichero);
			linea = lectura.readLine();

			int x = 0;
			while (linea != null) {
				if (linea.equals("<LOCALIDAD>") == false) {
					// LECTURA MAPA
					//System.out.println("Empiezo a leer el mapa");
					mapa.add(new ArrayList<Character>());
					
					for (int y = 0; y < linea.length(); y++) {
						mapa.get(x).add(linea.charAt(y));
					}
					
					linea = lectura.readLine();
					x++;
					//System.out.println("He terminado de leer el mapa");
				} else {
					// LECTURA LOCALIDADES
					//System.out.println("Empiezo a leer localidades");
					linea = lectura.readLine(); // Nombre localidad
					l = new Localidad(linea); // Creo la localidad
					linea = lectura.readLine();
					elementos = linea.split(separador);
					//System.out.println("Elemento 1: " + Integer.parseInt(elementos[0]) + "Elemento 2: " + Integer.parseInt(elementos[1]));
					int esta=l.setCoor(Integer.parseInt(elementos[0]), Integer.parseInt(elementos[1]), mapa) ;//!= -1){ // Agrego coordenadas
						// INFORMACION
						//System.out.println("Empiezo con la info de las localidades");
						linea = lectura.readLine(); // <INFO>
						linea = lectura.readLine();
						while (linea!=null && linea.equals("<LOCALIDAD>") == false) {
							elementos = linea.split(separador);
							if (elementos[0].equals("museo")) {
								museo = Integer.parseInt(elementos[1]);
							}
							if (elementos[0].equals("monumento")) {
								monumento = Integer.parseInt(elementos[1]);
							}
							if (elementos[0].equals("hotel")) {
								hotel = Integer.parseInt(elementos[1]);
							}
							if (elementos[0].equals("restaurante")) {
								restaurante = Integer.parseInt(elementos[1]);
							}
							if (elementos[0].equals("aeropuerto")) {
								ae = true;
							}
							if (elementos[0].contains("*")) {
								top = linea;
							}
							linea = lectura.readLine();
						}
	
						it = new InfoTur(museo, monumento, hotel, restaurante, ae);
						it.setTop(top);						
						museo = -1;
						monumento = -1;
						hotel = -1;
						restaurante = -1;
						ae = false;
						top = "";
						l.setInfo(it);
						if(esta>-1)
						localidades.add(l);
						
					}
				}
			
		} catch (IOException e) {
			System.err.println("Error con el fichero");
			System.exit(0);
		}

		try {
			if (fichero != null) {
				fichero.close();
			}
			if (lectura != null) {
				lectura.close();
			}
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}

	public ArrayList<ArrayList<Character>> getMapa() {
		return mapa;
	}

	public ArrayList<Localidad> getLocalidades() {
		return localidades;
	}

	public char getCoorMapa(Coordenadas c) {
		char devolver = 'X';
		
		if(c.getFila() >= 0 && c.getColumna() >= 0){
			if(c.getFila() < mapa.size() && c.getColumna() < mapa.get(0).size()){
				devolver = mapa.get(c.getFila()).get(c.getColumna());
			}
		}
		return devolver;
	}

	public String toString() {
		String devolver = "";
		// MAPA
		for (int x = 0; x < mapa.size(); x++) {
			for (int y = 0; y < mapa.get(x).size(); y++) {
				devolver = devolver + mapa.get(x).get(y);
			}
			devolver = devolver + "\n";
		}
		// LOCALIDADES
		for (int z = 0; z < localidades.size(); z++) {
			devolver = devolver + localidades.get(z).toString();
		}

		return devolver;
	}
}
