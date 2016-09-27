package personajes;

import path.Position;

public abstract class Fantasma extends Personaje {


	 private static final int VELOCIDAD = 15;
	 private static final int[] DIRECCION_REVERSA = new int[4];
	
	 private Position pos;

	 private boolean inHome;
	 private boolean exitingHome;
	 private boolean enteringHome;
	 
	 protected Fantasma(Position posInicial){
		 super(posInicial);
	 }
	 
	@Override
	public void crearPersonaje() {
		// TODO Auto-generated method stub
		
	}

}
