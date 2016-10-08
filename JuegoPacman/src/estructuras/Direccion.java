package estructuras;
import path.Position;
/**
 * Enumerativo de direcciones
 * @author mori
 *
 */
public enum Direccion {
	
	ARRIBA(new Position(0, 1)),
	ABAJO(new Position(0, -1)),
	DERECHA(new Position(1, 0)),
	IZQUIERDA(new Position(-1, 0)),
	QUIETO(new Position(0, 0));
	
	/**
	 * Vector de movimiento que la direccion representa.
	 */
	private Position vector;
	 
	/**
	 * Constructor
	 * @param vector
	 * 		Vector de movimiento
	 */
	private Direccion(Position vector) {
		this.vector = vector;
	}

	/**
	 * Retorna el vector de movimiento representado por la instancia de Direccion
	 * @return
	 * 		<b>Position</b> Vector de movimiento
	 */
	public Position getVector() {
		return vector;
	}
	
	/**
	 * Permite convertir vectores de movimiento a direcciones.
	 * @param vector
	 * 		Vector que representa el movimiento.
	 * @return
	 * 		<b>Direccion</b> Instancia de direccion que representa este movimiento.
	 */
	public static Direccion fromVector(Position vector) {
		if (vector.getX() > 0){
			return Direccion.DERECHA;
		} else if (vector.getX() < 0) {
			return Direccion.IZQUIERDA;
		} else if (vector.getY() > 0) {
			return Direccion.ARRIBA;
		} else {
			return Direccion.ABAJO;
		}
	}
	
	
}
