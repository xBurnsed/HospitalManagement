package fenixLlatzer.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Expedient {
	//id
	private String idExpedient;
	
	private String patologia;
	private Date dataCreacio;
	private Date dataTancament;
	private boolean obert;
	
	//repositori
	private Map<String,Informe> agrupat;
	
	private Facultatiu fac;
	private Pacient pac;
	private Hospital pertany;
	
	public Expedient(String idExpedient, String patologia, Date dataCreacio, Date dataTancament, boolean obert, Facultatiu fac, Pacient pac, Hospital hosp) {
		super();
		this.idExpedient = idExpedient;
		this.patologia = patologia;
		this.dataCreacio = dataCreacio;
		this.dataTancament = dataTancament;
		this.obert = obert;
		this.agrupat = new HashMap<String, Informe>();
		this.fac = fac;
		this.pac = pac;
		this.pertany = hosp;
	}

	public void tancar() {
		this.obert = false;
		this.pac = null;
		this.fac = null;
		
	}
	
	
	
}
