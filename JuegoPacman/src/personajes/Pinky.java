package personajes;

import config.Config;
import estructuras.Direccion;
import path.Path;
import path.Path.Step;
import path.PathFinder;
import path.Position;

/**
 * Clase que representa al fantasma rosa, Pinky. 
 * @author mori
 *
 */
public class Pinky extends Fantasma{
	private String name = "Pinky";
	
	public String getName() {
		return name;
	}

	/**
	 * Guarda la posicion de Pacman en el turno anterior.
	 */
	private Position posicionAnteriorPacman = null;
	
	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial
	 */
	public Pinky(Position posInicial){
		super(posInicial);
		this.esquinaDesignada = Config.PINKY_CORNER;
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		if (posicionAnteriorPacman != null){
			Position vectorPacman = new Position(posicionPacman.getX() - posicionAnteriorPacman.getX(), posicionPacman.getY() - posicionAnteriorPacman.getY());
			Path path = PathFinder.findPath(
				this.getPosicion().getX(), posicionPacman.getX()+4*vectorPacman.getX(),
				this.getPosicion().getY(), posicionPacman.getY()+4*vectorPacman.getY()
			);
			if (path == null)
				return;
			Step siguientePaso = path.getStep(0);
			
			this.setDireccion(
				Direccion.fromVector(new Position(
					siguientePaso.getX() - this.getPosicion().getX(),
					siguientePaso.getY() - this.getPosicion().getY()
					)
				)
			);
		}
		posicionAnteriorPacman = posicionPacman;
	}
	
}
