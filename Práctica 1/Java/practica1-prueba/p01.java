/**
* @author: Alicia Garrido
* Crea una matriz de caracteres y dos localidades, de manera que una localidad se intenta situar
* en el mar y otra en tierra. Se muestra el resultado de cada accion y las localidades por pantalla
*/
import java.util.*;
public class p01{
  public static void main(String[] args){
    Localidad one=new Localidad("Pumpkiski");
    Localidad two=new Localidad("Kisimmee");
    ArrayList<ArrayList<Character>> mapa=new ArrayList<>();
    boolean mar=false;
    for(int i=0;i<3;i++){
      ArrayList<Character> l=new ArrayList<>();
      char tipo='T';
      if(mar)
        tipo='M';
      else mar=true;
      for(int j=0;j<7;j++)
           l.add(tipo);
      mapa.add(l);
    }
    System.out.println("Se situa "+one.getNombre()+" en (1,3)? -> "+one.setCoor(1,3,mapa));
    System.out.println("Se situa "+two.getNombre()+" en (0,5)? -> "+two.setCoor(0,5,mapa));
    System.out.println("Localidades y mapa finales:");
    System.out.println(one);
    System.out.println(two);
    System.out.println(mapa);
  }
}
