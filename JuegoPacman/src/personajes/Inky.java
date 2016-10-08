package personajes;

import estructuras.Direccion;

import path.Path.Step;
import path.PathFinder;
import path.Position;

/**
 * Clase que representa al fantasma azul, Inky
 * @author mori
 *
 */
public class Inky extends Fantasma{
	/**
	 * Guarda la posicion de Pacman en el turno anterior.
	 */
	private Position posicionAnteriorPacman = null;
	
	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial
	 */
	public Inky(Position posInicial) {
		super(posInicial);
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		if (posicionAnteriorPacman != null){
			Position vectorPacman = new Position(
					posicionPacman.getX() - posicionAnteriorPacman.getX(),
					posicionPacman.getY() - posicionAnteriorPacman.getY()
					);
			// dos casilleros adelante de Pacman
			Position P1 = Position.add(posicionPacman, vectorPacman);
			P1 = Position.add(P1, vectorPacman);
			
			Position vectorDesplazamiento = new Position(
					P1.getX() - this.getPosicion().getX(),
					P1.getY() - this.getPosicion().getY()
					);
			
			Position target = new Position(
					this.getPosicion().getX()+2*vectorDesplazamiento.getX(),
					this.getPosicion().getY()+2*vectorDesplazamiento.getY()
					);
			Step proximoPaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), target.getX(), target.getY()).getStep(0);
			
			this.setDireccion(Direccion.fromVector(
					new Position(
							proximoPaso.getX() - this.getPosicion().getX(),
							proximoPaso.getY() - this.getPosicion().getY()
							)
					));
		}
	}
	
}
