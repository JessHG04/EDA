/**
* @author Alicia Garrido
* Se crea una Coleccion, se invoca su metodo lectura. Se crea un GrafLoc y se invoca su metodo 
* insertaLocalidades con la coleccion. Se muestra el grafo por pantalla
*/

public class p02{
  public static void main(String[] args){
    Coleccion col=new Coleccion();
    GrafLoc grafo=new GrafLoc(2);
    if(args.length==1)
      col.lectura(args[0]);
    grafo.insertaLocalidades(col);
    System.out.print(grafo);
  }
}