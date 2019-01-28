import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Bouton extends Parent{
	protected String texte;
	private int positionX = 0;
	private int positionY = 0;
	
	Rectangle fond_bouton;
	Text texte_bouton;
	
	public Bouton(String texte, int posX, int posY) {
		this.texte = texte;
		this.positionX = posX;
		this.positionY = posY;
		
		fond_bouton = new Rectangle(100,50,Color.LIGHTBLUE);
		fond_bouton.setArcHeight(10);
		fond_bouton.setArcWidth(10);
		this.getChildren().add(fond_bouton);
		
		texte_bouton = new Text(texte);
		texte_bouton.setFont(new Font(25));
		this.getChildren().add(texte_bouton);
		
		this.setTranslateX(this.positionX);
		this.setTranslateY(this.positionY);
	}

}
