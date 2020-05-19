package fenixLlatzer.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Informe {

	//id
	private static final AtomicInteger count = new AtomicInteger(1); 
	private String idInforme;
	
	private String observacions;
	private LocalDate dataVisita;
	
	private Map<String, ProvaSugerida> provaSugerida;
	private Map<String, MedicamentRecomanat> medicamentRecomanat;

	
	
	public Informe(String observacions) {
		super();
		this.idInforme = String.valueOf(count.getAndIncrement());
		this.observacions = observacions;
		this.dataVisita = LocalDate.now();
		this.provaSugerida = new HashMap<String, ProvaSugerida>();
		this.medicamentRecomanat = new HashMap<String, MedicamentRecomanat>();

	}


	public String getIdInforme() {
		return idInforme;
	}


	public void introdueixResultat(ResultatProva r, String nomProva) throws Exception {
		if(provaSugerida.containsKey(nomProva)) {
			ProvaSugerida ps = provaSugerida.get(nomProva);
			ps.introdueixResultat(r);
		}
		else {
			throw new Exception ("No existeix cap prova sugerida amb aquest identificador!");
		}
	}


	public void nouMedicamentRecomanat(Medicament m, String dosi, String pauta) throws Exception {
		if(!medicamentRecomanat.containsKey(m.getNomMedicament())) {
			MedicamentRecomanat mr = new MedicamentRecomanat(m, dosi, pauta);
			medicamentRecomanat.put(m.getNomMedicament(), mr);
		}
		else {
			throw new Exception("Ja existeix un medicament recomanat amb aquest identificador!");
		}
	}


	public void novaProvaSugerida(ProvaDiagnostica pd) throws Exception {
		if(!provaSugerida.containsKey(pd.getNomProva())) {
			ProvaSugerida ps = new ProvaSugerida(pd);
			provaSugerida.put(pd.getNomProva(), ps);
		}
		else {
			throw new Exception("Ja existeix una prova sugerida amb aquest identificador!");
		}
	}
		
	
}
