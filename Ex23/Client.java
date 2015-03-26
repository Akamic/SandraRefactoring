import java.util.Vector;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private Vector<Lloguer> lloguers;
	private static final double EUROS_PER_UNITAT_DE_COST = 30;

	public Client(String nif, String nom, String telefon) {
		this.nif = nif;
		this.nom = nom;
		this.telefon = telefon;
		this.lloguers = new Vector<Lloguer>();
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNif() {
		return nif;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTelefon() {
		return telefon;
	}

	public void afegeix(Lloguer lloguer) {
		if (!lloguers.contains(lloguer)) {
			lloguers.add(lloguer);
		}
	}

	public Vector<Lloguer> getLloguers() {
		return lloguers;
	}

	public void elimina(Lloguer lloguer) {
		if (lloguers.contains(lloguer)) {
			lloguers.remove(lloguer);
		}
	}

	public boolean conte(Lloguer lloguer) {
		return lloguers.contains(lloguer);
	}


	public String informehtml(String html) {
		String informeHTML = "";
		if (html.equalsIgnoreCase("html")) {
			informeHTML += composaCapsaleraHTML() + composaRestaInformeHTML();
		} else {
			informeHTML += composaCapsalera() + composaRestaInforme();
		}
		return informeHTML;

	}

	public String composaRestaInforme() {
		// afegeix informació final
		String resultat = "Import a pagar: %f €\n"
				+ "Punts guanyats: %d\n";
		String Head = String.format(resultat, importTotal(), bonificacionsTotals());
		return Head;
	}

	public String composaCapsalera() {	
		/**/
		String plantillaHead = "Informe de lloguers del client %s (%s)\n ";
		String Head = String.format(plantillaHead, getNom(), getNif());
		/**/
		for (Lloguer lloguer : lloguers) {
			// composa els resultats d'aquest lloguer
			Head += "\t" + lloguer.getVehicle().getMarca() + " "
					+ lloguer.getVehicle().getModel() + ": "
					+ (lloguer.CostPerVehicle() * EUROS_PER_UNITAT_DE_COST)
					+ "€" + "\n";
		}
		//return resultat;
		return Head;
	}

	private int bonificacionsTotals() {
		int bonificacions = 0;
		for (Lloguer lloguer : lloguers) {
			bonificacions += lloguer.bonificacions();
		}
		return bonificacions;
	}

	private double importTotal() {
		double total = 0;
		for (Lloguer lloguer : lloguers) {
			total += lloguer.CostPerVehicle() * EUROS_PER_UNITAT_DE_COST;
		}
		return total;
	}

	/* INFORME HTML EX20 */

	private String composaCapsaleraHTML() {
		String resultat = "<!DOCTYPE>" + "<meta charset='utf-8'>"
				+ "<h1>Informe Lloguers</h1>";
		resultat += "<p>Informe de lloguers del client <em>" + getNom()
				+ "</em> (<strong>" + getNif() + "</strong>)\n";
		String resultatlloguer = "<table border 1px>";
		resultat += resultatlloguer;
		resultat += "<tr><td>"
				+ "<strong>Marca</strong></td><td><strong>Model</strong></td><td><strong>Import</strong>"
				+ "</td></tr>     <tr>";
		String Head = String.format(resultat, getNom(), getNif());
		for (Lloguer lloguer : lloguers) {
			Head += "<tr><td><strong>" + lloguer.getVehicle().getMarca()
					+ "</strong></td>" + "<td><strong>"
					+ lloguer.getVehicle().getModel() + "</strong></td>"
					+ "<td>"
					+ (lloguer.CostPerVehicle() * EUROS_PER_UNITAT_DE_COST)
					+ "€</td></tr>";
		}
		Head += "</table>";
		return Head;

	}

	private String composaRestaInformeHTML() {
		String resultat = "<p>Import a pagar: <em> %f"
				+ "€</em></p>" + "<p>Punts guanyats: %d<em>"
				+ "</em></p>";
		String Head = String.format(resultat, importTotal(), bonificacionsTotals());
		return Head;
	}

}