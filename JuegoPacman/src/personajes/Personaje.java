package personajes;

import estructuras.Direccion;
import path.Position;

public abstract class Personaje {
	
	protected Direccion direccion;
	// sirve como posicion inicial? podemos asignarle una en el constructor
	private Position pos; 
	
	
	protected Personaje(Position posInicial){
		this.pos = posInicial;
	}
	public Position getPosicion(){
		return this.pos;
	}
	
	public Position getSiguientePosicion(){
		//TODO agregar una forma de convertir direcciones a vectores Position para poder sumar
		return Position.add(this.pos, this.direccion.getVector());
	}
	
	public void actualizarPosicion(){
		this.pos = Position.add(this.pos, this.direccion.getVector());
	}
	
}
