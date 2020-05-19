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
	
	public ResultatProva introdueixResultat(boolean b, String resultat, String nomProva, String idInforme) throws Exception {
		ResultatProva r = new ResultatProva(resultat);
		this.consulta.put(r.getIdProva(), r);
		
		if(b) {
			if(gestiona.containsKey(idInforme)) {
				Informe i1 = gestiona.get(idInforme);
				i1.introdueixResultat(r,nomProva);
			}
			else {
				throw new Exception ("No existeix cap informe amb aquest identficiador!");
			}
		}
	
		return r;	
	}

	public void introdueixResultat(String idInforme, ResultatProva r, String nomProva) throws Exception {
		if(gestiona.containsKey(idInforme)) {
			Informe i = gestiona.get(idInforme);
			i.introdueixResultat(r, nomProva);
		}
		else {
			throw new Exception ("No existeix cap informe amb aquest identficiador!");
		}
		
		
	}

	public Informe iniciIntroduccioInforme(String observacions, Expedient e) {
		Informe i = new Informe(observacions, e, this);
		gestiona.put(i.getIdInforme(),i);
		
		return i;
		
	}
	
	
	
	
	
	
}
