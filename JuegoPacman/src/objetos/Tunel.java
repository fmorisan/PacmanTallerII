package objetos;

import path.Position;
/**
 * Clase que representa un tunel o atajo que Pacman puede tomar en el mapa.
 * @author mori
 *
 */
public class Tunel {
	/**
	 * Posicion de salida del tunel, a donde ira Pacman al atravesar el mismo.
	 */
	private Position posicionSalida;

	/**
	 * Constructor
	 * @param posicionSalida
	 * 		Especifica a donde ira el tunel
	 */
	public Tunel(Position posicionSalida) {
		super();
		this.posicionSalida = posicionSalida;
	}
	
	/**
	 * Devuelve la posicion de salida del tunel. 
	 * @return
	 * 		Position: Posicion de salida del tunel.
	 */
	public Position getPosicionSalida() {
		return posicionSalida;
	}
	
	

}
