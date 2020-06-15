import java.util.ArrayList;

public class Localidad {
	private String nombre;
	private Coordenadas coor;
	private InfoTur info;
	private int id;
	public Localidad(String n){
		nombre = n;
		id = -1;
		coor = new Coordenadas();
		info = new InfoTur();
	}
	
	public void setInfo(InfoTur i){
		info = i;
	}
	public String getNombre(){
		return nombre;
	}
	public Coordenadas getCoor(){
		return coor;
	}
	public InfoTur getInfo(){
		return info;
	}
	public int getId(){
		return id;
	}
	public String toString(){
		return id + "-" + nombre + "-" + getCoor() + "\n" + getInfo();
	}

	public int setCoor(int i, int j, ArrayList<ArrayList<Character>> mapa){
		int nuevoId = -1;
		Coordenadas auxiliar = new Coordenadas(i, j);

		if(coor.getFila() == -1 && coor.getColumna() == -1 && i >= 0 && i < mapa.size() && j >= 0 && j < mapa.get(0).size()){		 
			if(mapa.get(i).get(j) == 'T'){
				coor = auxiliar;
				mapa.get(i).set(j, 'L');
				id = mapa.get(0).size() * i + j;
				nuevoId = id;
			}
		}
		return nuevoId;		
	}

	
}
