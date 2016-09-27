package personajes;

public abstract class Fantasmas extends Personaje {


	 private static final int VELOCIDAD = 15;
	 private static final int[] DIRECCION_REVERSA = new int[4];
	
	 private int posX;
	 private int posY;

	 private boolean inHome;
	 private boolean exitingHome;
	 private boolean enteringHome;
	 
	@Override
	public void crearPersonaje() {
		// TODO Auto-generated method stub
		
	}

}
