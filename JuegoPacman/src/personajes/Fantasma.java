package personajes;

import path.Path;
import path.Path.Step;

import path.PathFinder;
import path.Position;

import java.util.Random;

import config.Config;
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
	 protected Position esquinaDesignada = Config.BLINKY_CORNER;
	 protected Position esquinaAsustado;
	 
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
			break;
		case ASUSTADO:
			estrategiaAsustado();
			break;
		case DISPERSION:
			estrategiaDispersion();
			break;
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
			this.esquinaAsustado = posEsquinaAsustado();
		} else {
			this.esquinaAsustado = null;
		}
		this.modo = modo;
	}
	
	/**
	 * Método que calcula un valor random
	 * @param valor 
	 * 	@return value </br>
	 * 			Valor random de tipo entero.
	 * */
	private int nroRandom(int valor){
		Random md = new Random();
		int value = (int) (md.nextDouble() * valor + 0);
		return value;
	}
	
	/**
	 * Retorna una posicion aleatoria para la estrategia en modo asustado.
	 * @return posEsquinaAsustado </br>
	 * 			Posicion a la cual se dirigirá el fantasma.
	 */
	private Position posEsquinaAsustado (){
		//Fila
		int fila = nroRandom(31);
		while ((fila != 1) || (fila != 29))  {
			fila = nroRandom(31);
		}
		
		int columna = nroRandom(28);
		while ((columna != 1) || (columna != 26)) {
			columna = nroRandom(28);
		}
		
		return (new Position(fila,columna));
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
		Path path = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaDesignada.getX(), this.esquinaDesignada.getY());
		Step siguientePaso = path.getStep(1);
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
			Path path = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), this.esquinaAsustado.getX(), this.esquinaAsustado.getY());
			Step siguientePaso = path.getStep(1);
			this.setDireccion(Direccion.fromVector(new Position(siguientePaso.getX() - this.getPosicion().getX(), siguientePaso.getY() - this.getPosicion().getY())));
		}
	}
}
