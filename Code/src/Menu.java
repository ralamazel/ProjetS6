import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Menu extends Parent{
	public Menu() {
		Rectangle fond_menu = new Rectangle();
		fond_menu.setWidth(400);
		fond_menu.setHeight(400);
		fond_menu.setFill(Color.WHITE);
		fond_menu.setStroke(Color.LIGHTGREY);
		fond_menu.setStrokeWidth(5);
		fond_menu.setArcHeight(30);
		fond_menu.setArcWidth(30);
        
        this.setTranslateX(200);
        this.setTranslateY(100);
        
        this.getChildren().add(fond_menu);
	}
}
