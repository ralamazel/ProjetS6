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
		Scene scene = new Scene(root, 800, 600, Color.LIGHTBLUE);
		
		Menu menu = new Menu();   
		root.getChildren().add(menu);
		
		primaryStage.setTitle("ProjetS6");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
