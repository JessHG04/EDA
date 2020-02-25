import java.util.ArrayList;

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
	public InfoTur(int mu, int mo, int ho, int r, boolean ae){
		if(mu < 0){
			museo = 0;
		}
		else{
			museo = mu;
		}
		monumento = Math.max(0, mo);
		if(ho < 0){
			ho = 0;
		}
		hotel = ho;
		if(r > 0){
			restaurante = r;		
		}
		else{
			restaurante = 0;
		}
		aeropuerto = ae;
		top = "";
		
	}
	public ArrayList<Integer> getInfoTur(){
		ArrayList<Integer> todo = new ArrayList<Integer>();;
		todo.add(museo);
		todo.add(monumento);
		todo.add(hotel);
		todo.add(restaurante);
		if(aeropuerto){ 
			todo.add(1);
		}
		else{
			todo.add(0);
		}
		return todo;
	}
	
	public String getMasFrecuente(){
		ArrayList<Integer> datos = new ArrayList<Integer>();
		int posMayor, i;
		String resultado = null;
		datos.add(aeropuerto?1:0);
		datos.add(hotel);
		datos.add(monumento);
		datos.add(museo);
		datos.add(restaurante);


		posMayor = 0;
		for(i = 1; i < datos.size(); i++){
			if(datos.get(i) > datos.get(posMayor)){
				posMayor = i;	
			}
		}
		switch(posMayor){
			case 0:
				resultado = "aeropuerto";
				break;
			case 1:
				resultado = "hotel";
				break;
			case 2:
				resultado = "monumento";
				break;
			case 3:
				resultado = "museo";
				break;
			case 4:
				resultado = "restaurante";
				break;
		}
		return resultado;
	}
	
	public void setTop(String n){
		top = n;
	}

	public String getTop(){
		return top;
	}

	public String toString(){
		int cantidadAeropuerto;
		if(aeropuerto) {
			cantidadAeropuerto = 1;
		}
		else {
			cantidadAeropuerto = 0;
		}
		return museo + " " + monumento + " " + hotel + " " + restaurante + " "
				+ cantidadAeropuerto + " " + top + "\n";
	}
	
}
