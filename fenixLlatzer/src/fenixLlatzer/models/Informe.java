package fenixLlatzer.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Informe {

	//id
	private String idInforme;
	
	private String observacions;
	private Date dataVisita;
	
	private Map<String, Expedient> agrupat;
	private Map<String, ProvaSugerida> provaSugerida;
	private Map<String, MedicamentRecomanat> medicamentRecomanat;
	private Map<String, Patracol> gestiona;
	
	
	public Informe(String idInforme, String observacions, Date dataVisita) {
		super();
		this.idInforme = idInforme;
		this.observacions = observacions;
		this.dataVisita = dataVisita;
		this.agrupat = new HashMap<String, Expedient>();
		this.provaSugerida = new HashMap<String, ProvaSugerida>();
		this.medicamentRecomanat = new HashMap<String, MedicamentRecomanat>();
		this.gestiona = new HashMap<String, Patracol>();
	}


	public String getIdInforme() {
		return idInforme;
	}


	public void introdueixResultat(ResultatProva r, String nomProva) {
		ProvaSugerida ps = provaSugerida.get(nomProva);
		ps.introdueixResultat(r);
	}

	
	
}
