import java.util.ArrayList;

public class zCol03 {
	public static void imprimirMapa(ArrayList<ArrayList<Character>> mapa){
		for(int i = 0; i < mapa.size(); i++) {
			for(int j = 0; j < mapa.get(i).size(); j++) {
				System.out.print(mapa.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void imprimirLocalidades(ArrayList<Localidad> localidades) {
		for(int i = 0; i< localidades.size(); i++) {
			System.out.println(localidades.get(i).toString());
		}
	}
	public static void main(String [] args) {
		Coleccion col = new Coleccion();
		ArrayList<Localidad> locas;
		ArrayList<ArrayList<Character>> mapa;
		
		col.lectura("zCol03.dat");
		mapa = col.getMapa();
		locas = col.getLocalidades();
		imprimirMapa(mapa);
		imprimirLocalidades(locas);
	
		for(int i = -1; i <= (int) mapa.size(); i++) {
			for(int j = -1; j <= (int) mapa.get(0).size(); j++) {
				System.out.print(col.getCoorMapa(new Coordenadas(i, j)));
			}
			System.out.println();
		}
	}
}
