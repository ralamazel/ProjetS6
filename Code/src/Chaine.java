import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Chaine {
	private final static ArrayList<Object> list = new ArrayList <>();
	
	
	public Chaine() throws FileNotFoundException  {
		String fileName = "chaines.csv";
		File file2 = new File(fileName);

		Scanner s = new Scanner(file2);
		s.nextLine();
		
		String data="";
		while(s.hasNext()) {
			
			data = s.nextLine();
			String[] values = data.split(";");
			//System.out.println(data);
			list.add(values[0]);
		}
		
	}
	protected QuantiteElement[] input;
	protected QuantiteElement[] output;
	protected int max;
	
	
	//abstract void fabriquer() {
	//}
	}


