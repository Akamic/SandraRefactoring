import java.util.Date;

public class Lloguer {
	private java.util.Date Data;
	private int Dies;
	private Vehicle vehicle;
	
	public Lloguer(java.util.Date date, int dies, Vehicle vehicle) {
	this.Data = date;
	this.Dies = dies;
	this.vehicle = vehicle;
	}
	public Date getData() {
		return (Date) Data;
	}
	public void setData(Date data) {
		this.Data = data;
	}
	public int getDies() {
		return Dies;
	}
	public void setDies(int dies) {
		this.Dies = dies;
	}
	public Vehicle getVehicle() {

		return vehicle;
	}
	 
}
