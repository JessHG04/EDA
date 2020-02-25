

public class Coordenadas {
	private int fila;
	private int columna;
	public Coordenadas() {
		fila = -1;
		columna = -1;
	}
	public Coordenadas(int vfila, int vcolumna) {
		if(vfila < 0 || vcolumna < 0){
			fila = -1;
			columna = -1;
		}
		else{
			fila = vfila;
			columna = vcolumna;
		}
	}
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}
	public String toString() {
		return "(" + fila + "," + columna + ")"; 
	}
}
