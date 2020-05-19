package fenixLlatzer.models;

public class Facultatiu {

	//id
	private String idFacultatiu;
	
	private String nomFactultatiu;
	public int nombreExpedientsAnuals;
	public int nombreInformesAnuals;
	public float mitjaInformes;
	
	
	public Facultatiu(String idFacultatiu, String nomFactultatiu) {
		super();
		this.idFacultatiu = idFacultatiu;
		this.nomFactultatiu = nomFactultatiu;
		this.nombreExpedientsAnuals = 0;
		this.nombreInformesAnuals = 0;
		this.mitjaInformes = 0;
	}


	public void iniciAny() {
		this.nombreExpedientsAnuals = 0;
		this.nombreInformesAnuals = 0;
		this.mitjaInformes = 0;
	}
		
		
}
