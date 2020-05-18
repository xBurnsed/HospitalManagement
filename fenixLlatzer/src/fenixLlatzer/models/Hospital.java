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
		
	public void actualitzaFacultatiu(String idFacultatiu, Facultatiu f) {
		if(visita.get(idFacultatiu) != null) {
			visita.put(idFacultatiu, f);
		}
		else {
			visita.remove(idFacultatiu);
		}
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
			this.nombrePatracolsAnual++;
			this.nombrePatracolsTotals++;
		}
		else {
			throw new Exception("Ja existeix un patracol amb aquest ID!");
		}
	}
	
		
	public ResultatProva introdueixResultat(boolean b, String TSI, String resultat, String nomProva, String idInforme) {
		
		Patracol p1 = this.patracols.get(TSI);
		ResultatProva r = p1.introdueixResultat(b, resultat, nomProva, idInforme);
				
		return r;
	}
	
	public void introdueixResultat(String TSI, String idInforme, ResultatProva r, String nomProva) {
		Patracol p2 = this.patracols.get(TSI);
		p2.introdueixResultat(idInforme, r, nomProva);
		
		
	}
	
	
	public void tancar(String idExpedient) throws Exception {
		if(pertany.containsKey(idExpedient)) {
			Expedient e = pertany.get(idExpedient);
			e.tancar();
		}
		else {
			throw new Exception ("No existeix cap expedient amb aquest ID per a aquest Hospital!");
		}
	}


	public void iniciAny() {
		this.nombreExpedientAnual = 0;
		this.nombrePatracolsAnual = 0;
	}


	public Informe iniciIntroduccioInforme(Facultatiu f, Pacient p, String idExpedient, String patologia, String observacions) {
		Expedient e;
		if(!pertany.containsKey(idExpedient)) {
			e = new Expedient(idExpedient, patologia, f, p);
			this.nombreExpedientAnual++;
			this.nombreExpedientsTotal++;
			pertany.put(e.getIdExpedient(), e);
			f.iniciIntroduccioInforme(e);
			f.nombreExpedientsAnuals++;
			p.nombreExpedientsAnual++;
		}
		
		Patracol pat = patracols.get(p.getTSI());
		Informe i = pat.iniciIntroduccioInforme(observacions);
		p.nombreInformesAnual++;
		p.mitjaInformes = p.nombreInformesAnual/p.nombreExpedientsAnual;
		f.nombreInformesAnuals++;
		f.mitjaInformes = f.nombreInformesAnuals/f.nombreExpedientsAnuals;
		
		return i;
		
		
	}


}
			
