package estructuras;
import path.Position;

public enum Direccion {
	
	// NORTE - SUR - OESTE - ESTE 
	ARRIBA(new Position(0, 1)),
	ABAJO(new Position(0, -1)),
	DERECHA(new Position(1, 0)),
	IZQUIERDA(new Position(-1, 0)),
	QUIETO(new Position(0, 0));
	
	private Position vector;
	 
	private Direccion(Position vector) {
		this.vector = vector;
	}

	public Position getVector() {
		return vector;
	}
	
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
