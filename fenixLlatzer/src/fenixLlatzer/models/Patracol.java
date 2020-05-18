package fenixLlatzer.models;

import java.util.HashMap;
import java.util.Map;


public class Patracol {
	
	
	//id
	private String idPatracol;
	
	private Pacient pacient;

	private String numTelef;
	private String nomPacient;
	
	private Map<String, Informe> gestiona;
	private Map<String, ResultatProva> consulta;
	
	
	//PRE: Ja s'ha comprovat al crear el nou patracol que no existeix cap igual amb patracol.id = <hospital, pacient>
	public Patracol(Pacient pacient) {
		super();
		this.idPatracol = pacient.getTSI();
		this.pacient = pacient;
		this.numTelef = pacient.getNumTelef();
		this.nomPacient = pacient.getNomPacient();
		
		this.gestiona = new HashMap<String, Informe>();
		this.consulta = new HashMap<String, ResultatProva>();
	}

	public String getIdPatracol() {
		return idPatracol;
	}
	
	public ResultatProva introdueixResultat(boolean b, String resultat, String nomProva, String idInforme) {
		ResultatProva r = new ResultatProva(resultat);
		this.consulta.put(r.getIdProva(), r);
		
		if(!b) {
			Informe i1 = gestiona.get(idInforme);
			i1.introdueixResultat(r,nomProva);
		}
	
		return r;	
	}

	public void introdueixResultat(String idInforme, ResultatProva r, String nomProva) {
		Informe i = gestiona.get(idInforme);
		i.introdueixResultat(r, nomProva);
		
		
	}

	public Informe iniciIntroduccioInforme(String observacions) {
		Informe i = new Informe(observacions);
		gestiona.put(i.getIdInforme(),i);
		
		return i;
		
	}
	
	
	
	
	
	
}
