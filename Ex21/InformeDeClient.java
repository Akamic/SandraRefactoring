
public class InformeDeClient {
	

	public InformeDeClient(Client client) {
		
	}

	public String informe(Client client) {
		String informe = client.composaCapsalera() + client.composaRestaInforme();
		return informe;
	}



}
