package fenixLlatzer.utils;


import fenixLlatzer.controller.Controller;



public class MockedData {

		
	public static void mockData(Controller c) throws Exception {

		mockHospitals(c);
		mockPacients(c);
		mockFacultatius(c);
		mockMedicaments(c);
		mockProvaDiagnostica(c);
	
	}
	
	private static void mockHospitals(Controller c) throws Exception {
		for(Integer i = 0; i<100; i++) {
			c.addHospital(i.toString());
		}
	}
	
	private static void mockPacients(Controller c) throws Exception {
		for(Integer i = 0; i<100; i++) {	
			c.addPacient(i.toString(),"FakeName Mock", "612345678");
		}
	}
	
	private static void mockFacultatius(Controller c) throws Exception {
		for(Integer i = 0; i<100; i++) {	
			c.addFacultatiu(i.toString(), "FakeName Mock");
		}
	}
	
	private static void mockMedicaments(Controller c) throws Exception {
		c.addMedicament("Ibuprofeno");
		c.addMedicament("Ibis");
		c.addMedicament("Ventolin");
		c.addMedicament("Almax");
		c.addMedicament("Diazepam");
		c.addMedicament("Aspirina");
		c.addMedicament("Omeprazol");
		c.addMedicament("Paracetamol");
		
	}
	
	private static void mockProvaDiagnostica(Controller c) throws Exception {
		c.addProvaDiagnostica("Anàlisis de sang");
		c.addProvaDiagnostica("Resonancia magnètica");
		c.addProvaDiagnostica("Ecocardioagrafia");
		c.addProvaDiagnostica("Audiometria");
		c.addProvaDiagnostica("Electrocardiograma");
		c.addProvaDiagnostica("Colonoscopia");
	}
}
