import java.io.*;
public class main {
		public static void main (String[] args) throws IOException {
			
			Stock s=new Stock();
			
			s.afficherStock();
			System.out.println("Efficacite : "+s.getEfficacite()+" euros \n");
			
			ChainesProduction c= new ChainesProduction();
			
			//c.getChaine("Drones").fabriquer(1, s);
			c.getChaine("Propulsion").fabriquer(500, s);
			c.getChaine("Coques").fabriquer(12, s);
			
		
			s.afficherStock();
			if (s.Examiner()) {
				System.out.println("Efficacite : "+s.getEfficacite()+" euros \n");
				s.ValiderLaProduction();
				
			}
			//s.reset();
			
		}
}