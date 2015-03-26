import java.util.Date;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	public Lloguer lloguer;
	private static final int UNITAT_DE_COST_ENTRE_1_3_DIES = 3;
	private static final int DIES_INICIALS_MATEIX_PREU_BASIC = 3;
	private static final int UNITAT_DE_COST_ENTRE_1_4_DIES = 4;
	private static final int DIES_INICIALS_MATEIX_PREU_GENERAL = 2;
	private static final int UNITAT_DE_COST_ENTRE_1_6_DIES = 6;
	
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
	 
	public double CostPerVehicle() {
		double cost_total_a_pagar = 0;
		switch (vehicle.getCategoria()) {
			case Vehicle.BASIC:
				cost_total_a_pagar += UNITAT_DE_COST_ENTRE_1_3_DIES;
				if (dies > DIES_INICIALS_MATEIX_PREU_BASIC) {
					cost_total_a_pagar += (dies - DIES_INICIALS_MATEIX_PREU_BASIC) * 1.5;
				}
				break;
			case Vehicle.GENERAL:
				cost_total_a_pagar += UNITAT_DE_COST_ENTRE_1_4_DIES;
				if (getDies() > DIES_INICIALS_MATEIX_PREU_GENERAL) {
					cost_total_a_pagar += (dies - DIES_INICIALS_MATEIX_PREU_GENERAL) * 2.5;
				}
				break;
			case Vehicle.LUXE:
				cost_total_a_pagar += dies * UNITAT_DE_COST_ENTRE_1_6_DIES;
				break;
			}
		return cost_total_a_pagar * 30;
		
	}
	public int bonificacions() {
	       // afegeix bonificació per dos dies de lloguer de Luxe
        if (getVehicle().getCategoria() == Vehicle.LUXE &&
                getDies()>1 ) {
           return 2;
        }else return 1;
    }
	
}
