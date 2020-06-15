/**
* @author Alicia Garrido
* Se crean distintas localidades y su correspondiente Localidad2, y se comparan entre ellas.
* Se muestra por pantalla el resultado de cada accion
*/
import java.util.*;

public class p01{
  private static ArrayList<ArrayList<Character>> creaMapa(){
    ArrayList<ArrayList<Character>> mapa=new ArrayList<>();
    for(int i=0;i<10;i++){
      mapa.add(new ArrayList<Character>());
      for(int j=0;j<10;j++){
       mapa.get(i).add('T'); 
      }
    }
    return mapa;
  }
  private static ArrayList<Localidad> creaLocas(){
    ArrayList<ArrayList<Character>> mapa=p01.creaMapa();
    ArrayList<ArrayList<Character>> m=p01.creaMapa();
    ArrayList<Localidad> locas=new ArrayList<>();
    int pf=0,pc=0,f=0,c=0;
    String[] names={"Espera","Peligros","Tocina","Casares","Marchena","La Mojonera","Setenil de las Bodegas",
                    "Pampaneira","Carmona","Estepona","La Iruela","Lucainena de las Torres","Marchena","Grazalema",
                    "Frigiliana","Zuheros","Torrox","Olvera","Constantina","Estepona"};
    for(int i=0;i<names.length;i++){
      Localidad nea=new Localidad(names[i]);
      locas.add(nea);
      if(i+10<names.length&&names[i]==names[i+10]){
        pf=i;pc=i-1;
      }
      if(i-10>=0&&names[i]==names[i-10]){
        nea.setCoor(pf,pc,m);
      }
      else {
       if(i+1<mapa.size())
        nea.setCoor(i,i+1,mapa);
       else if (i+1==mapa.size()){
        nea.setCoor(i,i-1,mapa);
        f=0;c=mapa.size()-2;
       }
       else{
        nea.setCoor(f,c,mapa);
        f++;c--;
       }
      }
    }
    return locas;                 
  }
  
  private static ArrayList<Localidad2> creaLocados(ArrayList<Localidad> l){
    ArrayList<Localidad2> l2=new ArrayList<>();
    for(int i=0;i<l.size();i++){
      l2.add(new Localidad2(l.get(i)));
      l2.get(i).setVertice(l2.size()+i);
    }
    return l2;
  }
  public static void main(String[] args){
    ArrayList<Localidad> locas=p01.creaLocas();
    ArrayList<Localidad2> alocados=p01.creaLocados(locas);
    System.out.println("Localidades creadas:");
    for(int i=0;i<alocados.size();i++)
      System.out.print(alocados.get(i));
    for(int i=0;i<alocados.size();i++){
     Localidad2 city=alocados.get(i);
     for(int j=0;j<alocados.size();j++){
       if(city.compareTo(alocados.get(j))<0)
         System.out.println(city.getNombre()+" es anterior a "+alocados.get(j).getNombre());
       else if(city.compareTo(alocados.get(j))>0)
         System.out.println(city.getNombre()+" es posterior a "+alocados.get(j).getNombre());
       else System.out.println(city.getNombre()+" es igual a "+alocados.get(j).getNombre());
     }
    }
  }
}
