package fenixLlatzer.models;

public class ProvaSugerida {

	//id
	private String idProvaSugerida;
	
	private ProvaDiagnostica provaDiagnostica;
	private ResultatProva resultat;
	
	
	public ProvaSugerida(ProvaDiagnostica provaDiagnostica) {
		super();
		this.idProvaSugerida = provaDiagnostica.getNomProva();
		this.provaDiagnostica = provaDiagnostica;
		this.resultat = null;
	}
	
	public void introdueixResultat(ResultatProva r) {
		this.resultat = r;
	}
	
	
	
	
}
