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

    public void insertaLocalidad2(Localidad2 w){
        TreeSet<Localidad2> insertar = null;
        
        if(w!= null && ti.containsKey(w) == false){
            
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

        return devolver;
    }


}
