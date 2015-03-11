import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;


public class TestInforme {
SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	@Test
	public void testInforme() throws ParseException {
		
		Client client = new Client("48484785L", "Sandra", "698787878");

		Vehicle vehicleGeneral = new Vehicle("MarcaGeneral", "ModelGeneral",Vehicle.GENERAL);
	
		Lloguer lloguerGeneral = new Lloguer(dateFormat.parse("3/8/2014"),2,vehicleGeneral);
		
		client.afegeix(lloguerGeneral);
		
	}
	@Test
	public void testInformeSenseLloguers() throws ParseException {
		Client betatester = creaClientSenseLloguers();
		/*algo asi*/
		String str = "Informe de lloguers del client Sandra (48484785L) Import a pagar: 0.0€ Punts guanyats: 0";
		assertEquals(str,betatester.informe());
	}
	@Test
	public void testUnLloguerAmbVehicleBasicFinsATresDies() throws ParseException {
		
		Client betatester = creaClientSenseLloguers();
		Vehicle vehicleBasic = new Vehicle("MarcaBasic", "ModelLuxe",Vehicle.BASIC);
		Lloguer lloguerBasic = new Lloguer(dateFormat.parse("2/7/2013"),2,vehicleBasic);
		betatester.afegeix(lloguerBasic);
		String str = "Informe de lloguers del client Sandra (48484785L) ModelLuxe MarcaBasic: 90.0€ Import a pagar: 90.0€ Punts guanyats: 1";
		assertEquals(str,betatester.informe());
	}
	
	@Test
	public void testUnLloguerAmbVehicleBasicAmbMesDeTresDies() throws ParseException {
	}
	
	private Client creaClientSenseLloguers() {
		return new Client("48484785L", "Sandra", "698787878");	
	}
	
	@Test
	public void testUnLloguerVehicleLuze_varis_dies() throws ParseException {
	}
	
	@Test
	public void testUnLloguerVehicleGeneral_1dia() throws ParseException {
	}
}
