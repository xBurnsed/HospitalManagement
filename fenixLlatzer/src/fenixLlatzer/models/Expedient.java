package fenixLlatzer.models;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Expedient {
	//id
	private String idExpedient;
	
	private String patologia;
	private LocalDate dataCreacio;
	private LocalDate dataTancament;
	private boolean obert;
	
	//repositori
	private Map<String,Informe> agrupat;
	
	private Facultatiu fac;
	private Pacient pac;
	
	public Expedient(String idExpedient, String patologia, Facultatiu fac, Pacient pac) {
		super();
		this.idExpedient = idExpedient;
		this.patologia = patologia;
		this.dataCreacio = LocalDate.now();
		this.dataTancament = null;
		this.obert = true;
		this.agrupat = new HashMap<String, Informe>();
		this.fac = fac;
		this.pac = pac;
	}
	
	
	public String getIdExpedient() {
		return idExpedient;
	}

	public void tancar() {
		this.obert = false;		
		this.pac.tancar(this);
		this.fac.tancar(this);
		this.pac = null;
		this.fac = null;
		this.dataTancament= LocalDate.now();
		
	}
}
