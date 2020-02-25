/**
* @author: Alicia Garrido
* Crea una Coleccion que lee el fichero con la informacion para un mapa y
* varias localidades que se situan. Se crea una localidad y se situa en el
* mismo mapa. Se muestra por pantalla el resultado de cada accion y los objetos
*/
import java.util.*;
public class p03{
  public static void main(String[] args){
    Coleccion col=new Coleccion();
    if(args.length==1){
      col.lectura(args[0]);
      ArrayList<Localidad> cities=col.getLocalidades();
      if(cities!=null){
          for(int i=0;i<cities.size();i++)
            if(cities.get(i)!=null)
              System.out.println("Ciudad "+cities.get(i).getNombre()+" con identificador "+cities.get(i).getId());
      }
      Localidad city=new Localidad("SinCity");
      int id=city.setCoor(3,5,col.getMapa());
      if(id!=-1)
         System.out.println("Ciudad "+city.getNombre()+" con identificador "+city.getId());
      else
         System.out.println("Ciudad "+city.getNombre()+" sin identificador "+city.getId());
      System.out.println("Estado de la coleccion y la localidad extra:");
      System.out.print(col);
      System.out.print(city);
    }
    else
     System.out.println("Forma de uso: java p03 p03.dat");
  }
}