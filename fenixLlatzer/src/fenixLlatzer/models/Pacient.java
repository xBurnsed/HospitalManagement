package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;

public class Pacient {

	//id
	private String TSI;
	
	private String nomPacient;
	private String numTelef;
	private int nombreExpedientsAnual;
	private int nombreInformesAnual;
	private float mitjaInformes;
	
	private Map<String, Expedient> actiu;
	private Map<String, Expedient> organitza;
	
	public Pacient(String tSI, String nomPacient, String numTelef, int nombreExpedientsAnual, int nombreInformesAnual,  float mitjaInformes) {
		super();
		this.TSI = tSI;
		this.nomPacient = nomPacient;
		this.numTelef = numTelef;
		this.nombreExpedientsAnual = nombreExpedientsAnual;
		this.nombreInformesAnual = nombreInformesAnual;
		this.mitjaInformes = mitjaInformes;
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
	
	
	
	
	
}
