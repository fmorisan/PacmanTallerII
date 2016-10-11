package personajes;

import config.Config;
import estructuras.Direccion;
import path.Path;
import path.Path.Step;
import path.PathFinder;
import path.Position;
/**
 * Clase que representa al fantasma rojo, Blinky
 * @author mori
 *
 */
public class Blinky extends Fantasma{	
	private String name = "Blinky";
	public String getName() {
		return name;
	}

	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial
	 */
	public Blinky(Position posInicial){
		super(posInicial);
		// TODO cambiar por un valor seteable en opciones
		this.esquinaDesignada = Config.BLINKY_CORNER;
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		Path path = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), posicionPacman.getX(), posicionPacman.getY());
		Step siguientePaso = path.getStep(0);
		this.setDireccion(Direccion.fromVector(new Position(siguientePaso.getX() - this.getPosicion().getX(), siguientePaso.getY() - this.getPosicion().getY())));
	}
	
	
}
