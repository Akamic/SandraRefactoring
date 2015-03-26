import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
public class InformeDeClient {


	public String informe(Client client) {
		String informe = client.composaCapsalera() + client.composaRestaInforme();
		return informe;
	}

	
	SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	private Date date = null;

	private Client creaClientSenseLloguers() {
		return new Client("48484785L", "Sandra", "698787878");
	}

	@Test
	public void testInforme() throws ParseException {

		Client client = new Client("48484785L", "Sandra", "698787878");

		Vehicle vehicleGeneral = new Vehicle("MarcaGeneral", "ModelGeneral",
				Vehicle.GENERAL);

		Lloguer lloguerGeneral = new Lloguer(dateFormat.parse("3/8/2014"), 2,
				vehicleGeneral);

		client.afegeix(lloguerGeneral);
	
	}

	@Test
	public void testInformeSenseLloguers() throws ParseException {

		Client sandra = new Client("12345678S", "Sandra", "666666666");
		//InformeDeClient informe = new InformeDeClient(sandra);
		String str = "Informe de lloguers del client Sandra (12345678S)\nImport a pagar: 0.0€\nPunts guanyats: 0\n";
		assertEquals(str, informe(sandra));
	}


	
	@Test
	public void testUnLloguerAmbVehicleBasicFinsATresDies()
			throws ParseException {

		Client sandra = new Client("12345678S", "Sandra", "66666666");

		Vehicle vehicle = new Vehicle("Tata", "Vista", Vehicle.BASIC);
		Lloguer lloguer = new Lloguer(date, 3, vehicle);
		sandra.afegeix(lloguer);
		sandra.afegeix(lloguer);
		String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 2700.0€\nImport a pagar: 2700.0€\nPunts guanyats: 1\n";
		assertEquals(str,informe(sandra));
	}

	@Test
	public void testUnLloguerAmbVehicleBasicAmbMesDeTresDies()
			throws ParseException {

		Client betatester = creaClientSenseLloguers();
		Vehicle vehicleBasic = new Vehicle("MarcaBasic", "ModelBasic",
				Vehicle.BASIC);
		Lloguer lloguerBasic = new Lloguer(dateFormat.parse("2/7/2013"), 4,
				vehicleBasic);
		betatester.afegeix(lloguerBasic);
		String str = "Informe de lloguers del client Sandra (48484785L)\n\tModelBasic MarcaBasic: 4050.0€\nImport a pagar: 4050.0€\nPunts guanyats: 1\n";
		assertEquals(str,informe(betatester));
	}

	@Test
	public void testUnLloguerAmbVehicleGeneralDeDosDies() throws ParseException {
		Client sandra = new Client("12345678S", "Sandra", "66666666");

		Vehicle vehicle = new Vehicle("Tata", "Vista", Vehicle.GENERAL);
		Lloguer lloguer = new Lloguer(date, 2, vehicle);
		sandra.afegeix(lloguer);
		sandra.afegeix(lloguer);
		String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 3600.0€\nImport a pagar: 3600.0€\nPunts guanyats: 1\n";
		assertEquals(str, informe(sandra));
	}

	@Test
	public void testMesDunLloguerDeTresDiesGeneral() {
		Client sandra = new Client("12345678S", "Sandra", "66666666");

		Vehicle vehicle = new Vehicle("Tata", "Vista", Vehicle.GENERAL);
		Lloguer lloguer = new Lloguer(date, 3, vehicle);
		Lloguer lloguer2 = new Lloguer(date, 3, vehicle);
		sandra.afegeix(lloguer);
		sandra.afegeix(lloguer2);
		String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 5850.0€\n\tVista Tata: 5850.0€\nImport a pagar: 11700.0€\nPunts guanyats: 2\n";
		assertEquals(str, informe(sandra));
	}

	@Test
	public void testUnLloguerVehicleGeneral_1dia() throws ParseException {
		Client sandra = new Client("12345678S", "Sandra", "66666666");

		Vehicle vehicle = new Vehicle("Tata", "Vista", Vehicle.GENERAL);
		Lloguer lloguer = new Lloguer(date, 1, vehicle);
		sandra.afegeix(lloguer);
		String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 3600.0€\nImport a pagar: 3600.0€\nPunts guanyats: 1\n";
		assertEquals(str,informe(sandra));
	}

	
	  @Test
	    public void testMesDunLloguerDeUnDiaLuxe(){
		  	Client sandra = new Client("12345678S", "Sandra", "66666666");

	        Vehicle vehicle= new Vehicle("Tata", "Vista", Vehicle.LUXE);
	        Lloguer lloguer = new Lloguer(date, 1, vehicle);
	        Lloguer lloguer2 = new Lloguer(date, 1, vehicle);
	        sandra.afegeix(lloguer);
	        sandra.afegeix(lloguer2);
	        String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 5400.0€\n\tVista Tata: 5400.0€\nImport a pagar: 10800.0€\nPunts guanyats: 2\n";
	        assertEquals(str, informe(sandra));
	    }
	@Test
	public void testUnLloguerVehicleLuxe_varis_dies() throws ParseException {
		Client sandra = new Client("12345678S", "Sandra", "66666666");

        Vehicle vehicle= new Vehicle("Tata", "Vista", Vehicle.LUXE);
        Lloguer lloguer = new Lloguer(date, 3, vehicle);
        sandra.afegeix(lloguer);
        String str = "Informe de lloguers del client Sandra (12345678S)\n\tVista Tata: 16200.0€\nImport a pagar: 16200.0€\nPunts guanyats: 2\n";
        assertEquals(str, informe(sandra));
	}

}
