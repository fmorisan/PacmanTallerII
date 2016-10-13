package personajes;

import path.PathFinder;
import path.Position;
import config.Config;
import estructuras.Direccion;
import path.Path.Step;

/**
 * Clase que representa al fantasma naranja, Clyde
 * @author mori
 *
 */
public class Clyde extends Fantasma{
	private String name = "Clyde";
	
	public String getName() {
		return name;
	}

	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial
	 */
	public Clyde(Position posInicial){
		super(posInicial);
		this.esquinaDesignada = Config.CLYDE_CORNER;
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		int distanciaAPacman = Math.abs(this.getPosicion().getX() - posicionPacman.getX()) + Math.abs(this.getPosicion().getY() - posicionPacman.getY());
		
		if (distanciaAPacman > 8){
			Step proximoPaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), posicionPacman.getX(), posicionPacman.getY()).getStep(1);
			this.setDireccion(Direccion.fromVector(
					new Position(
							proximoPaso.getX() - this.getPosicion().getX(),
							proximoPaso.getY() - this.getPosicion().getY()
							)
					));
		} else {
			this.estrategiaDispersion();
		}
		
	}
}
