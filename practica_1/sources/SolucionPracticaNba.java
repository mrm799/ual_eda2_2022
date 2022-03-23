package Practica01;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SolucionPracticaNba {
	
	private static String rutaArchivo = System.getProperty("user.dir")
			+ File.separator + "src"
			+ File.separator + "Practica01"
			+ File.separator + "NbaStats.csv";
	private static ArrayList<Player> nbaPlayers;
	public static int topN = 10;
	
	public static int size() {
		return nbaPlayers.size();
	}
	
	public static void main(String[] args) {
		cargarArchivo(rutaArchivo);
		long principio = System.currentTimeMillis();
		mejoresJugadores();
		long fin = System.currentTimeMillis();
		System.out.println("\n" + "Tiempo total: " + (fin - principio) + " milisegundos");
	}
	
	public static ArrayList<Player> mejoresJugadores() {
		if (nbaPlayers.size() == 0) {
			throw new RuntimeException("No hay datos");
		} else {
			ArrayList<Player> jugadores = mejoresJugadores(0, nbaPlayers.size() - 1);
			System.out.println("LOS " + topN + " MEJORES JUGADORES DE TODOS LOS TIEMPOS SON:" + "\n");
			for (Player p : jugadores) {
				System.out.println(p);
			}
			return jugadores;
		}
	}
	
	public static ArrayList<Player> mejoresJugadores(int principio, int fin) {
		ArrayList<Player> aux = new ArrayList<Player>(topN);
		if (principio == fin) {
			aux.add(nbaPlayers.get(principio));
		} else {
			int media = (principio + fin) / 2;
		ArrayList<Player> p1 = mejoresJugadores(principio, media);
		ArrayList<Player> p2 = mejoresJugadores(media + 1, fin);
		int i = 0;
		int j = 0;
		while (aux.size() < topN && i <= p1.size() - 1 && j <= p2.size() - 1) {
			if (p1.get(i).getScore() > p2.get(j).getScore()) {
				aux.add(p1.get(i));
				i++;
			} else {
				aux.add(p2.get(j));
				j++;
			}

		}
		while (aux.size() < topN && i <= p1.size() - 1) {
			aux.add(p1.get(i));
			i++;
		}
		while (aux.size() < topN && j <= p2.size() - 1) {
			aux.add(p2.get(j));
			j++;
		}
	 }
		return aux;
	}
	
	public static void cargarArchivo(String rutaArchivo) {
		nbaPlayers = new ArrayList<Player>();
		try {
			Scanner entrada = new Scanner (new File(rutaArchivo));
			String linea = "";
			String []tokens;
			Player ultimoJugadorCargado = null;
			String ultimaPersonaCargada = "";
			while (entrada.hasNextLine()) {
				linea = entrada.nextLine().trim();
				if ((linea.isEmpty()) || (linea.startsWith("#"))) continue;
				tokens = linea.split(";");
				if (tokens.length != 9) continue;
				double fg = comprobarValor(tokens[7]);
				double ptos = comprobarValor(tokens[8]);
				int puntuacion = (int) (fg * ptos / 100);
				if (!tokens[2].equals(ultimaPersonaCargada)) {
					ultimoJugadorCargado = new Player(tokens[2], tokens[6], tokens[4], puntuacion);
					nbaPlayers.add(ultimoJugadorCargado);
					ultimaPersonaCargada = tokens[2];
				} else {
					ultimoJugadorCargado.cargarJugador(tokens[6], tokens[4], puntuacion);
				}
			}
			entrada.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("No se han encontrado los datos");
		}
	}
	
	private static double comprobarValor(String valor) {
		if (valor.isEmpty()) return 0;
		try {
			double d = Double.parseDouble(valor.replace(",", "."));
			return d;
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
