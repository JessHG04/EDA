import java.util.ArrayList;

public class zCol01 {
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
		
		col.lectura("zCol01.dat");
		mapa = col.getMapa();
		locas = col.getLocalidades();
		imprimirMapa(mapa);
		imprimirLocalidades(locas);
	}
}
