package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;

public class Facultatiu {

	//id
	private String idFacultatiu;
	
	private String nomFactultatiu;
	public int nombreExpedientsAnuals;
	public int nombreInformesAnuals;
	public float mitjaInformes;
	
	//llistas d'access
	private Map<String, Hospital> visita;
	private Map<String, Expedient> genera;
	private Map<String, Expedient> obert;
	
	
	public Facultatiu(String idFacultatiu, String nomFactultatiu) {
		super();
		this.idFacultatiu = idFacultatiu;
		this.nomFactultatiu = nomFactultatiu;
		this.nombreExpedientsAnuals = 0;
		this.nombreInformesAnuals = 0;
		this.mitjaInformes = 0;
		this.visita = new HashMap<String, Hospital>();
		this.genera = new HashMap<String, Expedient>();
		this.obert = new HashMap<String, Expedient>();
	}


	public void iniciAny() {
		this.nombreExpedientsAnuals = 0;
		this.nombreInformesAnuals = 0;
		this.mitjaInformes = 0;
	}
	
	public void tancar(Expedient e) {
		obert.remove(e.getIdExpedient());
	}


	public void iniciIntroduccioInforme(Expedient e) {
		genera.put(e.getIdExpedient(), e);
		obert.put(e.getIdExpedient(),e);
	}
	
	
		
}
