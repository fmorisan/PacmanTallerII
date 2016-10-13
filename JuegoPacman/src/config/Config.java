package config;

import path.Position;

/**
 * Clase que nuclea variables de configuracion.
 * @author mori
 *
 */
public final class Config {
	/**
	 * Posiciones iniciales
	 */
	public static final Position PACMAN_START = new Position(23, 14);
	public static final Position INKY_START = new Position(11, 10);
	public static final Position PINKY_START = new Position(11, 12);
	public static final Position BLINKY_START = new Position(11, 14);
	public static final Position CLYDE_START =  new Position(11, 16);
	public static final Position[] POWERBALL_POSITIONS = {
		new Position(1, 1),
		new Position(1, 26),
		new Position(23, 1),
		new Position(23, 26)
	};
	
	public static final Position INKY_CORNER = new Position(1, 1);
	public static final Position PINKY_CORNER = new Position(1, 26);
	public static final Position BLINKY_CORNER = new Position(29, 26);
	public static final Position CLYDE_CORNER = new Position(29, 1);
	
	/**
	 * Velocidades
	 */
	public static final int GHOST_SPEED = 10;
	public static final int PACMAN_SPEED = 10;
	
	/**
	 * Puntajes
	 */
	public static final int PACPOINT_SCORE = 10;
	public static final int POWERBALL_SCORE = 50;
}
