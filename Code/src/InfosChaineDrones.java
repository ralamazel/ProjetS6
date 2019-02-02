import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class InfosChaineDrones extends Parent{
	
	private int labelPosY = 500;
	//private int labelPY = 600;
	
	public InfosChaineDrones(String texte,ChainesProduction c,Stock s) throws IOException {
		
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		labelChaine.setTranslateX(100);
		
		this.getChildren().add(labelChaine);
		
		this.setTranslateX(50);
		
	}

}
