package personajes;

import estructuras.Direccion;
import path.Position;

public abstract class Personaje {
	
	private Direccion direccion;
	// sirve como posicion inicial? podemos asignarle una en el constructor
	private Position pos; 
	
	
	protected Personaje(Position posInicial){
		this.pos = posInicial;
	}
	public Position getPosicion(){
		return this.pos;
	}
	
	protected void setDireccion(Direccion dir){
		this.direccion = dir;
	}
	
	public Position getSiguientePosicion(){
		//TODO agregar una forma de convertir direcciones a vectores Position para poder sumar
		return Position.add(this.pos, this.direccion.getVector());
	}
	
	public void actualizarPosicion(){
		this.pos = Position.add(this.pos, this.direccion.getVector());
	}
	
}
