package Practica01;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TestTop15JUnit5 {
	private static String rutaArchivo = System.getProperty("user.dir")
			+File.separator+"src"
			+File.separator+"Practica01"
			+File.separator+"NbaStats.csv";
	
	@Test
	public void mejoresJugadores() {
		SolucionPracticaNba.cargarArchivo(rutaArchivo);
		SolucionPracticaNba.topN = 15;
		ArrayList<Player> r = SolucionPracticaNba.mejoresJugadoresConMejora();
		assertEquals("[Nombre: Wilt Chamberlain*, Posiciones: [C], Equipos: [PHW, SFW, TOT, PHI, LAL] , con 1153 puntos, "
				+ "Nombre: Kareem Abdul-Jabbar*, Posiciones: [C], Equipos: [MIL, LAL] , con 1076 puntos, "
				+ "Nombre: Michael Jordan*, Posiciones: [SG, SF], Equipos: [CHI, WAS] , con 1075 puntos, "
				+ "Nombre: George Gervin*, Posiciones: [SF, SG], Equipos: [SAS, CHI] , con 1059 puntos, "
				+ "Nombre: LeBron James, Posiciones: [SG, SF, PF], Equipos: [CLE, MIA] , con 1034 puntos, "
				+ "Nombre: Karl Malone*, Posiciones: [PF], Equipos: [UTA, LAL] , con 1005 puntos, "
				+ "Nombre: Karl-Anthony Towns, Posiciones: [C], Equipos: [MIN] , con 965 puntos, "
				+ "Nombre: Kevin Durant, Posiciones: [SG, SF], Equipos: [SEA, OKC, GSW] , con 935 puntos, "
				+ "Nombre: Oscar Robertson*, Posiciones: [PG], Equipos: [CIN, MIL] , con 925 puntos, "
				+ "Nombre: Jerry West*, Posiciones: [PG, SG], Equipos: [LAL] , con 854 puntos, "
				+ "Nombre: Julius Erving*, Posiciones: [SF], Equipos: [PHI] , con 847 puntos, "
				+ "Nombre: Larry Bird*, Posiciones: [PF, SF], Equipos: [BOS] , con 832 puntos, "
				+ "Nombre: Bob Pettit*, Posiciones: [PF, C], Equipos: [MLH, STL] , con 827 puntos, "
				+ "Nombre: Dan Issel*, Posiciones: [C], Equipos: [DEN] , con 825 puntos, "
				+ "Nombre: Rick Barry*, Posiciones: [SF], Equipos: [SFW, GSW, HOU] , con 824 puntos]", r.toString());
	}
}