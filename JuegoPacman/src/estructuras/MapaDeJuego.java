package estructuras;

import config.Config;
import objetos.BolaDePoder;
import objetos.Comida;
import objetos.PacPunto;
import path.Map;
import path.Position;
/**
 * Clase que representa el mapa del juego
 * @author Mori
 *
 */
public class MapaDeJuego {
	private Map mapaObstaculos = new Map();
	private static MapaDeJuego instancia = new MapaDeJuego();
	private java.util.Map<Position, Comida> mapaComida = new java.util.HashMap<Position, Comida>();
	/**
	 * Constructor
	 */
	private MapaDeJuego(){
		for (int i = 0; i < this.mapaObstaculos.getWidth(); i++){
			for (int j = 0; i < this.mapaObstaculos.getHeight(); i++){
				if (this.mapaObstaculos.getCollidable(i, j) == 0){
					this.mapaComida.put(new Position(i, j), new PacPunto());
				}
			}
		}
		
		for (Position pos : Config.POWERBALL_POSITIONS){
			this.mapaComida.put(pos, new BolaDePoder());
		}
	}
	
	/**
	 * Retorna el mapa de obstaculos.
	 * @return
	 * 		path.Map Mapa de los obstaculos presentes en el juego.
	 */
	public Map getMap(){
		return this.mapaObstaculos;
	}
	
	/**
	 * Retorna la unica instancia de esta clase.
	 * @return
	 * 		MapaDeJuego Instancia de esta clase.
	 */
	public static MapaDeJuego getMapaDeJuego(){
		return instancia;
	}
	
	/**
	 * Devuelve un objeto comida en caso de que exista en el mapa.
	 * @param pos
	 * 		Position Posicion en la que se quiere comer comida.
	 * @return
	 * 		Comida Objeto comible por Pacman
	 */
	public Comida comer(Position pos){
		Comida c = this.mapaComida.get(pos);
		this.mapaComida.remove(pos);
		return c;
	}
}
