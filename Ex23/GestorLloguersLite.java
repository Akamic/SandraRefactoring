import java.text.SimpleDateFormat;

public class GestorLloguersLite {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("d/M/yyyy");
	private static String InformeHTML = "html";
	public static String composaClient(Client client) {

		String strBase = "Client: %s\n\t%s\n\t%s\n" + "Lloguers: %d\n";
		String strLloguerBase = "\t%d. vehicle: %s %s\n"
				+ "\t\tdata d'inici: %s\n\t\tdies llogats: %d\n";

		String strClient = String.format(strBase, client.getNom(), client
				.getNif(), client.getTelefon(), client.getLloguers().size());

		int cont = 0;
		for (Lloguer lloguer : client.getLloguers()) {
			cont++;
			String strLloguer = String.format(strLloguerBase, cont, lloguer
					.getVehicle().getModel(), lloguer.getVehicle().getMarca(),
					dateFormat.format(lloguer.getData()), lloguer.getDies());
			strClient += strLloguer;
		}

		return strClient;

	}

	public static void main(String[] args) throws Throwable {
		// Creamos el cliente de prueba
		Client client = new Client("48484785L", "Sandra", "698787878");

		// creamos un veh�culo de cada tipo para la prueba
		Vehicle vehicleBasic = new Vehicle("MarcaBasic", "ModelLuxe",
				Vehicle.BASIC);
		Vehicle vehicleGeneral = new Vehicle("MarcaGeneral", "ModelGeneral",
				Vehicle.GENERAL);
		Vehicle vehicleLuxe = new Vehicle("MarcaLuxe", "ModelLuxe",
				Vehicle.LUXE);

		// Creamos los tres lloguers de prueba con fechas diferentes
		Lloguer lloguerBasic = new Lloguer(dateFormat.parse("2/7/2013"), 2,
				vehicleBasic);
		Lloguer lloguerGeneral = new Lloguer(dateFormat.parse("3/8/2014"), 2,
				vehicleGeneral);
		Lloguer lloguerLuxe = new Lloguer(dateFormat.parse("4/9/2015"), 2,
				vehicleLuxe);
		InformeDeClient inform = new InformeDeClient();
		client.afegeix(lloguerBasic);
		client.afegeix(lloguerGeneral);
		client.afegeix(lloguerLuxe);

		String clientProvaAmbLloguers = composaClient(client);
		System.out.println(clientProvaAmbLloguers);
		System.out.println(inform.informe(client));
		System.out.println(client.informehtml(InformeHTML));
	}

}