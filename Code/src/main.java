import java.io.*;
public class main {
		public static void main (String[] args) throws IOException {
			
			Stock s=new Stock();
			s.afficherStock();
			ChainesProduction c= new ChainesProduction();
			
			c.getChaine("Drones").fabriquer(1, s);
			c.getChaine("Propulsion").fabriquer(5, s);
			c.getChaine("Coques").fabriquer(1200, s);
			
		
			s.afficherStock();
			s.Examiner();
			s.efficacite();
			s.ValiderLaProduction();
			
			s.reset();
		}
}