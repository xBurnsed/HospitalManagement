package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;

public class Pacient {

	//id
	private String TSI;
	
	private String nomPacient;
	private String numTelef;
	public int nombreExpedientsAnual;
	public int nombreInformesAnual;
	public float mitjaInformes;
	
	private Map<String, Expedient> actiu;
	private Map<String, Expedient> organitza;
	
	public Pacient(String tSI, String nomPacient, String numTelef) {
		super();
		this.TSI = tSI;
		this.nomPacient = nomPacient;
		this.numTelef = numTelef;
		this.nombreExpedientsAnual = 0;
		this.nombreInformesAnual = 0;
		this.mitjaInformes = 0;
		this.actiu = new HashMap<String, Expedient>();
		this.organitza = new HashMap<String, Expedient>();
	}

	public String getTSI() {
		return TSI;
	}

	public String getNomPacient() {
		return nomPacient;
	}

	public String getNumTelef() {
		return numTelef;
	}

	public void iniciAny() {
		this.nombreExpedientsAnual = 0;
		this.nombreInformesAnual = 0;
		this.mitjaInformes = 0;
	}

	public void tancar(Expedient e) {
		actiu.remove(e.getIdExpedient());
	}	
	
	
	
	
	
}
