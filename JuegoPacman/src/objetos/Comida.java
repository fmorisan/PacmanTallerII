package objetos;

public abstract class Comida {
	protected int puntaje;

	public int getPuntaje() {
		return puntaje;
	}
	
	public int comer() {
		int puntos = this.puntaje;
		this.puntaje = 0;
		return puntos;
	}
	

}
