//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
import java.util.*;

public class GrafLoc {
    private ArrayList<ArrayList<Integer>> gr;

    public GrafLoc(int n){
        gr = new ArrayList<ArrayList<Integer>>();

        for(int x = 0; x<n; x++){
            gr.add(new ArrayList<Integer>());
            for(int y = 0; y < n; y++){
                gr.get(x).add(Integer.MAX_VALUE);
            }
        }
    }

    public boolean esVacio(){
        boolean devolver = true;
        
        if(gr != null){
            for(int x = 0; x < gr.size(); x++){
                for(int y = 0; y < gr.get(x).size(); y++){
                    if(gr.get(x).get(y) != Integer.MAX_VALUE){
                        devolver = false;
                    }
                }
            }
        }
        return devolver;
    }

    public boolean insertaArista(int o1, int o2, int p){
        boolean devolver = false;

        if(gr != null){
            if(o1 >= 0 && o1 < gr.size()){
                if(o2 >= 0 && o2 < gr.get(0).size()){
                    if(gr.get(o1).get(o2) != null){
                        if(gr.get(o1).get(o2) != p){
                            gr.get(o1).set(o2, p);
                            devolver = true;
                        }
                    }
                }
            }
        }
        return devolver;
    }

    public int recuperaArista(int o1, int o2){
        int devolver = -1;

        if(gr != null){
            if(gr.get(o1).get(o2) != null){
                if(gr.get(o1).get(o2) != Integer.MAX_VALUE){
                    devolver = gr.get(o1).get(o2);
                }
            }
        }
        return devolver;
    }

    public boolean borraArista(int o1, int o2){
        boolean devolver = false;

        if(gr != null){
            if(gr.get(o1).get(o2) != null){
                if(gr.get(o1).get(o2) != Integer.MAX_VALUE){
                    gr.get(o1).set(o2, Integer.MAX_VALUE);
                    devolver = true;
                }
            }
        }

        return devolver;
    }

    public boolean borraVertice(int o1){
        boolean devolver = false;

        if(gr!=null){
            if(gr.get(o1) != null){
                //Borramos la fila
                for(int x = 0; x<o1; x++){
                    if(gr.get(o1).get(x)!= Integer.MAX_VALUE){
                        gr.get(o1).set(x, Integer.MAX_VALUE);
                        devolver = true;
                    }
                }
            }

            if(gr.get(0).get(o1)!= null){
                //Borramos la columna
                for(int y = 0; y<o1; y++){
                    if(gr.get(y).get(o1)!= Integer.MAX_VALUE){
                        gr.get(y).set(o1, Integer.MAX_VALUE);
                        devolver = true;
                    }
                }
            }
        }
        return devolver;
    }

    public int getVertices(){
        int vertices = 0;

        if(gr!=null){
            vertices = gr.size();
        }

        return vertices;
    }

    public int getAristas(){
        int aristas = 0;

        if(gr != null){
            for(int x = 0; x<gr.size(); x++){
                for(int y = 0; y < gr.get(x).size(); y++){
                    if(gr.get(x).get(y) != Integer.MAX_VALUE && x > y){
                        aristas++;
                    }
                }
            }
        }

        return aristas;
    }

    public TreeSet<Localidad2> insertaLocalidades(Coleccion c){
        TreeSet<Localidad2> devolver = new TreeSet<Localidad2>();
        Localidad2 insertar = null;
        Localidad2 loc = null;
        Localidad2 loca = null;
        int indice = 0;
        int dm = 0;
        
        //Vaciamos el grafo
        if(gr != null){
            if(gr.get(0).get(0) != null){
                for(int x = 0; x < gr.size(); x++){
                    for( int y = 0; y < gr.get(x).size(); y++){
                        gr.get(x).set(y, Integer.MAX_VALUE);
                    }
                }
            }
        }
        //Insertamos localidades
        if(c != null){
            for (int x = 0; x < c.getLocalidades().size(); x++){
                insertar = new Localidad2 (c.getLocalidades().get(x));
                devolver.add(insertar);
            }
        }
        //Asignamos vértices
        Iterator <Localidad2> it = devolver.iterator();
        while(it.hasNext()){
            it.next().setVertice(indice);
            indice++; 
        }
        //Obtenermos la matriz
        it = devolver.iterator();
        Iterator <Localidad2> ite = null;
        gr=new ArrayList<ArrayList<Integer>>();
        while (it.hasNext()){
            loc = it.next();
            ite = devolver.iterator();
            ArrayList<Integer> fila=new ArrayList<>();
            while(ite.hasNext()){
                loca = ite.next();
                dm = distanciaManhattan(loc.getCoor().getColumna(), loc.getCoor().getFila(), loca.getCoor().getColumna(), loca.getCoor().getFila());
                fila.add(dm);
            }
            gr.add(fila);
        }
        return devolver;
    }

    public int distanciaManhattan(int x1, int x2, int y1, int y2){
        int distancia = 0;

        distancia = Math.abs(x1 - y1) + Math.abs(x2 - y2);

        return distancia;
    }

    public String toString(){
        String devolver = "vertices: " + getVertices() + "\n" + "aristas: " + getAristas() + "\n";

        if(gr!= null){
            for(int x = 0; x < gr.size(); x++){
                for(int y = 0; y < gr.get(x).size(); y++){
                    devolver = devolver + gr.get(x).get(y) + " ";
                }
                devolver = devolver + "\n";
            }
            
        }
        return devolver;
    }

    public void escribeDFS(int i){

    }

}
