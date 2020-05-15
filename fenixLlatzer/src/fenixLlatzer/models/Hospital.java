package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;

public class Hospital {
	
	//id
	private String nomHospital;
	
	private int nombreExpedientAnual;
	private int nombreExpedientsTotal;
	private int nombrePatracolsAnual;
	private int nombrePatracolsTotals;
	
	//llistas d'acces
	private Map<String,ProvaDiagnostica> realitza;
	private Map<String,Facultatiu> visita;
	
	//repositoris
	private Map<String,Expedient> pertany;
	private Map<String,Patracol> patracols;
	
	
	public Hospital(String nomHospital, int nombreExpedientAnual, int nombreExpedientsTotal, int nombrePatracolsAnual, int nombrePatracolsTotals) {
		super();
		this.nomHospital = nomHospital;
		this.nombreExpedientAnual = nombreExpedientAnual;
		this.nombreExpedientsTotal = nombreExpedientsTotal;
		this.nombrePatracolsAnual = nombrePatracolsAnual;
		this.nombrePatracolsTotals = nombrePatracolsTotals;
		
		this.realitza = new HashMap<String, ProvaDiagnostica>();
		this.visita = new HashMap<String, Facultatiu>();
		this.pertany = new HashMap<String, Expedient>();
		this.patracols = new HashMap<String, Patracol>();
	}


	public String getNomHospital() {
		return nomHospital;
	}	
	
	//neteja estadistiques i llistes en cas que fos una reinstalació.
	public void novaInstalacio() {
		this.nombreExpedientAnual = 0;
		this.nombreExpedientsTotal = 0;
		this.nombrePatracolsAnual = 0;
		this.nombrePatracolsTotals = 0;
		
		this.realitza = new HashMap<String, ProvaDiagnostica>();
		this.visita = new HashMap<String, Facultatiu>();
		this.pertany = new HashMap<String, Expedient>();
		this.patracols = new HashMap<String, Patracol>();
	}
	
	
	public void nouPatracol(Pacient p) throws Exception {
		if(p != null && !patracols.containsKey(p.getTSI())) {
			Patracol pat = new Patracol(p);
			patracols.put(pat.getIdPatracol(), pat);
			this.nombreExpedientAnual++;
			this.nombrePatracolsTotals++;
		}
		else {
			throw new Exception("No s'ha pogut donar d'alta el nou pacient. Comprova que no existeixi!");
		}
	}
	
	/*
	public void introdueixResultat(Pacient p, String idInforme, ProvaDiagnostica pd, String resultat) {
		if(p != null && patracols.containsKey(p.getTSI())) {
			Patracol pat = patracols.get(p.getTSI());
			Informe pat.
			this.nombreExpedientAnual++;
			this.nombrePatracolsTotals++;
		}
		else {
			throw new Exception("No s'ha pogut donar d'alta el nou pacient. Comprova que no existeixi!");
		}
		
	}*/
		
}
