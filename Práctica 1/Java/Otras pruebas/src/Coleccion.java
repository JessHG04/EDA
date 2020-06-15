import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Coleccion {
	private ArrayList<Localidad> localidades;
	private ArrayList<ArrayList<Character>> mapa;
	public Coleccion() {
		localidades = new ArrayList<Localidad>();
		mapa = new ArrayList<ArrayList<Character>>();
	}
	/*
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < mapa.size(); i++){
			for(int j = 0; j < mapa.get(0).size(); j++){
				sb.append(mapa.get(i).get(j));
			}
			sb.append('\n');
		}
		for(int i = 0; i < localidades.size(); i++){
			sb.append(localidades.get(i).toString());
		}
		return sb.toString();
	}
	 */
	public String toString() {
		String alice = "";
		
		for(int i = 0; i < mapa.size(); i++){
			for(int j = 0; j < mapa.get(0).size(); j++){
				alice += mapa.get(i).get(j);
			}
			alice += '\n';
		}
		for(int i = 0; i < localidades.size(); i++){
			alice += localidades.get(i).toString();
		}
		return alice;
	}
	public void lectura(String nombre) {
		String linea, nombreLocalidad, item;
		int ci, cj, cantidad;
		FileReader fr = null;
		BufferedReader br = null;
		String tor;
		String [] trozos;
		int nmus, nhot, nres, nmon;
		boolean ae;

		try {
			fr = new FileReader(nombre);
			br = new BufferedReader(fr);
			if(fr != null) {
				linea = br.readLine();
				while(linea != null && !linea.equals("<LOCALIDAD>")){
					ArrayList<Character> ass = new ArrayList<Character>();		
					for(int i = 0; i < linea.length(); i++){
						ass.add(linea.charAt(i));	
					}		
					mapa.add(ass);
					linea = br.readLine();
				}
				while(linea != null){
					nombreLocalidad = br.readLine();
					// leo las coordenadas
					// fich >> ci >> cj;
					linea = br.readLine();
					trozos = linea.split(" ");
					ci = Integer.parseInt(trozos[0]);
					cj = Integer.parseInt(trozos[1]);
					// creo la localidad con los datos leidos
					Localidad loc = new Localidad(nombreLocalidad);
					loc.setCoor(ci, cj, mapa);
					
					linea = br.readLine();
					linea = br.readLine();
					nmon = nmus = nhot = nres = 0;
					tor = "";
					ae = false;	
					while(linea != null && !linea.equals("<LOCALIDAD>")){
						// Comprobar si es un top!!!
						// si es top, lo guardais top
						if(linea.charAt(0) == '*'){
							tor = linea;
						}
						else{
							// si no es top partimos linea
							//stringstream ss(linea);
							//ss >> item >> cantidad;			
							trozos = linea.split(" ");
							item = trozos[0];
							if(trozos.length > 1) {
								cantidad = Integer.parseInt(trozos[1]);
							}
							else {
								cantidad = 1;
							}
							if(item.equals("museo")){
								nmus = cantidad;
							}
							if(item.equals("hotel")){
								nhot = cantidad;
							}
							if(item.equals("restaurante")){
								nres = cantidad;
							}
							if(item.equals("aeropuerto")){
								ae = true;
							}
							if(item.equals("monumento")){
								nmon = cantidad;
							}
						}		
						linea = br.readLine();
					}
					// Crear un infoTur con la informacion leida
					InfoTur nuevo = new InfoTur(nmus, nmon, nhot, nres, ae);
					nuevo.setTop(tor);
					loc.setInfo(nuevo);
					if(loc.getCoor().getFila() != -1){
						localidades.add(loc);
					}
					// Modificar la localidad con el infotur leido
					// y meterlo en el vector de localidades!!!
					
				}
				if(fr != null && br != null){
					fr.close();
					br.close();
				}
			}
		}catch(Exception e) {
			
		}
	}
	public ArrayList<ArrayList<Character>> getMapa(){
		return mapa;
	}
	public ArrayList<Localidad> getLocalidades(){
		return localidades;
	}
	public char getCoorMapa(Coordenadas coor) {
		char letra = 'X';
		if(coor.getFila() >= 0 && coor.getColumna() >= 0 &&
				coor.getFila() <(int) mapa.size() && coor.getColumna() < (int) mapa.get(0).size()){
				letra = mapa.get(coor.getFila()).get(coor.getColumna());
			}
		return letra;
	}
}




