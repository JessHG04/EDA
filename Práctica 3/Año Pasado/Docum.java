// DNI 23900715N HERNANEZ GOMEZ, JESSICA
import java.util.*;

public class Docum {

	private int id;
	private String cat;
	private ArrayList<Token> general;
	private ArrayList<Token> basico;
	private Token defecto;

	public Docum() {
		id = 0;
		cat = "";
		general = new ArrayList<Token>();
		basico = new ArrayList<Token>();
		defecto = new Token();
	}

	public Docum(int i, String c) {
		id = i;
		cat = c;
		general = new ArrayList<Token>();
		basico = new ArrayList<Token>();
		defecto = new Token();
	}

	public int getId() {
		return id;
	}

	public String getCat() {
		return cat;
	}

	public ArrayList<Token> getVecGeneral() {
		return general;
	}

	public ArrayList<Token> getVecBasico() {
		return basico;
	}

	public Token masFrec() {
		int mas = 0;
		int pos = 0;

		if (general != null && general.size() < 1) {
			return defecto;
		}

		if (general != null && general.size() > 0) {
			for (int x = 0; x < general.size(); x++) {
				if (general.get(x).getFrecuencia() > mas) {
					pos = x;
					mas = general.get(x).getFrecuencia();
				}
			}
		}

		return general.get(pos);
	}

	public int generaBasico(ArrayList<String> diccionario) {
		int devolver = 0;
		boolean esta = false;
		Token t;
		for (int x = 0; x < general.size(); x++) {
			esta = false;
			for (int y = 0; y < diccionario.size() && esta == false; y++) {
				if ((general.get(x).getPalabra().equals(diccionario.get(y)) == true)) {
					esta = true;
				}
			}
			if (esta == true) {
				devolver++;
			} else {
				t = new Token(general.get(x).getPalabra(), general.get(x).getFrecuencia());
				basico.add(t);
			}
		}
		return devolver;
	}
	
	public void addToken(String s) {
		boolean metido = false;
		String m;
		Token t;

		for (int x = 0; x < general.size() && metido == false; x++) {
			if (general.get(x).getPalabra().equalsIgnoreCase(s) == true) {
				general.get(x).masMas();
				metido = true;
			}
		}

		if (metido == false) {
			m = s.toLowerCase();
			t = new Token(m);
			general.add(t);
		}
	}

	public String toString() {
		String cadena = id + "-" + cat + "\n";
		if (general.size() > 0) {
			cadena = cadena + toStringGeneral();
		}
		if (basico.size() > 0) {
			cadena = cadena + toStringBasico();
		}

		return cadena;
	}

	public String toStringGeneral() {
		String cadena = "";

		for (int x = 0; x < general.size(); x++) {
			cadena = cadena + general.get(x).toString();
		}
		return cadena;
	}

	public String toStringBasico() {
		String cadena = "";

		for (int x = 0; x < basico.size(); x++) {
			cadena = cadena + basico.get(x).toString();
		}
		return cadena;
	}

}
