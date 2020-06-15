
// DNI 23900715N HERNANEZ GOMEZ, JESSICA
import java.util.*;

public class ConsultaIndice2 {
	public static void main(String[] args) {
		if (args.length == 5) {

			TreeSet<Integer> solucion = new TreeSet<Integer>();
			Coleccion colec = new Coleccion();
			TIndice TInd = new TIndice();
			TreeSet<Integer> cad1 = new TreeSet<Integer>();
			TreeSet<Integer> cad2 = new TreeSet<Integer>();
			boolean primero = true;

			colec.leeDic(args[0]);
			colec.leeDoc(args[1]);
			TInd.insertaColeccion(colec);

			cad1 = TInd.getDocum(args[2]);
			cad2 = TInd.getDocum(args[4]);

			if (args[3] == "A" && cad1 != null && cad2 != null) {
				for (int x = 0; x < cad1.size(); x++) {
					Object[] arraycad1 = cad1.toArray();
					Integer i = (Integer) arraycad1[x];
					if (cad2.contains(i)) {
						solucion.add(i);
					}
				}
			} else if (args[3] == "O") {
				if (cad1 != null) {
					solucion.addAll(cad1);
				}
				if (cad2 != null) {
					solucion.addAll(cad2);
				}
			}

			if (solucion.size() > 0) {
				System.out.print("SOL = ");
				for (int y = 0; y < solucion.size(); y++) {
					Object[] arrayid = solucion.toArray();
					Integer i = (Integer) arrayid[y];
					if (primero == true) {
						System.out.print(i);
						primero = false;
					} else {
						System.out.print(" - " + i);
					}
				}
				System.out.println();
			} else {
				System.out.println("SOL = No existe");
			}
			TInd.escribeIndice();
		}
	}
}
