package Practica01;

import java.util.ArrayList;

public class Player {
	private String playerName;
	private ArrayList<String> teams;
	private ArrayList<String> positions;
	private int score;
	public int topN = 10;

	public Player(String playerName, String team, String position, int score) {
		this.playerName = playerName;
		this.teams = new ArrayList<String>();
		this.teams.add(team);
		this.positions = new ArrayList<String>();
		this.positions.add(position);
		this.score = score;
	}

	public void cargarJugador(String team, String position, int score) {
		if (score <= 0) return;
		this.teams.add(team);
		this.positions.add(position);
		this.score += score;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public ArrayList<String> getTeams() {
		return this.teams;
	}

	public void setTeams(ArrayList<String> teams) {
		this.teams = teams;
	}

	public ArrayList<String> getPositions() {
		return this.positions;
	}

	public void setPositions(ArrayList<String> positions) {
		this.positions = positions;
	}

	public int getScore() {
		return this.score / this.teams.size();
	}

	public void setScore(int score) {
		this.score = score ;
	}
	
	public ArrayList<String> posicionJugador() {
		ArrayList<String> aux = new ArrayList<String>();
		for (String pos : getPositions()) {
			if (aux.contains(pos)) continue;
			else {
				aux.add(pos);
			}
		}
		return aux;
	}
	
	public ArrayList<String> equipoJugador() {
		ArrayList<String> aux = new ArrayList<String>();
		for (String equ : getTeams()) {
			if (aux.contains(equ)) continue;
			else {
				aux.add(equ);
			}
		}
		return aux;
	}

	@Override
	public String toString() {
		return "Nombre: " + this.playerName + ", Posiciones: " + posicionJugador() + ", Equipos: " 
			    + equipoJugador()+ " , con " + getScore() + " puntos";
	}
}

