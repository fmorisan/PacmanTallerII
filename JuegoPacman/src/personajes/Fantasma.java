package personajes;

import path.Path.Step;

import path.PathFinder;
import path.Position;
import estructuras.Direccion;
import estructuras.Modo;

/**
 * Clase base de todos los fantasmas 
 * @author mori
 *
 */
public abstract class Fantasma extends Personaje {
	/**
	 * Modo actual del fantasma
	 */
	 private Modo modo = Modo.PERSECUCION;
	 
	 public Modo getModo() {
		return modo;
	}

	public abstract String getName();
	/**
	 * Variables de instancia 
	 */
	 protected Position esquinaDesignada;
	 protected Position esquinaAsustado;

	 //private boolean inHome;
	 //private boolean exitingHome;
	 //private boolean enteringHome;
	 
	 /**
	  * Metodo constructor
	  * @param posInicial
	  * 	Posicion inicial del fantasma.
	  */
	 protected Fantasma(Position posInicial){
		 super(posInicial);
	 }
	 
	/**
	 * Modifica la direccion del Fantasma debido a su estrategia
	 * 
	 * @param posicionPacman
	 * 		Posicion actual de Pacman para calcular la estrategia correspondiente
	 */
	public void estrategia(Position posicionPacman){
		switch (this.modo){
		case PERSECUCION:
			estrategiaPersecucion(posicionPacman);
		case ASUSTADO:
			estrategiaAsustado();
		case DISPERSION:
			estrategiaDispersion();
		}
	}
	
	
	/**
	 * Cambia el modo del fantasma al modo especificado
	 * 
	 * @param modo
	 * 		Modo al que se quiere cambiar.
	 */
	public void setModo(Modo modo){
		if (modo == Modo.ASUSTADO){
			//TODO cambiar por un valor aleatorio
			this.esquinaAsustado = new Position(0, 0);
		} else {
			this.esquinaAsustado = null;
		}
		this.modo = modo;
	}
	
	/**
	 * Metodo que implementa la estrategia del fantasma cuando el modo es Persecucion
	 * 
	 * @param posicionPacman
	 * 		Posicion actual de Pacman para poder calcular la estrategia 
	 */
	public abstract void estrategiaPersecucion(Position posicionPacman);
	
	/**
	 * Metodo que implementa la estrategia del fantasma en modo Dispersion
	 * Como no depende de la posicion de Pacman, no la recibe como parametro.
	 * 
	 */
	public void estrategiaDispersion(){
		Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaDesignada.getX(), this.esquinaDesignada.getY()).getStep(0);
		int dx, dy;
		dx = siguientePaso.getX() - this.getPosicion().getX();
		dy = siguientePaso.getY() - this.getPosicion().getY();
		
		this.setDireccion(Direccion.fromVector(new Position(dx, dy)));
	}
	 /**
	  * Metodo que implementa la estrategia del fantasma en modo Asustado
	  * 
	  */
	public void estrategiaAsustado() {
		if (this.esquinaAsustado != null){
			Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaAsustado.getX(), this.esquinaAsustado.getY()).getStep(0);
			this.setDireccion(Direccion.fromVector(new Position(siguientePaso.getX() - this.getPosicion().getX(), siguientePaso.getY() - this.getPosicion().getY())));
		}
	}
}
