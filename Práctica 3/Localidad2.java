//DNI 23900715N HERNANDEZ GOMEZ, JESSICA
//import java.util.*;
public class Localidad2 extends Localidad implements Comparable<Localidad2> {

	private int vertice;
	
	public Localidad2(Localidad l){
		super(l.getNombre());
		this.setCoordenada(l.getCoor());
		this.setInfo(l.getInfo());
		this.setId(l.getId());
		vertice = -1;
	}
	
	public int getVertice(){
		return vertice;
	}
	
	public void setVertice(int i){
		vertice = i;
	}
	
	public int compareTo(Localidad2 c) {
		int devolver = -1;
		if(c != null){
			if(this.getNombre().compareTo(c.getNombre()) < 0){
				devolver = -1;
			}
			if(this.getNombre().compareTo(c.getNombre()) > 0){
				devolver = 1;
			}
			if(this.getNombre().compareTo(c.getNombre()) == 0){
				if(this.getId() < c.getId()){
					devolver = -1;
				}
				if(this.getId() > c.getId()){
					devolver = 1;
				}
				if(this.getId() == c.getId()){
					devolver = 0;
				}
			}
		}
		return devolver;
	}
	
	public boolean equals(Object m){
		boolean devolver = false;
		
		if(m instanceof Localidad2){
			if(this.getNombre().equals(((Localidad2)m).getNombre())){
				if(this.getId() == ((Localidad2)m).getId()){
					devolver = true;
				}
			}
		}
		return devolver;
	}

}
