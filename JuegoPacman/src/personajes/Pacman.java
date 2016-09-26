package personajes;


import estructuras.Direccion;

public class Pacman extends Personaje {
	
	
	private int nroDeVidas;
	private int cantPasos;
	private boolean inmunidadTemp;
	
	@Override
	public void crearPersonaje() {
		// TODO Auto-generated method stub
		
	}

	
	public int getNroDeVidas() {
		return nroDeVidas;
	}

	public void setNroDeVidas(int nroDeVidas) {
		this.nroDeVidas = nroDeVidas;
	}

	public int getCantPasos() {
		return cantPasos;
	}

	public void setCantPasos(int cantPasos) {
		this.cantPasos = cantPasos;
	}

	public void mover(Direccion dir){
	
		
	}
	
}
