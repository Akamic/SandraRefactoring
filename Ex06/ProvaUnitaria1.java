import static org.junit.Assert.*;
<<<<<<< HEAD
=======

>>>>>>> 423be8b35942c02004209449ea984dddddbb9d66
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class ProvaUnitaria1 {

	@Test
	public void testInforme() throws ParseException {
		String puntDePartida = "Informe de lloguers del client Sandra (48484785L)\n" +
				"\tModelLuxe MarcaBasic: 90.0€\n" +
				"\tModelGeneral MarcaGeneral: 120.0€\n" +
				"\tModelLuxe MarcaLuxe: 360.0€\nImport a pagar: 570.0€\n" +
				"Punts guanyats: 4\n";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
		Client client = new Client("48484785L", "Sandra", "698787878");
		Vehicle vehicleBasic = new Vehicle("MarcaBasic", "ModelLuxe",
				Vehicle.BASIC);
		Vehicle vehicleGeneral = new Vehicle("MarcaGeneral", "ModelGeneral",
				Vehicle.GENERAL);
		Vehicle vehicleLuxe = new Vehicle("MarcaLuxe", "ModelLuxe",
				Vehicle.LUXE);
		Lloguer lloguerBasic = new Lloguer(dateFormat.parse("2/7/2013"), 2,
				vehicleBasic);
		Lloguer lloguerGeneral = new Lloguer(dateFormat.parse("3/8/2014"), 2,
				vehicleGeneral);
		Lloguer lloguerLuxe = new Lloguer(dateFormat.parse("4/9/2015"), 2,
				vehicleLuxe);

		client.afegeix(lloguerBasic);
		client.afegeix(lloguerGeneral);
		client.afegeix(lloguerLuxe);
		
		assertEquals(client.informe(), puntDePartida);
	}

}