package objetos;
/**
 * Clase que representa un objeto que puede ser comido por Pacman y ser convertido en puntaje para si mismo.
 * @author mori
 *
 */
public abstract class Comida {
	/**
	 * Variable de instancia que indica el puntaje que este objeto otorgara al ser comido por pacman
	 */
	protected int puntaje;

	/**
	 * Devuelve el valor en puntos de este objeto.
	 * @return
	 * 		int: Puntaje.
	 */
	public int getPuntaje() {
		return puntaje;
	}
	
	/**
	 * Hace que este objeto sea comido por Pacman, seteando su puntaje a 0.
	 * @return
	 * 		int: puntaje que pacman ganara al comer este objeto
	 */
	public int comer() {
		int puntos = this.puntaje;
		this.puntaje = 0;
		return puntos;
	}
	

}
