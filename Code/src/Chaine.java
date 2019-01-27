import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public  class Chaine extends ChainesProduction{
	private String code;
	protected QuantiteElement[] input;
	protected String codeElementCreer ;
	private int quantite;
	
	
	public Chaine(String code, QuantiteElement[] q, String codeElementCreer, int quantite) throws FileNotFoundException  {
		this.code=code;
		this.input=q;
		this.codeElementCreer=codeElementCreer;
		this.quantite=quantite;
	}
	
	
	
	//abstract void fabriquer() {
	//}
	}


