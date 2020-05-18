package fenixLlatzer.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import fenixLlatzer.models.Expedient;
import fenixLlatzer.models.Facultatiu;
import fenixLlatzer.models.Hospital;
import fenixLlatzer.models.Informe;
import fenixLlatzer.models.Medicament;
import fenixLlatzer.models.Pacient;
import fenixLlatzer.models.ProvaDiagnostica;
import fenixLlatzer.models.ResultatProva;

public class Controller {

	private static Map<String, Hospital> repHospital = new HashMap<String, Hospital>();
	private static Map<String, Pacient> repPacient = new HashMap<String, Pacient>();
	private static Map<String, Medicament> repMedicament = new HashMap<String, Medicament>();
	private static Map<String, ProvaDiagnostica> repProvaDiagnostica = new HashMap<String, ProvaDiagnostica>();
	private static Map<String, Facultatiu> repFacultatiu = new HashMap<String, Facultatiu>();
	
	private Hospital hospitalDiferenciat;
	private Hospital hospitalDiferenciatNouAny;
	
	private Informe informeDiferenciat;
	
	public Hospital getHospitalDiferenciat() {
		return this.hospitalDiferenciat;
	}
	
	//ADD MOCKED DATA
	public void addHospital(String idHospital) {
		if(!repHospital.containsKey(idHospital)) {
			Hospital h = new Hospital(idHospital, 0, 0, 0, 0);
			Controller.repHospital.put(idHospital, h);
		}
	}
	public void addPacient(String tsiPacient, String nomPacient, String numTelef){
		if(!repPacient.containsKey(tsiPacient)) {
			Pacient p = new Pacient(tsiPacient, nomPacient, numTelef);
			Controller.repPacient.put(tsiPacient, p);
		}
	}
	public void addMedicament(String idMedicament) {
		if(!repMedicament.containsKey(idMedicament)) {
			Medicament m = new Medicament(idMedicament);
			Controller.repMedicament.put(idMedicament, m);
		}
	}
	public void addProvaDiagnostica(String idProvaDiagnostica)  {
		if(!repProvaDiagnostica.containsKey(idProvaDiagnostica)) {
			ProvaDiagnostica pd = new ProvaDiagnostica(idProvaDiagnostica);
			Controller.repProvaDiagnostica.put(idProvaDiagnostica, pd);
		}

	}
	public void addFacultatiu(String idFacultatiu, String nomFacultatiu){
		if(!repProvaDiagnostica.containsKey(idFacultatiu)) {
			Facultatiu fac = new Facultatiu(idFacultatiu, nomFacultatiu);
			Controller.repFacultatiu.put(idFacultatiu, fac);
		}
	}
	
	
	//CU InstalaLlatzer
	public void novaInstalacio(String nomHospital) throws Exception {
		if(repHospital.containsKey(nomHospital)) {
			Hospital h = repHospital.get(nomHospital);
			h.novaInstalacio();
			this.hospitalDiferenciat = h;
		}
		else {
			throw new Exception("No s'ha trobat cap hospital amb aquest identificador!");
		}
	}
	
	//CU AltaPacient
	public void nouPatracol(String tsi) throws Exception {
		if(repPacient.containsKey(tsi)) {
			Pacient p = repPacient.get(tsi);
			hospitalDiferenciat.nouPatracol(p);
		}
		else {
			throw new Exception("No existeix cap pacient amb aquest TSI!");
		}
	}

	//CU RealitzarProva
	public void introdueixResultat(String TSI, String nomHospital, String idInforme, String nomProva, String resultat) {
			
		boolean b = nomHospital == null || nomHospital.isEmpty();
				
		ResultatProva r = hospitalDiferenciat.introdueixResultat(b, TSI, resultat, nomProva, idInforme);
		
		if(b) {
			Hospital h = repHospital.get(nomHospital);
			h.introdueixResultat(TSI, idInforme, r, nomProva);
		}
		
			
	}
	
	//CU TancarExpedient
	public void tancar(String idExpedient) throws Exception {
		this.hospitalDiferenciat.tancar(idExpedient);		
	}
	
	
	//CU nouAny
	public void iniciAny() {
		Controller.repHospital.forEach((k,v) -> v.iniciAny());
		Controller.repPacient.forEach((k,v) -> v.iniciAny());
		Controller.repFacultatiu.forEach((k,v) -> v.iniciAny());
	}
	
	public void actualitzaHospital(String nomHospital) throws Exception {
		if(repHospital.containsKey(nomHospital))
			this.hospitalDiferenciatNouAny = repHospital.get(nomHospital);
		else
			throw new Exception("No existeix cap hospital amb aquest id!");
		
	}
	
	public void actualitzaFacultatiu(String idFacultatiu) throws Exception {
		if(repFacultatiu.containsKey(idFacultatiu)) {
			Facultatiu f = Controller.repFacultatiu.get(idFacultatiu);
			this.hospitalDiferenciatNouAny.actualitzaFacultatiu(idFacultatiu, f);
		}
		else {
			throw new Exception ("No existeix cap facultatiu amb aquest id!");
		}
	}
	
	public void fiAny() {
		this.hospitalDiferenciatNouAny = null;
	}
	
	
	//CU IntroduirInforme
	public void iniciIntroduccioInforme(String idFacultatiu, String TSI, String idExpedient, String patologia, String observacions) throws Exception {
		if(repFacultatiu.containsKey(idFacultatiu)) {
			Facultatiu f = repFacultatiu.get(idFacultatiu);
			if(repPacient.containsKey(TSI)) {
				Pacient p = repPacient.get(TSI);
				informeDiferenciat = hospitalDiferenciat.iniciIntroduccioInforme(f,p, idExpedient, patologia,observacions);
				
			}
			else {
				throw new Exception ("No s'ha trobat cap Pacient amb aquest ID!");
			}
			
		}
		else {
			throw new Exception ("No s'ha trobat cap Facultatiu amb aquest ID!");
		}
	}
	
	public void nouMedicamentRecomanat(String nomMedicament, String dosi, String pauta) throws Exception {
		if(repMedicament.containsKey(nomMedicament)) {
			Medicament m = repMedicament.get(nomMedicament);
			informeDiferenciat.nouMedicamentRecomanat(m,dosi,pauta);
		}
		else {
			throw new Exception ("No s'ha trobat cap Medicament amb aquest ID!");
		}
	}
	
	public void novaProvaSugerida(String nomProva) throws Exception {
		if(repProvaDiagnostica.containsKey(nomProva)) {
			ProvaDiagnostica pd = repProvaDiagnostica.get(nomProva);
			informeDiferenciat.novaProvaSugerida(pd);
		}
		else {
			throw new Exception ("No s'ha trobat cap Prova Diagnòstica amb aquest ID!");
		}
	}
	
	public void fiIntroduirInforme() {
		informeDiferenciat = null;
	}
	

}
