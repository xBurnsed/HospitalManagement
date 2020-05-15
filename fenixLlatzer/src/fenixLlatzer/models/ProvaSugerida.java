package fenixLlatzer.models;

public class ProvaSugerida {

	//id
	private String idProvaSugerida;
	
	private Informe informe;
	private ProvaDiagnostica provaDiagnostica;
	
	
	//PRE: Ja s'ha comprovat al crear el nou ProvaSugerida que no existeix cap igual amb ProvaSugerida.id = <informe, provaDiagnostica>
	public ProvaSugerida(Informe informe, ProvaDiagnostica provaDiagnostica) {
		super();
		this.idProvaSugerida = informe.getIdInforme() + provaDiagnostica.getNomProva();
		this.informe = informe;
		this.provaDiagnostica = provaDiagnostica;
	}
	
	
	
	
}
