import java.io.*;
import java.util.*;
public class main {
		public static void main (String[] args) throws FileNotFoundException {
			
			Stock s=new Stock();
			s.afficherStock();
			
			ChaineCoque c= new ChaineCoque(1);
			Element e=new Plastique();
			System.out.println(s.getQuantite("Plastique"));
			
			
			
		}
	
}
