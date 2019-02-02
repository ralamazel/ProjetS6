import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class InfosChainePropulsions extends Parent{
	
	private int labelPosY = 200;
	//private int labelPY = 400;

	public InfosChainePropulsions(String texte,ChainesProduction c,Stock s) throws IOException {
		
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		labelChaine.setTranslateX(100);
		
		this.getChildren().add(labelChaine);
		
		this.setTranslateX(50);
		
	}
	
	
}
