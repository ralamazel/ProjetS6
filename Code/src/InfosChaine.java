import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class InfosChaine extends Parent{
	
	private static int labelPosY = 200;
	private static int textFieldPosY = 200;
	private static int buttonPosY = 200;
	
	public InfosChaine(String texte) {
		
		Label labelChaine = new Label(texte);
		labelChaine.setTranslateY(labelPosY);
		labelPosY += 100;
		
		TextField textField = new TextField();
		textField.setTranslateX(500);
		textField.setTranslateY(textFieldPosY);
		textFieldPosY += 100;
	
		Button bouton = new Button("Valider");
		bouton.setTranslateX(800);
		bouton.setTranslateY(buttonPosY);
		buttonPosY += 100;
		
		this.getChildren().add(bouton);
		this.getChildren().add(labelChaine);
		this.getChildren().add(textField);
		
		this.setTranslateX(50);
		
	}
	
	
}
