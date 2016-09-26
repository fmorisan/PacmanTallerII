package estructuras;

public enum Direccion {
	
	// NORTE - SUR - OESTE - ESTE 
	ARRIBA(1),	ABAJO(2),	DERECHA(3),  	IZQUIERDA(4);
	
	private int direccion;
	
	Direccion(int i){
		this.direccion = i;
	}

	public int getDireccion() {
		return direccion;
	}
	
}
