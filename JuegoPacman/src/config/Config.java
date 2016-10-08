package config;

import path.Position;

public final class Config {
	/*
	 * Posiciones iniciales
	 */
	public static final Position PACMAN_START = new Position(20, 13);
	public static final Position INKY_START = new Position(11,	11);
	public static final Position PINKY_START = new Position(11, 13);
	public static final Position BLINKY_START = new Position(8, 13);
	public static final Position CLYDE_START =  new Position(11, 15);
	
	/*
	 * Velocidades
	 */
	public static final int GHOST_SPEED = 10;
	public static final int PACMAN_SPEED = 10;
	
	/*
	 * Puntajes
	 */
	public static final int PACPOINT_SCORE = 10;
	public static final int POWERBALL_SCORE = 50;
}
