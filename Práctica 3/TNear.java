//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
import java.util.*;
public class TNear {
    private TreeMap<Localidad2, TreeSet<Localidad2>> ti;
    private int dn;

    public TNear(int i){
        if (i < 0){
            dn = 0;
        }else{
            dn = i;
        }
        ti = new TreeMap<Localidad2, TreeSet<Localidad2>>();
    }

    public boolean esVacio(){
        boolean devolver = false;

        if(ti.isEmpty()){
            devolver = true;
        }

        return devolver;
    }

    public int distanciaManhattan(int x1, int x2, int y1, int y2){
        int distancia = 0;

        distancia = Math.abs(x1 - y1) + Math.abs(x2 - y2);

        return distancia;
    }

    public void insertaLocalidad2(Localidad2 w){
        TreeSet<Localidad2> insertar = new TreeSet<>();
        TreeSet<Localidad2> cercanas = new TreeSet<Localidad2>(); //Value
        int dm;
        Localidad2 key = null;
        if(w!= null && !ti.containsKey(w)){
            for(Map.Entry<Localidad2, TreeSet<Localidad2>> entrada: ti.entrySet()){
                key = entrada.getKey();
                cercanas = entrada.getValue();
                dm = distanciaManhattan(w.getCoor().getColumna(), w.getCoor().getFila(), key.getCoor().getColumna(), key.getCoor().getFila());
                if(dm <= dn){
                    if(!cercanas.contains(w)){
                        cercanas.add(w);
                    }
                    if(!insertar.contains(key)){
                        insertar.add(key);
                    }
                }
            }
            ti.put(w, insertar);
        }
    }

    public void insertaLocalidades(Coleccion c){
        Localidad2 localidad = null;
        if(c != null){
            for(int x = 0; x < c.getLocalidades().size(); x++){
                localidad = new Localidad2(c.getLocalidades().get(x));
                insertaLocalidad2(localidad);
            }
        }
    }
    //Weno pos a medias
    public boolean borraLocalidad(String p){
        boolean devolver = false;
        Localidad2 key = null;
        TreeSet<Localidad2> cercanas = new TreeSet<Localidad2>(); //Value
		TreeSet<Localidad2> borrar = new TreeSet<Localidad2>();
		TreeSet<Localidad2> borrar2 = new TreeSet<Localidad2>();
		for (Map.Entry<Localidad2, TreeSet<Localidad2>> entrada : ti.entrySet()) {
	        key = entrada.getKey();
	        if(p.equals(key.getNombre())){
	        	borrar.add(key);
	        	for (Map.Entry<Localidad2, TreeSet<Localidad2>> entrada2 : ti.entrySet()) {
	        		cercanas = entrada2.getValue();
		        	for(Localidad2 loc: cercanas){
		        		if(p.equals(loc.getNombre())){
		        			borrar2.add(loc);
		        		}
		        	}
		        	Iterator<Localidad2> it2 = borrar2.iterator();
					while(it2.hasNext()) {
						cercanas.remove(it2.next());
					}
	        	}
	        	devolver = true;
	        }
	        
	   	}
		Iterator<Localidad2> it = borrar.iterator();
		while(it.hasNext()){
			ti.remove(it.next());
		}
		return devolver;
    }

    public TreeSet<Localidad2> getLocalidades(String s){
        TreeSet<Localidad2> devolver = null;
        boolean encontrado = false;
        for (Map.Entry<Localidad2, TreeSet<Localidad2>> entry : ti.entrySet()) {
            if(s.equals(entry.getKey().getNombre()) && !encontrado) {
                devolver = entry.getValue();
                encontrado = true;
            }
       }
        return devolver;
    }
    
    public void setDn(int i){
        Localidad2 key = null;
        Localidad2 key2 = null;
        TreeSet<Localidad2> cercanas = new TreeSet<Localidad2>();
        TreeSet<Localidad2> cercanas2 = new TreeSet<Localidad2>();
        int dm;
        if(i>0){
            dn = i;
            for(Map.Entry<Localidad2, TreeSet<Localidad2>> entry : ti.entrySet() ) {
                key = entry.getKey();
                cercanas = entry.getValue();
                for(Map.Entry<Localidad2, TreeSet<Localidad2>> entry2 : ti.entrySet() ) {
                    key2 = entry2.getKey();
                    cercanas2= entry2.getValue();
                    dm = distanciaManhattan(key.getCoor().getColumna(), key.getCoor().getFila(), key2.getCoor().getColumna(), key2.getCoor().getFila());
                    if(dm <= dn) {
                        if(!cercanas.contains(key2) && !key2.equals(key)) {
                            cercanas.add(key2);
                        }
                    }else{
                        if(cercanas.contains(key2)){
                            cercanas.remove(key2);
                        }
                    }
                }
           }
        }
    }
    public int contador(String s) {
		int estrellas = 0;
		for( int x = 0; x < s.length(); x++ ) {
			if(s.charAt(x) == '*'){
				estrellas++;
			}
		}
		return estrellas;
    }
    
    public TreeSet<Localidad2> getTop( int i){
        TreeSet<Localidad2> devolver = null;
        Localidad2 key = null;
        
		if(i == 0) {
            devolver = new TreeSet<Localidad2>();
			for (Map.Entry<Localidad2, TreeSet<Localidad2>> entry : ti.entrySet()) {
				 key = entry.getKey();
				 if( key.getInfo().getTop() == "") {
					devolver.add(key);
				 }
			}
		}else if(i > 0 && i <= 3) {
            devolver = new TreeSet<Localidad2>();
            for(Map.Entry<Localidad2, TreeSet<Localidad2>> entry : ti.entrySet()){
                key = entry.getKey();
                if(contador(key.getInfo().getTop()) == i) {
                    devolver.add(key);
                }
            }
		}
        return devolver;
    }

    public String toString(){
		String devolver = "";
        Iterator<Localidad2> it;
        if(!esVacio()){
            for(final Map.Entry<Localidad2, TreeSet<Localidad2>> entry : ti.entrySet()){
                devolver = devolver + entry.getKey().getNombre() + " * ";
                it = entry.getValue().iterator();
                if(!it.hasNext())
                    devolver = devolver + "\n";
                while(it.hasNext()){
                    devolver = devolver + it.next().getNombre();
                    if(it.hasNext()){
                        devolver = devolver + " - ";
                    }else{
                        devolver = devolver + "\n";
                    }
                }
            }
        }
		return devolver;
	}


}