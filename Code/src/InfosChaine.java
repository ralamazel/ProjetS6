import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InfosChaine extends Parent{
	
	private static int labelPosY = 200;
	private static int labelPY = 400;
	private static int textFieldPosY = 200;
	private static int buttonPosY = 200;
	
	public InfosChaine(String texte,ChainesProduction c,Stock s) throws IOException {
		
		// impossible de mettre un autre textfield sans que ça foute la présentation en l'air même un label c'est de la merde
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		labelPosY += 100;
		
		/*Label label = new Label("Ce que vous voulez créer :");
		labelChaine.setTranslateY(labelPY);
		labelPY += 100;*/
		
		TextField textField = new TextField();
		textField.setTranslateX(500);
		textField.setTranslateY(textFieldPosY);
		textFieldPosY += 100;
		
	
		Button bouton = new Button("Valider");
		bouton.setTranslateX(800);
		bouton.setTranslateY(buttonPosY);
		buttonPosY += 100;
		
		bouton.setOnAction(e->
		{
			 Integer niveauProd = Integer.valueOf(textField.getText());
	            c.getChaine("Drones").fabriquer(niveauProd, s);
	            
	                    try {
							s.ValiderLaProduction();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                    this.setVisible(false);
		});
		s.ValiderLaProduction();
		
		
		this.getChildren().add(bouton);
		this.getChildren().add(labelChaine);
		this.getChildren().add(textField);
		
		this.setTranslateX(50);
		
	}
	
	
}
