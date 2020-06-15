//DAVID MARTINEZ GARCIA

import java.util.*;
import java.io.*;


public class MainGrafoDavid{
	public static void separador(){
	System.out.println("\n---------------------------------------------\n");
}
	public static void main(String []args){
		Coleccion c = new Coleccion();
		c.lectura(args[0]);
		GrafLoc grafo = new GrafLoc(10);
		System.out.println("Es vacio el grafo? :"+grafo.esVacio());
		System.out.println("Vamos a insertar bastantes aristas fieras");

		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(1,5,10));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(2,3,8));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(2,3,8));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(5,4,10));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(2,9,30));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(9,3,5));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(5,8,8));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(3,4,7));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(2,3,24));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(1,9,22));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(2,5,11));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(6,3,15));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(8,5,12));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(9,5,2));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(1,3,1));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(1,7,3));
		System.out.println("Se ha insertado esta arista? :"+grafo.insertaArista(4,9,4));
		separador();
		System.out.println("Imprimimos la matriz\n");
		System.out.println(grafo.toString());
		System.out.println("Y su recorrido desde 4");
		grafo.escribeDFS(4);

		separador();
		System.out.println("Vamos a probar a recuperar algunas aristas\n");
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(1,5));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(2,4));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(2,9));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(5,8));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(1,5));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(9,9));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(1,5));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(6,3));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(3,1));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(5,9));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(1,5));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(1,7));
		System.out.println("Peso de arista recuperada: "+grafo.recuperaArista(5,5));
		separador();
		System.out.println("Vamos a probar a borrar algunas aristas\n");
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(3,4));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,3));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,3));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(1,9));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,5));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(6,3));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,3));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(8,5));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(9,5));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(1,3));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,5));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(1,7));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(4,9));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(2,5));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(3,2));
		System.out.println("Se ha borrado esta arista? :"+grafo.borraArista(5,2));
		separador();
		System.out.println("Imprimimos la matriz\n");
		System.out.println(grafo.toString());
		System.out.println("Y su recorrido desde 1");
		grafo.escribeDFS(1);
		separador();
		System.out.println("Vamos a borrar todos los vertices que son: "+grafo.getVertices());
		for(int i=0;i<grafo.getVertices();i++){
			System.out.println("Se ha borrado el vertice "+i+": "+grafo.borraVertice(i));
		}
		separador();
		System.out.println("Imprimimos la matriz\n");
		System.out.println(grafo.toString());
		System.out.println("Y su recorrido desde 3");
		grafo.escribeDFS(3);
		separador();
		System.out.println("Vamos a crear un TreeSet y recorrerlo para comprobar insertaLocalidad y ademas mostraremos la matriz");
		TreeSet<Localidad2> treeSet = new TreeSet<Localidad2>();
		treeSet = grafo.insertaLocalidades(c);
		System.out.println("Vamos a imprimir el grafo primero\n");
		System.out.println(grafo.toString()+"\n");
		Iterator<Localidad2> it = treeSet.iterator();
		while(it.hasNext()){
			Localidad2 aux = it.next();
			System.out.println(aux);
		}
		separador();
		System.out.println("Imprimimos la matriz\n");
		System.out.println(grafo.toString());
		System.out.println("Y su recorrido desde 7");
		grafo.escribeDFS(7);
		System.out.println("\nY su recorrido desde 2");
		grafo.escribeDFS(2);

	}	

}