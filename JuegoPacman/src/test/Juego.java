package test;

import java.util.ArrayList;

import config.Config;
import estructuras.Direccion;
import estructuras.MapaDeJuego;
import estructuras.Modo;
import path.*;
import personajes.*;

public class Juego {
	private static Pacman pacman;
	private static ArrayList<Fantasma> fantasmas = new ArrayList<>();
	private static MapaDeJuego mapaJuego = MapaDeJuego.getMapaDeJuego();
	
	public static void main(String[] args) {
		// inicializacion
		pacman = Pacman.getPacman();
		fantasmas.add(new Inky(Config.INKY_START));
		fantasmas.add(new Pinky(Config.PINKY_START));
		fantasmas.add(new Blinky(Config.BLINKY_START));
		fantasmas.add(new Clyde(Config.CLYDE_START));
		System.out.println("Pacman esta en " + pacman.getPosicion().toString());
		for (Fantasma f : fantasmas){
			System.out.println(f.getName() + " esta en " + f.getPosicion().toString());
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
			if (pacman.estaEmpoderado()){
				f.setModo(Modo.ASUSTADO);
				System.out.println(f.getName() + " esta asustado!");
			}
			f.estrategia(pacman.getPosicion());
			if (mapaJuego.getMap().canMove(f.getSiguientePosicion().getX(), f.getSiguientePosicion().getY())){
				f.actualizarPosicion();
				System.out.println(f.getName() + " se movio a " + f.getPosicion().toString());
			}
		}
		path.Path.Step nextStep = pacmanPath.getStep(0);
		Position vectorMovimiento = new Position(nextStep.getX() - pacman.getPosicion().getX(), nextStep.getY() - pacman.getPosicion().getY());
		pacman.setDireccion(Direccion.fromVector(vectorMovimiento));
		if (mapaJuego.getMap().canMove(pacman.getSiguientePosicion().getX(), pacman.getSiguientePosicion().getY())){
			pacman.actualizarPosicion();
			System.out.println("Pacman se movio a " + pacman.getPosicion().toString());
			pacman.comer(mapaJuego.comer(pacman.getPosicion()));
		}
		
		
	}
}
