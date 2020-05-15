package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;


public class Patracol {
	
	
	//id
	private String idPatracol;
	
	private Pacient pacient;
	private Map<String, Informe> gestiona;

	private String numTelef;
	private String nomPacient;
	
	//PRE: Ja s'ha comprovat al crear el nou patracol que no existeix cap igual amb patracol.id = <hospital, pacient>
	public Patracol(Pacient pacient) {
		super();
		this.idPatracol = pacient.getTSI();
		this.pacient = pacient;
		this.numTelef = pacient.getNumTelef();
		this.nomPacient = pacient.getNomPacient();
		
		this.gestiona = new HashMap<String, Informe>();
	}

	public String getIdPatracol() {
		return idPatracol;
	}
	
	
	
	
	
	
}
