package fenixLlatzer.models;

public class Pacient {

	//id
	private String TSI;
	
	private String nomPacient;
	private String numTelef;
	public int nombreExpedientsAnual;
	public int nombreInformesAnual;
	public float mitjaInformes;
	
		public Pacient(String tSI, String nomPacient, String numTelef) {
		super();
		this.TSI = tSI;
		this.nomPacient = nomPacient;
		this.numTelef = numTelef;
		this.nombreExpedientsAnual = 0;
		this.nombreInformesAnual = 0;
		this.mitjaInformes = 0;
	}

	public String getTSI() {
		return TSI;
	}

	public String getNomPacient() {
		return nomPacient;
	}

	public String getNumTelef() {
		return numTelef;
	}

	public void iniciAny() {
		this.nombreExpedientsAnual = 0;
		this.nombreInformesAnual = 0;
		this.mitjaInformes = 0;
	}

	
}
