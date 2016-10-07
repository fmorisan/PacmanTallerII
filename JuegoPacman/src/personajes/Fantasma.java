package personajes;

import path.Path.Step;
import path.PathFinder;
import path.Position;
import estructuras.Direccion;
import estructuras.Modo;

public abstract class Fantasma extends Personaje {

	 private Modo modo = Modo.PERSECUCION;
	 
	 protected Position esquinaDesignada;
	 protected Position esquinaAsustado;

	 //private boolean inHome;
	 //private boolean exitingHome;
	 //private boolean enteringHome;
	 
	 protected Fantasma(Position posInicial){
		 super(posInicial);
	 }
	/*
	 * Modifica la direccion del Fantasma debido a su estrategia
	 */
	public void estrategia(Position posicionPacman){
		switch (this.modo){
		case PERSECUCION:
			estrategiaPersecucion(posicionPacman);
		case ASUSTADO:
			estrategiaAsustado(posicionPacman);
		case DISPERSION:
			estrategiaDispersion();
		}
	}
	
	public void setModo(Modo modo){
		if (modo == Modo.ASUSTADO){
			//TODO cambiar por un valor aleatorio
			this.esquinaAsustado = new Position(0, 0);
		} else {
			this.esquinaAsustado = null;
		}
		this.modo = modo;
	}
	
	public abstract void estrategiaPersecucion(Position posicionPacman);
	
	public void estrategiaDispersion(){
		Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaDesignada.getX(), this.esquinaDesignada.getY()).getStep(0);
		int dx, dy;
		dx = siguientePaso.getX() - this.getPosicion().getX();
		dy = siguientePaso.getY() - this.getPosicion().getY();
		
		this.setDireccion(Direccion.fromVector(new Position(dx, dy)));
	}
	
	public void estrategiaAsustado(Position poscicionPacman) {
		// TODO Auto-generated method stub
		Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaAsustado.getX(), this.esquinaAsustado.getY()).getStep(0);
		this.setDireccion(Direccion.fromVector(new Position(siguientePaso.getX() - this.getPosicion().getX(), siguientePaso.getY() - this.getPosicion().getY())));
	}
}
