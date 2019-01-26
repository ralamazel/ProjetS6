import java.io.*;
import java.util.*;
public class main {
		public static void main (String[] args) throws FileNotFoundException {
			
			Stock s=new Stock();
			s.afficherStock();
			
			new ChaineCoque(1);
			
			System.out.println(s.getQuantite("Plastique"));
			
			s.ChaineCoque(285);
			
			s.afficherStock();
			s.Examiner();
			s.efficacite();
		
			
			
			
			
		}
	
}
