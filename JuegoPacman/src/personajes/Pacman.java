package personajes;


import config.Config;
import estructuras.Direccion;
import objetos.BolaDePoder;
import objetos.Comida;
import path.Position;

public class Pacman extends Personaje {
	
	/**
	 * Cuantos pasos le restan a Pacman estando en su estado de poder
	 */
	private int pasosRestantesEmpoderado = 0;
	/**
	 * Contador de fantasmas comidos en este empoderamiento. Util para ver cuantos puntos darle en caso de que coma un fantasma.
	 */
	private int fantasmasComidosEsteEmpoderamiento = 0;
	
	/**
	 * Puntaje
	 */
	private int puntaje;
	public int getPuntaje() {
		return puntaje;
	}

	private Direccion direccion = Direccion.QUIETO;
	
	/**
	 * Variable que representa una instancia de Pacman. Sirve para solamente permitir una instancia a la vez.
	 */
	private static Pacman instancia = null;
	
	/**
	 * Constructor
	 * @param posInicial
	 * 		Posicion inicial de Pacman
	 */
	private Pacman(Position posInicial){
		super(posInicial);
	}
	
	/**
	 * Metodo que devuelve la unica instancia de Pacman
	 * @return
	 *  <b>Pacman</b> Instancia
	 */
	public static Pacman getPacman(){
		if (instancia == null){
			// TODO cambiar esto a una variable seteable en opciones
			instancia = new Pacman(Config.PACMAN_START);
		}
		return instancia;
	}
	
	/**
	 * Metodo que retorna true o false dependiendo de si Pacman esta empoerado o no.
	 * @return
	 * 		boolean : Empoderado
	 */
	public boolean estaEmpoderado(){
		return (this.pasosRestantesEmpoderado > 0);
	}
	
	/**
	 * Actualiza la posicion del personaje a la retornada por {@link getSiguientePosicion} <br>
	 * Tambien actualiza el estado de empoderamiento de Pacman.
	 */
	public void actualizarPosicion(){
		super.actualizarPosicion();
		if (this.pasosRestantesEmpoderado > 0)
			this.pasosRestantesEmpoderado--;
	}
	
	public void setDireccion(Direccion dir){
		super.setDireccion(dir);
	}
	
	public void comer(Comida comida){
		if (comida instanceof BolaDePoder){
			this.pasosRestantesEmpoderado = 20;
		}
		this.puntaje += comida.comer();
	}
	
}
