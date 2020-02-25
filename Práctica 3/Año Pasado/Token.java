// DNI 23900715N HERNANEZ GOMEZ, JESSICA

public class Token {
	private String pal;
	private int frec;
	
	public Token() {
		pal = "";
		frec = 0;
	}
	
	public Token(String p) {
		if(p!=null) {
			pal = p;
		}else {
			pal = "";
		}
		frec = 1;
	}
	/*NEW*/
	public Token(String p, int f) {
		if(p!=null) {
			pal = p;
		}else {
			pal = "";
		}
		frec = f;
	}

	public String getPalabra() {
		return pal;
	}

	public int getFrecuencia() {
		return frec;
	}
		
	public Token masMas() {
		++frec;
		return this;
	}
	/*NEW*/
	public void setPalabra(String p) {
		pal = p;
	}

	public void setFrecuencia(int f) {
		frec = f;
	}
	
	public String toString() {
		String cadena = pal + " " + frec + "\n";
		return cadena;
	}

	
}
