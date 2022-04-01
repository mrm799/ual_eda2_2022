package Practica01;

import java.util.ArrayList;

public class GenerarJugadoresAleatorios {
	
	public static void main(String[] args) {
		long inicio;
		long fin;
			createNbaRnd(5000000, 15);
			inicio = System.currentTimeMillis();
			//SolucionPracticaNba.mejoresJugadoresSinMejora();
			SolucionPracticaNba.mejoresJugadoresConMejora();
			fin = System.currentTimeMillis();
			System.out.println();
			System.out.println("Tiempo de ejecución:" + (fin - inicio) + " milisegundos");
	}
	
	private static void createNbaRnd(int N, int topN) {
		SolucionPracticaNba.nbaPlayers = new ArrayList<Player>();
		for (int i = 0; i < N; i++) {
			Player p = new Player("Jugador" + i, "", "", (int)(Math.random()*N));
			SolucionPracticaNba.nbaPlayers.add(p);
		}
		SolucionPracticaNba.topN = topN;
	}

}
