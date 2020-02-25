
// DNI 23900715N HERNANEZ GOMEZ, JESSICA

import java.util.*;

public class TIndice {
	private TreeMap<String, TreeSet<Integer>> ti;

	public TIndice() {
		ti = new TreeMap<String, TreeSet<Integer>>();
	}

	public boolean esVacio() {
		if (ti.isEmpty() == true) {
			return true;
		} else {
			return false;
		}
	}

	public void insertaColeccion(Coleccion c) {
		if (c != null) {
			ArrayList<Docum> docs = c.getTextos();
			ArrayList<String> dic = c.getDiccionario();
			ArrayList<Token> t;

			for (int x = 0; x < dic.size(); x++) {
				if (!ti.containsKey(dic.get(x))) {
					TreeSet<Integer> neo = new TreeSet<>();
					ti.put(dic.get(x), neo);
				}
				for (int y = 0; y < docs.size(); y++) {
					t = docs.get(y).getVecGeneral();
					for (int z = 0; z < t.size(); z++) {
						if (t.get(z).getPalabra().equalsIgnoreCase(dic.get(x))) {
							agregaId(dic.get(x), docs.get(y).getId());
						}
					}
				}
			}
		}
	}

	public TreeSet<Integer> borra(String p) {
		TreeSet<Integer> devolver = null;
		if (p != null) {
			devolver = ti.remove(p.toLowerCase());
		}
		return devolver;
	}

	public Set<String> getPalabras() {
		return ti.keySet();
	}

	public TreeSet<Integer> getDocum(String p) {
		TreeSet<Integer> devolver = null;

		if (p != null && ti.containsKey(p.toLowerCase())) {
			devolver = ti.get(p.toLowerCase());
		}
		return devolver;
	}

	public boolean inserta(String p) {
		if (p != null && ti.containsKey(p.toLowerCase()) == false) {
			ti.put(p.toLowerCase(), new TreeSet<Integer>());
			return true;
		} else {
			return false;
		}
	}

	public boolean agregaId(String p, int i) {
		TreeSet<Integer> ts = ti.get(p.toLowerCase());
		if (ts != null && !ts.contains(i)) {
			ts.add(i);
			ti.put(p.toLowerCase(), ts);
			return true;
		} else {
			return false;
		}
	}

	public void escribeIndice() {
		Set<String> pal = ti.keySet();
		TreeSet<Integer> id;
		boolean primero = true;

		for (int x = 0; x < pal.size(); x++) {
			Object[] arrayp = pal.toArray();
			String p = (String) arrayp[x];
			primero = true;
			id = ti.get(p);
			System.out.print(p + " * ");
			for (int y = 0; y < id.size(); y++) {
				Object[] arrayid = id.toArray();
				Integer i = (Integer) arrayid[y];
				if (primero == true) {
					System.out.print(i);
					primero = false;
				} else {
					System.out.print(" - " + i);
				}
			}
			System.out.println();
		}
	}
}
