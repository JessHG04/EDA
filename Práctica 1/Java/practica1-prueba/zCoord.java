public class zCoord {
	public static void main(String [] args) {
		Coordenadas cor1 = new Coordenadas(3, 3);
		System.out.println(cor1.getFila() + " " + cor1.getColumna());
		
		Coordenadas cor2 = new Coordenadas(-1, 3);
		System.out.println(cor2.getFila() + " " + cor2.getColumna());
		
		Coordenadas cor3 = new Coordenadas(0, 3);
		System.out.println(cor3.getFila() + " " + cor3.getColumna());
		
	}
}
