//23900715N HERNANDEZ GOMEZ, JESSICA
public class Coordenadas {
	private int fila;
	private int columna;
	
	public Coordenadas(){
		fila = -1;
		columna = -1;
	}
	
	public Coordenadas(int i, int j){
		if(i>=0){
			fila = i;
		}else{
			fila = -1;
		}
		if(j>=0){
			columna = j;
		}
		else{
			columna = -1;
		}
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public String toString(){
		String cadena = "(" + fila + "," + columna + ")" + "\n";
		return cadena;
	}

	public boolean equals(Object p){
		boolean devolver = false;

		if(p instanceof Coordenadas){
			if(((Coordenadas)p).getFila() == ((Coordenadas)p).getColumna()){
				devolver = true;
			}
		}

		return devolver;
	}
}
