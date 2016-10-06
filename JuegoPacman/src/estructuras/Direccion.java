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
	
	
}
