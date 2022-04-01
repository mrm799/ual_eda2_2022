package Practica01;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TestTop3JUnit5 {
	private static String rutaArchivo = System.getProperty("user.dir")
			+File.separator+"src"
			+File.separator+"Practica01"
			+File.separator+"NbaStats.csv";
	
	
	@Test
	public void mejoresJugadores() {
		SolucionPracticaNba.cargarArchivo(rutaArchivo);
		SolucionPracticaNba.topN = 3;
		ArrayList<Player> r = SolucionPracticaNba.mejoresJugadoresConMejora();
		assertEquals("[Nombre: Wilt Chamberlain*, Posiciones: [C], Equipos: [PHW, SFW, TOT, PHI, LAL] , con 1153 puntos, "  
				+ "Nombre: Kareem Abdul-Jabbar*, Posiciones: [C], Equipos: [MIL, LAL] , con 1076 puntos, "  
				+ "Nombre: Michael Jordan*, Posiciones: [SG, SF], Equipos: [CHI, WAS] , con 1075 puntos]", r.toString());
	}

}