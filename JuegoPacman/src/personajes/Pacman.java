package personajes;


import estructuras.Direccion;
import path.Position;

public class Pacman extends Personaje {
	
	// comienza sin poderes.
	private int pasosRestantesEmpoderado = 0;
	// comienza sin haber comido fantasmas
	// lo usamos para ver cuantos puntos darle a Pacman
	private int fantasmasComidosEsteEmpoderamiento = 0;
	
	private int puntaje;
	
	public Pacman(Position posInicial){
		super(posInicial);
	}
	
	public void cambiarDireccion(Direccion dir){
		this.direccion = dir;
	}
	
	public boolean estaEmpoderado(){
		return (this.pasosRestantesEmpoderado > 0);
	}
	
}
