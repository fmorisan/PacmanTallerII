package personajes;

import path.PathFinder;
import path.Position;
import estructuras.Direccion;
import path.Path.Step;

public class Clyde extends Fantasma{
	
	public Clyde(Position posInicial){
		super(posInicial);
	}
	
	public void estrategia(Position posicionPacman){
		
	}

	@Override
	public void estrategiaPersecucion(Position posicionPacman) {
		// TODO Auto-generated method stub
		int distanciaAPacman = Math.abs(this.getPosicion().getX() - posicionPacman.getX()) + Math.abs(this.getPosicion().getY() - posicionPacman.getY());
		
		if (distanciaAPacman > 8){
			Step proximoPaso = PathFinder.findPath(this.getPosicion().getX(), this.getPosicion().getY(), posicionPacman.getX(), posicionPacman.getY()).getStep(0);
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
