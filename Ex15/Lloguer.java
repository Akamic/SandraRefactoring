import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	public Lloguer lloguer;
	
	public Lloguer(java.util.Date date, int dies, Vehicle vehicle) {
	this.data = date;
	this.dies = dies;
	this.vehicle = vehicle;
	
	}
	public Date getData() {
		return (Date) data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public int getDies() {
		return dies;
	}
	public void setDies(int dies) {
		this.dies = dies;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	 
	public double quantitat() {
		double quantitat = 0;
		switch (vehicle.getCategoria()) {
			case Vehicle.BASIC:
				quantitat += 3;
				if (dies > 3) {
					quantitat += (dies - 3) * 1.5;
				}
				break;
			case Vehicle.GENERAL:
				quantitat += 4;
				if (getDies() > 2) {
					quantitat += (dies - 2) * 2.5;
				}
				break;
			case Vehicle.LUXE:
				quantitat += dies * 6;
				break;
			}
		return quantitat * 30;
		
	}
	public int bonificacions() {
	       // afegeix bonificació per dos dies de lloguer de Luxe
        if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies()>1 ) {
           return 2;
        }else return 1;
    }
	
}
