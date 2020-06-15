//23900715N HERNANDEZ GOMEZ, JESSICA
import java.util.*;

public class InfoTur {
	private int museo;
	private int monumento;
	private int hotel;
	private int restaurante;
	private boolean aeropuerto;
	private String top;

	public InfoTur() {
		museo = 0;
		monumento = 0;
		hotel = 0;
		restaurante = 0;
		aeropuerto = false;
		top = "";
	}

	public InfoTur(int mu, int mo, int ho, int r, boolean ae) {
		if (mu > 0) {
			museo = mu;
		} else {
			museo = 0;
		}
		if (mo > 0) {
			monumento = mo;
		} else {
			monumento = 0;
		}
		if (ho > 0) {
			hotel = ho;
		} else {
			hotel = 0;
		}
		if (r > 0) {
			restaurante = r;
		} else {
			restaurante = 0;
		}
		aeropuerto = ae;
		top = "";
	}
	
	public ArrayList<Integer> getInfoTur(){
		ArrayList<Integer> devolver = new ArrayList<Integer>();
		int aero;
		
		if(!aeropuerto){
	        aero = 0;
	    }else{
	        aero = 1;
	    }

	    devolver.add(museo);
	    devolver.add(monumento);
	    devolver.add(hotel);
	    devolver.add(restaurante);
	    devolver.add(aero);
	    
	    return devolver;
	}
	
	public String getMasFrecuente(){
		String devolver;
	    int mas;
	    int aero;

	    if(!aeropuerto){
	        aero = 0;
	    }else{
	        aero = 1;
	    }

	    mas = aero;
	    devolver = "aeropuerto";

	    if(hotel > mas){
	        mas = hotel;
	        devolver = "hotel";
	    }
	    if(monumento > mas){
	        mas = monumento;
	        devolver = "monumento";
	    }
	    if(museo > mas){
	        mas = museo;
	        devolver = "museo";
	    }
	    if(restaurante > mas){
	        mas = restaurante;
	        devolver = "restaurante";
	    }
	    return devolver;
	}

	public int getMuseo() {
		return museo;
	}

	public void setMuseo(int museo) {
		this.museo = museo;
	}

	public int getMonumento() {
		return monumento;
	}

	public void setMonumento(int monumento) {
		this.monumento = monumento;
	}

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public int getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(int restaurante) {
		this.restaurante = restaurante;
	}

	public boolean isAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(boolean aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}
	
	public String toString(){
		int aero = 0;
		
		if(aeropuerto){
			aero = 1;
		}
				
		String cadena = museo + " " + monumento + " " + hotel + " " + restaurante + " " + aero + " " + top + "\n";
		return cadena;
	}
}
