
//23900715N HERNANDEZ GOMEZ, JESSICA
import java.util.*;

public class Localidad {
	private String nombre;
	private Coordenadas coor;
	private InfoTur info;
	private int id;

	public Localidad(String n) {
		nombre = n;
		coor = new Coordenadas();
		info = new InfoTur();
		id = -1;
	}

	public int setCoor(int f, int c, ArrayList<ArrayList<Character>> mapa){
		int devolver = -1;
		
		if(mapa!=null){
			if(f >= 0 && f < mapa.size() && c >= 0 && c < mapa.get(0).size()){
				if (mapa.get(f).get(c)!=null){
					//System.out.println("Qué hay aqui: " + mapa.get(f).get(c));
					if(mapa.get(f).get(c)!= -1){
						if(mapa.get(f).get(c) == 'T'){
							coor = new Coordenadas(f, c);
							mapa.get(coor.getFila()).set(coor.getColumna(),'L');
							id = mapa.get(1).size() * coor.getFila() + coor.getColumna();
							devolver = id;
						}
					}
				}
			}
		}
		
		return devolver;
	}

	public void setInfo(InfoTur it) {
		info = it;
	}
	
	public void setCoordenada(Coordenadas c){
		coor = c;
	}
	
	public void setId(int n){
		id = n;
	}

	public String getNombre() {
		return nombre;
	}

	public Coordenadas getCoor() {
		return coor;
	}

	public InfoTur getInfo() {
		return info;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		String devolver = id + "-" + nombre + "-" + coor.toString() + info.toString();
		return devolver;
	}
}
