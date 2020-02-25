import java.util.ArrayList;

public class TurRelevante {
	public static void main(String [] args) {
		Coleccion nikol;
		ArrayList<Localidad> locas;
		String masFrecuente;
		
		if(args.length == 1) {
			nikol = new Coleccion();
			nikol.lectura(args[0]);
			locas = nikol.getLocalidades();
			for(int i = 0; i < (int) locas.size(); i++) {
				System.out.print(locas.get(i).getNombre() + " " + locas.get(i).getCoor() + ": ");
				masFrecuente = locas.get(i).getInfo().getMasFrecuente();
				System.out.print(masFrecuente);
				if(!locas.get(i).getInfo().getTop().isEmpty()) {
					System.out.print(" - " + locas.get(i).getInfo().getTop());
				}
				System.out.println();
			}
		}
	}
}
