import java.io.IOException;
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
		Scene scene = accueil();
		primaryStage.setTitle("Menu");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public Scene accueil() {
		
		Pane root = new Pane();
		root.setMinSize(750, 750);
		
		Button boutonProduire = new Button("Produire");
		boutonProduire.setStyle("-fx-font: 30 arial");
		boutonProduire.setTranslateX(570);
		boutonProduire.setTranslateY(650);
		boutonProduire.setMinSize(100, 50);
		
		boutonProduire.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				stage.setScene(resultats());
			}
		});
		root.getChildren().add(boutonProduire);
		return new Scene(root);
	}
	
	
	protected Scene resultats() {
		VBox root = new VBox();
        Label userLabel = new Label("Insert the username:");
        final TextField userField = new TextField();
        Button createAccountButton = new Button("create account");
        createAccountButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                  System.out.println("Account for user " + userField.getText() + " was created succesfully");
            }
       });
        root.getChildren().addAll(userLabel,userField,createAccountButton);
        return new Scene(root);
    }		
}
