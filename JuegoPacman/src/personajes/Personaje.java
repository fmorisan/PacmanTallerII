package personajes;

import estructuras.Direccion;
import path.Position;

/**
 * Clase base de todos los personajes
 * @author mori
 *
 */
public abstract class Personaje {
	/**
	 * Direccion actual del personaje
	 */
	private Direccion direccion = Direccion.QUIETO;
	/**
	 * Posicion actual del personaje
	 */
	private Position pos; 
	
	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial del personaje
	 */
	protected Personaje(Position posInicial){
		this.pos = posInicial;
	}
	/**
	 * Metodo que retorna la posicion actual del personaje
	 * @return
	 * 		Position : posicion actual
	 */
	public Position getPosicion(){
		return this.pos;
	}
	
	/**
	 * Cambia la direccion del personaje
	 * @param dir
	 * 		Direccion nueva
	 */
	protected void setDireccion(Direccion dir){
		this.direccion = dir;
	}
	
	/**
	 * Retorna la siguiente posicion del personaje basado en su posicion actual y su direccion.
	 * @return
	 * 		Position: Posicion siguiente
	 */
	public Position getSiguientePosicion(){
		//TODO agregar una forma de convertir direcciones a vectores Position para poder sumar
		return Position.add(this.pos, this.direccion.getVector());
	}
	
	/**
	 * Actualiza la posicion del personaje a la retornada por {@link getSiguientePosicion()} 
	 */
	public void actualizarPosicion(){
		this.pos = getSiguientePosicion();
	}
	
}
