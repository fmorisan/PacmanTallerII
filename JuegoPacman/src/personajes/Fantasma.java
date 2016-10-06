package personajes;

import path.Position;
import estructuras.Modo;

public abstract class Fantasma extends Personaje {


	 private static final int VELOCIDAD = 15;
	 private static final int[] DIRECCION_REVERSA = new int[4];
	 private Modo modo = Modo.PERSECUCION;
	
	 private Position pos;

	 private boolean inHome;
	 private boolean exitingHome;
	 private boolean enteringHome;
	 
	 protected Fantasma(Position posInicial){
		 super(posInicial);
	 }
	/*
	 * Modifica la direccion del Fantasma debido a su estrategia
	 */
	public abstract void estrategia(Position posicionPacman);

}
