import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Interface extends Application {
	private Stage stage;
	public static void main(String[] args) {
		Application.launch(Interface.class, args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Group root = new Group();
		Scene scene = new Scene(root, 1000, 750, Color.LIGHTBLUE);
		
		Menu menu = new Menu(3);   
		
		
		root.getChildren().add(menu);
		
		primaryStage.setTitle("Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

}
