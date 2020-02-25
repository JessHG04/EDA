/**
* @author Alicia Garrido
* Se crea una Coleccion, se invoca su metodo lectura. Se crea un TNear y se invoca su metodo 
* insertaLocalidades con la coleccion. Se muestra el arbol por pantalla
*/

public class p03{
  public static void main(String[] args){
    Coleccion col=new Coleccion();
    TNear arbol=new TNear(10);
    if(args.length==1)
      col.lectura(args[0]);
    arbol.insertaLocalidades(col);
    System.out.print(arbol);
  }
}