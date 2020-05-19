package fenixLlatzer.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultatProva {

	//id
	private static final AtomicInteger count = new AtomicInteger(1); 
	private String idProva;
	
	
	private LocalDate dataProva;
	private String descripcioResultat;
	
	public ResultatProva(String resultat) {
		super();
		this.idProva = String.valueOf(count.getAndIncrement());
		this.dataProva = LocalDate.now();
		this.descripcioResultat = resultat;
	}

	public String getIdProva() {
		return idProva;
	}	
	
	
	
	
	
	
}
