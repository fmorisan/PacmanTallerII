package personajes;


import estructuras.Direccion;
import path.Position;

public class Pacman extends Personaje {
	
	
	private int nroDeVidas;
	private int cantPasos;
	private boolean inmunidadTemp;
	
	public Pacman(Position posInicial){
		super(posInicial);
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
