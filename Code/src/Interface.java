import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Interface extends Application {

	public static void main(String[] args) {
		Application.launch(Interface.class, args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group root = new Group();
		Scene scene = new Scene(root, 1000, 750, Color.LIGHTBLUE);
		
		Menu menu = new Menu(3);   
		
		
		root.getChildren().add(menu);
		
		primaryStage.setTitle("Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
