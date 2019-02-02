import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InfosChaineCoques extends Parent{
	
	
	private int labelPosY = 400;
	//private int labelPY = 400;


public InfosChaineCoques(String texte,ChainesProduction c,Stock s) throws IOException {
		
		// impossible de mettre un autre textfield sans que ça foute la présentation en l'air même un label c'est de la merde
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		
		/*Label label = new Label("Ce que vous voulez créer :");
		labelChaine.setTranslateY(labelPY);
		labelPY += 100;*/
		
		this.getChildren().add(labelChaine);
		
		this.setTranslateX(50);
		
	}
	

}
