package fenixLlatzer.models;

public class MedicamentRecomanat {

	//TODO: check uniqueness
	
	//id
	private String idMedicament;
	
	private Medicament medicament;
	private Informe informe;

	private String dosi;
	private String pauta;
	
	//PRE: Ja s'ha comprovat al crear el nou medicamentRecomanat que no existeix cap igual amb medicamentRecomanat.id = <medicament, informe>
	public MedicamentRecomanat(Medicament medicament, Informe informe, String dosi, String pauta) {
		super();
		this.idMedicament = medicament.getNomMedicament() + informe.getIdInforme();
		this.medicament = medicament;
		this.informe = informe;
		this.dosi = dosi;
		this.pauta = pauta;
	}
	
	
	
}
