import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class InfosChainePropulsions extends Parent{
	
	private int labelPosY = 200;
	//private int labelPY = 400;

	
	public InfosChainePropulsions(String texte,ChainesProduction c,Stock s) throws IOException {
		
		// impossible de mettre un autre textfield sans que �a foute la pr�sentation en l'air m�me un label c'est de la merde
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		
		/*Label label = new Label("Ce que vous voulez cr�er :");
		labelChaine.setTranslateY(labelPY);
		labelPY += 100;*/
		
		this.getChildren().add(labelChaine);
		
		this.setTranslateX(50);
		
	}
	
	
}
