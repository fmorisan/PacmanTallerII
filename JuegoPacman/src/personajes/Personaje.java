package personajes;

import estructuras.Direccion;
import path.Position;

public abstract class Personaje {
	
	private Direccion direccion;
	// sirve como posicion inicial? podemos asignarle una en el constructor
	private Position pos; 
	
	public Position getPosicion(){
		return this.pos;
	}
	
	public Position getSiguientePosicion(){
		//TODO agregar una forma de convertir direcciones a vectores Position para poder sumar
		return this.pos + this.direccion; 
	}
	
	public void actualizarPosicion(){
		//TODO agregar una forma de convertir direcciones a vectores Position para poder sumar
		this.pos += this.direccion;
	}
	

	public abstract void crearPersonaje();
	
}
