// DNI 23900715N HERNANEZ GOMEZ, JESSICA
import java.util.*;
import java.io.*;

public class Coleccion {
	private ArrayList<Docum> documentos;
	private ArrayList<String> diccionario;

	public Coleccion() {
		documentos = new ArrayList<Docum>();
		diccionario = new ArrayList<String>();

	}

	public void leeDoc(String f) {
		FileReader fichero = null;
		BufferedReader lectura = null;
		String linea;
		String[] elementos;
		String separador = "[,:;?!\\.() ]+";
		Docum docum = null;
		int identificador = 1;

		try {
			fichero = new FileReader(f);
			lectura = new BufferedReader(fichero);
			linea = lectura.readLine();

			while (linea != null) {
				if (linea.equals("<CAT>")) {
					linea = lectura.readLine();
					docum = new Docum(identificador, linea);
					documentos.add(docum);
					identificador++;
					linea = lectura.readLine();
				}

				if (linea.equals("<TEXTO>")) {
					while (linea != null && linea.equals("<CAT>") == false) {
						linea = lectura.readLine();
						if (linea != null && linea.equals("<CAT>") == false) {
							elementos = linea.split(separador);
							for (int x = 0; x < elementos.length; x++) {
								if(elementos[x]!= " "){
									docum.addToken(elementos[x]);
								}
							}
						}
					}
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

	public void leeDic(String f) {
		FileReader fichero = null;
		BufferedReader lectura = null;
		String linea;
		String[] elementos;
		String separador = "[,:;?!\\.() ]+";

		try {
			fichero = new FileReader(f);
			lectura = new BufferedReader(fichero);
			linea = lectura.readLine();

			while (linea != null) {
				elementos = linea.split(separador);
				for (int x = 0; x < elementos.length; x++) {
					diccionario.add(elementos[x].toLowerCase());
				}
				linea = lectura.readLine();
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

	public ArrayList<Docum> getTextos() {
		return documentos;
	}

	public ArrayList<String> getDiccionario() {
		return diccionario;
	}

	public String toString() {
		String cadena = "";
		if (documentos.size() > 0) {
			cadena = toStringDocumentos();
		}
		if (diccionario.size() > 0) {
			cadena = cadena + toStringDiccionario();
		}
		return cadena;
	}

	private String toStringDocumentos() {
		String cadena = "";
		for (int x = 0; x < documentos.size(); x++) {
			cadena = cadena + documentos.get(x).toString();
		}
		return cadena;
	}

	private String toStringDiccionario() {
		String cadena = "";
		for (int x = 0; x < diccionario.size(); x++) {
			cadena = cadena + diccionario.get(x) + " ";
		}
		return cadena;
	}
}
