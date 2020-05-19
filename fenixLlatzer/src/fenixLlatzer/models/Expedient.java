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
	
	private Facultatiu genera;
	private Pacient organitza;
	
	public Expedient(String idExpedient, String patologia, Facultatiu fac, Pacient pac) {
		super();
		this.idExpedient = idExpedient;
		this.patologia = patologia;
		this.dataCreacio = LocalDate.now();
		this.dataTancament = null;
		this.obert = true;
		this.agrupat = new HashMap<String, Informe>();
		this.genera = fac;
		this.organitza = pac;
	}
	
	
	public String getIdExpedient() {
		return idExpedient;
	}

	public void tancar() {
		this.dataTancament= LocalDate.now();
		this.obert = false;		
		this.organitza = null;
		this.genera = null;		
	}


	public void iniciIntroduccioInforme(Informe i) throws Exception {
		if(!agrupat.containsKey(i.getIdInforme())) {
			agrupat.put(i.getIdInforme(), i);
		}
		else {
			throw new Exception ("Ja existeix un informe amb aquest ID per a aquest expedient!");
		}
	}
}
