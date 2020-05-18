package fenixLlatzer.models;

public class MedicamentRecomanat {

	//TODO: check uniqueness
	
	//id
	private String idMedicament;
	
	private Medicament medicament;

	private String dosi;
	private String pauta;
	
	//PRE: Ja s'ha comprovat al crear el nou medicamentRecomanat que no existeix cap igual amb medicamentRecomanat.id = <medicament, informe>
	public MedicamentRecomanat(Medicament medicament, String dosi, String pauta) {
		super();
		this.idMedicament = medicament.getNomMedicament();
		this.medicament = medicament;
		this.dosi = dosi;
		this.pauta = pauta;
	}
	
	
	
}
