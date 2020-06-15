/**
* @author Alicia Garrido
* Se crea un GrafLoc y se invoca su metodo insertaArista con distintos valores.
* Se muestra por pantalla el resultado de cada accion y el grafo creado
*/

public class p04{
  public static void main(String[] args){
    GrafLoc groot=new GrafLoc(8);
    int peso=1;
    boolean inserta=false;
    for(int i=1;i<9;i+=2){
      for(int j=0;j<9;j+=2){
        if(i!=j){
          inserta=groot.insertaArista(i,j,peso);
          System.out.println("insertada arista ("+i+","+j+")="+peso+" -> "+inserta);
          if(inserta)
            peso++;
        }
      }
    }
    System.out.print(groot);
    peso=1;
    for(int i=-1;i<9/2;i+=2){
      for(int j=0;j<9;j++){
        if(i!=j){
          inserta=groot.insertaArista(i,j,peso);
          System.out.println("insertada arista ("+i+","+j+")="+peso+" -> "+inserta);
          if(inserta)
            peso++;
        }
      }
    }
    System.out.print(groot);
  }
}
