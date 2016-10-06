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
	private Direccion direccion = Direccion.QUIETO;
	private static Pacman instancia = null;
	
	private Pacman(Position posInicial){
		super(posInicial);
	}
	
	public Pacman getPacman(){
		if (this.instancia == null){
			// TODO cambiar esto a una variable seteable en opciones
			this.instancia = new Pacman(new Position(0, 0));
		}
		return this.instancia;
	}
	
	public void cambiarDireccion(Direccion dir){
		this.direccion = dir;
	}
	
	public boolean estaEmpoderado(){
		return (this.pasosRestantesEmpoderado > 0);
	}
	
	public void actualizarPosicion(){
		
	}
	
}
