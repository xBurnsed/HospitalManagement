package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;

public class Facultatiu {

	//id
	private String idFacultatiu;
	
	private String nomFactultatiu;
	private int nombreExpedientsAnuals;
	private int nombreInformesAnuals;
	private float mitjaInformes;
	
	//llistas d'access
	private Map<String, Hospital> visita;
	private Map<String, Expedient> genera;
	private Map<String, Expedient> obert;
	
	
	public Facultatiu(String idFacultatiu, String nomFactultatiu, int nombreExpedientsAnuals, int nombreInformesAnuals,
			float mitjaInformes) {
		super();
		this.idFacultatiu = idFacultatiu;
		this.nomFactultatiu = nomFactultatiu;
		this.nombreExpedientsAnuals = nombreExpedientsAnuals;
		this.nombreInformesAnuals = nombreInformesAnuals;
		this.mitjaInformes = mitjaInformes;
		this.visita = new HashMap<String, Hospital>();
		this.genera = new HashMap<String, Expedient>();
		this.obert = new HashMap<String, Expedient>();
	}
	
	
	
	
	
	
	
		
}
