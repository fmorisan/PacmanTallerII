package personajes;

import path.Path;
import path.Path.Step;
import path.PathFinder;
import path.Position;
import estructuras.Direccion;
import estructuras.Modo;

public abstract class Fantasma extends Personaje {

	 private Modo modo = Modo.PERSECUCION;
	 
	 protected Position esquinaDesignada;

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
	
	public abstract void estrategiaPersecucion(Position posicionPacman);
	public abstract void estrategiaAsustado(Position poscicionPacman);
	public void estrategiaDispersion(){
		// TODO agregar logica para que los fantasmas vayan a su esquina designada
		// es igual para todos los fantasmas asi que vale dejarla implementada aca
		Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaDesignada.getX(), this.esquinaDesignada.getY()).getStep(0);
		int dx, dy;
		dx = siguientePaso.getX() - this.getPosicion().getX();
		dy = siguientePaso.getY() - this.getPosicion().getY();
		
		this.setDireccion(Direccion.fromVector(new Position(dx, dy)));
	}
}
