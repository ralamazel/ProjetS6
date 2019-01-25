import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.*;
import java.io.*;

public class Stock {
	private final static HashMap<Element,Integer> hmap = new HashMap<>();
	
	public Stock() throws FileNotFoundException {
		String fileName = "elements.csv";
		File file = new File(fileName);
		int prixVente,prixAchat;
		
		Scanner s = new Scanner(file);
		
		s.nextLine();
		
		
		String data = "";
		while(s.hasNext()) {
			
			data = s.nextLine();
			String[] values = data.split(";");
			if(!values[4].equals("NA")) {
				 prixAchat=Integer.valueOf(values[4]);
			}else {
				prixAchat=-1;
			}
			Element e = new Element(values[0],values[1],values[3],prixAchat,Integer.valueOf(values[5])) {
			};
			hmap.put(e, Integer.valueOf(values[2]));
		}
		s.close();	
	      }
		

	
	public void afficherStock() {
		Set set = hmap.entrySet();
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
		Map.Entry mentry = (Map.Entry)iterator.next();
        System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
        System.out.println(mentry.getValue());
		}
	}
	}
