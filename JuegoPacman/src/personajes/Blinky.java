package personajes;

import estructuras.Direccion;
import path.Path.Step;
import path.PathFinder;
import path.Position;
/**
 * Clase que representa al fantasma rojo, Blinky
 * @author mori
 *
 */
public class Blinky extends Fantasma{
	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial
	 */
	public Blinky(Position posInicial){
		super(posInicial);
		// TODO cambiar por un valor seteable en opciones
		this.esquinaDesignada = new Position(0, 0);
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		Step siguientePaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), posicionPacman.getX(), posicionPacman.getY()).getStep(0);
		this.setDireccion(Direccion.fromVector(new Position(siguientePaso.getX() - this.getPosicion().getX(), siguientePaso.getY() - this.getPosicion().getY())));
	}
	
	
}
