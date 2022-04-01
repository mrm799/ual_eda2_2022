package Practica01;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TestTop5JUnit {
	private static String rutaArchivo = System.getProperty("user.dir")
			+File.separator+"src"
			+File.separator+"Practica01"
			+File.separator+"NbaStats.csv";
		
	@Test
	public void mejoresJugadores() {
		SolucionPracticaNba.cargarArchivo(rutaArchivo);
		SolucionPracticaNba.topN = 5;
		ArrayList<Player> r = SolucionPracticaNba.mejoresJugadoresConMejora();
		assertEquals("[Nombre: Wilt Chamberlain*, Posiciones: [C], Equipos: [PHW, SFW, TOT, PHI, LAL] , con 1153 puntos, "
				+ "Nombre: Kareem Abdul-Jabbar*, Posiciones: [C], Equipos: [MIL, LAL] , con 1076 puntos, " 
				+ "Nombre: Michael Jordan*, Posiciones: [SG, SF], Equipos: [CHI, WAS] , con 1075 puntos, " 
				+ "Nombre: George Gervin*, Posiciones: [SF, SG], Equipos: [SAS, CHI] , con 1059 puntos, " 
				+ "Nombre: LeBron James, Posiciones: [SG, SF, PF], Equipos: [CLE, MIA] , con 1034 puntos]", r.toString());
	}
}