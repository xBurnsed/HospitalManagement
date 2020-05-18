package fenixLlatzer.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Informe {

	//id
	private static final AtomicInteger count = new AtomicInteger(0); 
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


	public void introdueixResultat(ResultatProva r, String nomProva) {
		ProvaSugerida ps = provaSugerida.get(nomProva);
		ps.introdueixResultat(r);
	}


	public void nouMedicamentRecomanat(Medicament m, String dosi, String pauta) {
		MedicamentRecomanat mr = new MedicamentRecomanat(m, dosi, pauta);
		medicamentRecomanat.put(m.getNomMedicament(), mr);
	}


	public void novaProvaSugerida(ProvaDiagnostica pd) {
		ProvaSugerida ps = new ProvaSugerida(pd);
		provaSugerida.put(pd.getNomProva(), ps);
	}
		
	
}
