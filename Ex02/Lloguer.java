import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date date, int dies, Vehicle vehicle) {
	this.data = date;
	this.dies = dies;
	this.vehicle = vehicle;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getData() {
		return this.data;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public int getDies() {
		return this.dies;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	 
}
