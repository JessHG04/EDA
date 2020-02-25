/**
* @author: Alicia Garrido
* Crea una Coleccion que lee el fichero con la informacion para un mapa y
* una localidad, que tiene como posicion en el mapa el mar, de manera que 
* debe ser desestimada. Se muestra el objeto Coleccion por pantalla
*/
public class p02{
  public static void main(String[] args){
    Coleccion coli=new Coleccion();
    if(args.length==1){
       coli.lectura(args[0]);
       System.out.print(coli);
    }
    else
     System.out.println("Forma de uso: java p02 p02.dat");
  }
}