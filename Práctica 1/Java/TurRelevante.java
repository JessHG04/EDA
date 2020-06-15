
//23900715N HERNANDEZ GOMEZ, JESSICA
import java.util.*;

public class TurRelevante {
	public static void main(String[] args) {
		Coleccion colec = new Coleccion();

		if (args.length == 1) {
			if (args[0] != null) {
				colec.lectura(args[0]);

				for (int x = 0; x < colec.getLocalidades().size(); x++) {
					System.out.print(colec.getLocalidades().get(x).getNombre() + " (" + colec.getLocalidades().get(x).getCoor().getFila() + "," + colec.getLocalidades().get(x).getCoor().getColumna() + "): ");
					System.out.print(colec.getLocalidades().get(x).getInfo().getMasFrecuente());

					if (colec.getLocalidades().get(x).getInfo().getTop().equals("") == false) {
						System.out.print(" - " + colec.getLocalidades().get(x).getInfo().getTop());
					}
					System.out.println();
				}
			}
		}
	}
}
