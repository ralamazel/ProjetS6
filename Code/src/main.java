import java.io.*;
import java.util.*;
public class main {
		public static void main (String[] args) throws FileNotFoundException {
			String fileName = "elements.csv";
			File file = new File(fileName);
			
			Scanner s = new Scanner(file);
			
			s.nextLine();
			HashMap<String,String> hmap = new HashMap<String,String>();
			
			
			String data = "";
			while(s.hasNext()) {
				
				data = s.nextLine();
				String[] values = data.split(";");
				hmap.put(values[1], values[2]);
			}
					Set set = hmap.entrySet();
					Iterator iterator = set.iterator();
					while(iterator.hasNext()) {
					Map.Entry mentry = (Map.Entry)iterator.next();
		            System.out.print("key is: "+ mentry.getKey() + " & Value is: ");
		            System.out.println(mentry.getValue());
		      }
			
				
			s.close();
			
			
			
		}
	
}
