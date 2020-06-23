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
        boolean vacio = false;
        
        if(w!= null && !ti.containsKey(w) ){
            //Anyadimos la localidad
            vacio = esVacio();
            ti.put(w, insertar);
            //Comprobamos si hay que incluirla en el TreeMap
            if(!vacio){

            }
        }
    }

    public void insertaLocalidades(Coleccion c){

    }

    public boolean borraLocalidad(String p){
        boolean devolver = false;



        return devolver;
    }

    public TreeSet<Localidad2> getLocalidades(String s){
        TreeSet<Localidad2> devolver = null;
        /*Iterator<Localidad2> it = ti.iterator();
        boolean encontrado = false;
        Localidad2 loca = null;
        if(s!= null)){
            while(it.hasNext() && !encontrado){
                loca = it.next();
                if(loca.getNombre().equalsIgnoreCase(s)){
                    encontrado = true;
                }
                devolver = ti.get(it);
            }
        }*/
        if(s!= null){
            Localidad loc = new Localidad(s);
            Localidad2 locc = new Localidad2(loc);
            if(ti.containsKey(locc)){
                devolver = ti.get(locc);
            }
        }
        return devolver;
    }

    public void setDn(int i){

    }

    public TreeSet<Localidad2> getTop(int i){
        TreeSet<Localidad2> devolver = null;

        return devolver;
    }

    public String toString(){
        String devolver = "";
        Set<Localidad2> principal = ti.keySet();
        TreeSet<Localidad2> cercanas;
        boolean primero = true;

        for(int x = 0; x < principal.size(); x++){
            Object[] parray = principal.toArray();
            String l = (Localidad2)parray[x].getNombre();
            primero = true;
            cercanas = ti.get((Localidad2)parray[x]);
            devolver += l + " * ";

        }
        return devolver;
    }


}
