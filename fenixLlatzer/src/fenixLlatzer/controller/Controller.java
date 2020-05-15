package fenixLlatzer.controller;

import java.util.HashMap;
import java.util.Map;

import fenixLlatzer.models.Facultatiu;
import fenixLlatzer.models.Hospital;
import fenixLlatzer.models.Medicament;
import fenixLlatzer.models.Pacient;
import fenixLlatzer.models.ProvaDiagnostica;

public class Controller {

	private static Map<String, Hospital> repHospital = new HashMap<String, Hospital>();
	private static Map<String, Pacient> repPacient = new HashMap<String, Pacient>();
	private static Map<String, Medicament> repMedicament = new HashMap<String, Medicament>();
	private static Map<String, ProvaDiagnostica> repProvaDiagnostica = new HashMap<String, ProvaDiagnostica>();
	private static Map<String, Facultatiu> repFacultatiu = new HashMap<String, Facultatiu>();
	
	private Hospital hospitalDiferenciat;
	
	public Hospital getHospitalDiferenciat() {
		return this.hospitalDiferenciat;
	}
	
	public void addHospital(String idHospital) throws Exception {
		if(!repHospital.containsKey(idHospital)) {
			Hospital h = new Hospital(idHospital, 0, 0, 0, 0);
			Controller.repHospital.put(idHospital, h);
		}
		else {
			throw new Exception ("Ja existeix un hospital amb aquest id!");
		}
	}
	public void addPacient(String tsiPacient, String nomPacient, String numTelef) throws Exception {
		if(!repPacient.containsKey(tsiPacient)) {
			Pacient p = new Pacient(tsiPacient, nomPacient, numTelef, 0, 0, 0);
			Controller.repPacient.put(tsiPacient, p);
		}
		else {
			throw new Exception ("Ja existeix un pacient amb aquest id!");
		}
	}
	public void addMedicament(String idMedicament) throws Exception {
		if(!repMedicament.containsKey(idMedicament)) {
			Medicament m = new Medicament(idMedicament);
			Controller.repMedicament.put(idMedicament, m);
		}
		else {
			throw new Exception ("Ja existeix un medicament amb aquest id!");
		}
	}
	public void addProvaDiagnostica(String idProvaDiagnostica) throws Exception {
		if(!repProvaDiagnostica.containsKey(idProvaDiagnostica)) {
			ProvaDiagnostica pd = new ProvaDiagnostica(idProvaDiagnostica);
			Controller.repProvaDiagnostica.put(idProvaDiagnostica, pd);
		}
		else {
			throw new Exception ("Ja existeix una Prova Diagnostica amb aquest id!");
		}
	}
	public void addFacultatiu(String idFacultatiu, String nomFacultatiu) throws Exception {
		if(!repProvaDiagnostica.containsKey(idFacultatiu)) {
			Facultatiu fac = new Facultatiu(idFacultatiu, nomFacultatiu, 0, 0, 0);
			Controller.repFacultatiu.put(idFacultatiu, fac);
		}
		else {
			throw new Exception ("Ja existeix una Prova Diagnostica amb aquest id!");
		}
	}
	
	
	//CU InstalaLlatzer
	public void novaInstalacio(String nomHospital) throws Exception {
		if(!repHospital.containsKey(nomHospital)) {
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

		Pacient p = repPacient.get(tsi);
		if(p != null) {
			hospitalDiferenciat.nouPatracol(p);
		}
		else {
			throw new Exception("No s'ha pogut crear el nou Patracol!");
		}
	}

	//CU 
	/*public void introdueixResultat(String tsi, String idInforme, String nomProva, String resultat) {
		Pacient p = repPacient.get(tsi);
		ProvaDiagnostica pd = repProvaDiagnostica.get(nomProva);
		hospitalDiferenciat.
		if(p != null) {
			hospitalDiferenciat.nouPatracol(p);
	}*/

}
