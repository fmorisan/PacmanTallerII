package test;

import java.util.ArrayList;

import config.Config;
import estructuras.Direccion;
import estructuras.Modo;
import objetos.PacPunto;
import path.*;
import personajes.*;

public class Juego {
	private static Pacman pacman;
	private static ArrayList<Fantasma> fantasmas = new ArrayList<>();
	private static path.Map mapaJuego = new path.Map();
	private static path.GhostMap mapaFantasmas = new path.GhostMap();
	
	public static void main(String[] args) {
		// inicializacion
		int i = 0;
		for (byte[] x : mapaJuego.getCollidableMap()){
			System.out.print("Fila " + i + "-> ");
			for (byte y : x)
				System.out.print(y);
			System.out.println("");
			i++;
		}
		pacman = Pacman.getPacman();
		fantasmas.add(new Inky(Config.INKY_START));
		fantasmas.add(new Pinky(Config.PINKY_START));
		fantasmas.add(new Blinky(Config.BLINKY_START));
		fantasmas.add(new Clyde(Config.CLYDE_START));
		System.out.println("Pacman esta en " + pacman.getPosicion().toString());
		for (Fantasma f : fantasmas){
			System.out.println(f.getName() + " esta en " + f.getPosicion().toString());
			if (f.getModo() == Modo.ASUSTADO){
				System.out.println(f.getName() + " esta asustado!");
			}
		}
		System.out.println("Inicia el juego!");
		while (true) {
			simularTurno();
			if (pacman.getPosicion().equals(new Position(1, 23))){
				break;
			}
		}
		System.out.println("Pacman comio una bola de poder!");
		System.out.println("El juego termino! Pacman tiene " + pacman.getPuntaje() + " puntos!");
	}
	
	private static void simularTurno(){
		path.Path pacmanPath = PathFinder.findPath(pacman.getPosicion().getX(), pacman.getPosicion().getY(), 1, 23);
		for (Fantasma f : fantasmas){
			f.estrategia(pacman.getPosicion());
			if (mapaFantasmas.canMove(f.getSiguientePosicion().getX(), f.getSiguientePosicion().getY())){
				f.actualizarPosicion();
				System.out.println(f.getName() + " se movio a " + f.getPosicion().toString());
			}
		}
		path.Path.Step nextStep = pacmanPath.getStep(0);
		Position vectorMovimiento = new Position(nextStep.getX() - pacman.getPosicion().getX(), nextStep.getY() - pacman.getPosicion().getY());
		pacman.setDireccion(Direccion.fromVector(vectorMovimiento));
		if (mapaJuego.canMove(pacman.getSiguientePosicion().getX(), pacman.getSiguientePosicion().getY())){
			pacman.actualizarPosicion();
			System.out.println("Pacman se movio a " + pacman.getPosicion().toString());
			// TODO cambiar esto para que pacman coma las cosas del piso
			pacman.comer(new PacPunto());
		}
		
		
	}
}
