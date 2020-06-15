//MARTINEZ GARCIA,DAVID
import java.util.*;
import java.io.*;

public class MainTNearDavid{
		public static void separador(){
	System.out.println("\n---------------------------------------------\n");
	}
	public static void imprimirTreeSet(TreeSet<Localidad2> treeSet){
		if(treeSet != null){
			Iterator<Localidad2> it = treeSet.iterator();
			while(it.hasNext()){
				Localidad2 aux = it.next();
				System.out.println(aux);
			}
		}else{
			System.out.println("NULL");
		}
	}
	public static void main(String []args){
		TNear arbolaco = new TNear(17);
		Coleccion c = new Coleccion();
		c.lectura(args[0]);
		ArrayList<ArrayList<Character>> mapa = c.getMapa();
		Localidad loc1 = new Localidad("Madrid");
		loc1.setCoor(3,10,mapa);
		loc1.getInfo().setTop("* La greta esta contenta");
		Localidad loc2 = new Localidad("Barcelona");
		loc2.setCoor(3,4,mapa);
		loc2.getInfo().setTop("** Ingenieria ddddd");
		Localidad loc3 = new Localidad("Malaga");
		loc3.setCoor(4,3,mapa);
		loc3.getInfo().setTop("*** Un poco hasta la polla");
		Localidad loc4 = new Localidad("Badajoz");
		loc4.setCoor(6,2,mapa);
		loc4.getInfo().setTop("* Se me ha borrado el commit");
		Localidad2 loc21= new Localidad2(loc1);
		Localidad2 loc22= new Localidad2(loc2);
		Localidad2 loc23= new Localidad2(loc3);
		Localidad2 loc24= new Localidad2(loc4);

		System.out.println("Vamos a crear el TNear");
		System.out.println("Es vacio? :"+arbolaco.esVacio());
		separador();
		System.out.println("Vamos a llamar al insertaLocalidades para que nos instroduzca todas las  de la Coleccion");
		arbolaco.insertaLocalidades(c);
		System.out.println("Y vamos a imprimirlo\n");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Es vacio? :"+arbolaco.esVacio());
		System.out.println("Vamos a probar ahora a insertar localidades random a ver si cuela y despues imprimimos el arbol");
		arbolaco.insertaLocalidad2(loc21);
		arbolaco.insertaLocalidad2(loc22);
		arbolaco.insertaLocalidad2(loc23);
		arbolaco.insertaLocalidad2(loc24);
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Vamos a obtener varios TreeSet con getLocalidades y a Imprimirlos");
		TreeSet<Localidad2> treeSet = new TreeSet<Localidad2>();
		treeSet = arbolaco.getLocalidades("Barcelona");
		System.out.println("Arbol Barcelona");
		imprimirTreeSet(treeSet);
		separador();
		treeSet = arbolaco.getLocalidades("Alcachofa");
		System.out.println("Arbol Alcachofa");
		imprimirTreeSet(treeSet);
		separador();
		treeSet = arbolaco.getLocalidades("Sasn5");
		System.out.println("Arbol Sans5");
		imprimirTreeSet(treeSet);
		separador();
		treeSet = arbolaco.getLocalidades("Badajoz");
		System.out.println("Arbol Badajoz");
		imprimirTreeSet(treeSet);
		separador();
		treeSet = arbolaco.getLocalidades("Sasn3");
		System.out.println("Arbol Sans3");
		imprimirTreeSet(treeSet);
		separador();

		System.out.println("Borraremos localidades ahora e imprimimos el Arbolaco");
		System.out.println("Borramos Alachofa? "+arbolaco.borraLocalidad("Alcachofa"));
		System.out.println("Borramos Alcachofa e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Sasn? "+arbolaco.borraLocalidad("Sasn"));
		System.out.println("Borramos Sasn e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Barcelona? "+arbolaco.borraLocalidad("Barcelona"));
		System.out.println("Borramos Barcelona e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Sasn5? "+arbolaco.borraLocalidad("Sasn5"));
		System.out.println("Borramos Sasn5 e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos cadenaVacia? "+arbolaco.borraLocalidad(""));
		System.out.println("Borramos cadenaVacia e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Sasn1? "+arbolaco.borraLocalidad("Sasn1"));
		System.out.println("Borramos Sasn1 e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Sasn3? "+arbolaco.borraLocalidad("Sasn3"));
		System.out.println("Borramos cadenaVacia e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Madrid? "+arbolaco.borraLocalidad("Madrid"));
		System.out.println("Borramos Madrid e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Borramos Malaga? "+arbolaco.borraLocalidad("Malaga"));
		System.out.println("Borramos cadenaVacia e imprimimos");
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Volvemos a meter todas con insertaLocalidades,y las auxiliares e imprimimos");
		arbolaco.insertaLocalidades(c);
		arbolaco.insertaLocalidad2(loc21);
		arbolaco.insertaLocalidad2(loc22);
		arbolaco.insertaLocalidad2(loc23);
		arbolaco.insertaLocalidad2(loc24);
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Vamos a coger UNOS CUANTOS TOP VENGA HOSTIA MENUDA MIERDA");
		TreeSet<Localidad2> auxTreeset = new TreeSet<Localidad2>();
		System.out.println("Top 5 estrellas");
		auxTreeset = arbolaco.getTop(5);
		System.out.println("Es auxTreeset null? "+auxTreeset+"\n");
		System.out.println("Top 0 estrellas");
		auxTreeset = arbolaco.getTop(0);
		imprimirTreeSet(auxTreeset);
		separador();
		System.out.println("Top 1 estrella");
		auxTreeset = arbolaco.getTop(1);
		imprimirTreeSet(auxTreeset);
		separador();
		System.out.println("Top 2 estrellas");
		auxTreeset = arbolaco.getTop(2);
		imprimirTreeSet(auxTreeset);
		separador();
		System.out.println("Top 3 estrellas");
		auxTreeset = arbolaco.getTop(3);
		imprimirTreeSet(auxTreeset);
		separador();
		System.out.println("Vale ahora vamos a cambiar los dn y que se vuelva to loco esto e imprimimos\n");
		System.out.println("Cambiamos a 30 dn\n");
		arbolaco.setDn(30);
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Cambiamos a 1 dn\n");
		arbolaco.setDn(1);
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Cambiamos a 5 dn\n");
		arbolaco.setDn(5);
		System.out.println(arbolaco.toString());
		separador();
		System.out.println("Cambiamos a 15 dn\n");
		arbolaco.setDn(15);
		System.out.println(arbolaco.toString());
		separador();

	}
}