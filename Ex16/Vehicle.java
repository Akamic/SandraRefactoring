public class Vehicle {
	public static final int BASIC = 0;
	public static final int GENERAL = 1;
	public static final int LUXE = 2;

	private String model;
	private String marca;
	private int categoria;

	public Vehicle(String model, String marca, int categoria) {
		super();
		this.model = model;
		this.marca = marca;
		this.categoria = categoria;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public int getCategoria() {
		return categoria;
	}
}