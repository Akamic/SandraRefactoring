import java.util.Vector;

public class Client {
	private String nif;
	private String nom;
	private String telefon;
	private Vector<Lloguer> lloguers;

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

	public String informe() {
		String resultat = "Informe de lloguers del client " + getNom() + " ("
				+ getNif() + ")\n";
		for (Lloguer lloguer : lloguers) {
			// composa els resultats d'aquest lloguer
			resultat += "\t" + lloguer.getVehicle().getMarca() + " "
					+ lloguer.getVehicle().getModel() + ": "
					+ (lloguer.quantitat() * 30) + "€" + "\n";
		}

		// afegeix informació final
		resultat += "Import a pagar: " + importTotal() + "€\n"
				+ "Punts guanyats: " + bonificacionsTotals() + "\n";
		return resultat;
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
			total += lloguer.quantitat() * 30;
		}
		return total;
	}

}