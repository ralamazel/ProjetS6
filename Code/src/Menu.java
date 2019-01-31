import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Menu extends Parent{
	public Menu(int NbChaines) {
		Rectangle fond_menu = new Rectangle();
		fond_menu.setWidth(1000);
		fond_menu.setHeight(1000);
		fond_menu.setFill(Color.WHITE);
		fond_menu.setStroke(Color.LIGHTGREY);
		fond_menu.setStrokeWidth(5);
		fond_menu.setArcHeight(30);
		fond_menu.setArcWidth(30);

		Label titre = new Label("Menu");
		titre.setStyle("-fx-font: 30 arial");
		titre.setTranslateX(462);
		titre.setTranslateY(100);
		
		this.getChildren().add(fond_menu);
        this.getChildren().add(titre);
		
		for(int i = 0 ; i < NbChaines ; i++) {
			InfosChaine infochaine = new InfosChaine("Niveau d'activité de production de la Chaine " + (i+1) + " :");
			infochaine.setStyle("-fx-font: 15 arial");
			this.getChildren().add(infochaine);
		}


	}
}
