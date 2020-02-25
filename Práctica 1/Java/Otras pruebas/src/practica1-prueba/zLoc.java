import java.util.ArrayList;

public class zLoc {
	public static ArrayList<ArrayList<Character>> crearMapa(){
		char matriz [][] = {
				{'T', 'M', 'M', 'T'},
				{'M', 'M', 'T', 'T'},
				{'M', 'T', 'M', 'T'}			
		};
		ArrayList<ArrayList<Character>> mapache;
		mapache = new ArrayList<ArrayList<Character>>();
		for(int i = 0; i < 3; i++) {
			ArrayList<Character> fila = new ArrayList<Character>();
			for(int j = 0; j < 4; j++) {
				fila.add(matriz[i][j]);
			}
			mapache.add(fila);
		}
		return mapache;
	}
	
	public static void imprimirMapa(ArrayList<ArrayList<Character>> mapache) {
		for(int i = 0; i < mapache.size(); i++) {
			for(int j = 0; j < mapache.get(i).size(); j++) {
				System.out.print(mapache.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		int i, j;
		Localidad loc = new Localidad("town");
		System.out.println(loc.getNombre() + " " + loc.getId());
		ArrayList<ArrayList<Character>> mapa;
		mapa = crearMapa();
		imprimirMapa(mapa);
		
		for(i = -1; i <= (int) mapa.size(); i++) {
			for(j = -1; j <= (int) mapa.get(0).size(); j++) {
				Localidad nueva = new Localidad("tosis");
				System.out.println(i + " " + j + " => " + nueva.setCoor(i,  j, mapa));
				System.out.println("la localidad se queda con la id " + nueva.getId());
				System.out.println("la localidad se queda en la coordenada " + nueva.getCoor().getFila() + " " + nueva.getCoor().getColumna());
			}
		}
		System.out.println();
		System.out.println();
		imprimirMapa(mapa);
	}
}
