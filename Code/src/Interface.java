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
import javafx.scene.shape.Rectangle;
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
	
	public Scene accueil() throws IOException {
		
		
		int textFieldPosY = 200;
		int labelPosY = 200;
		
		
			Stock s=new Stock();
			ChainesProduction c= new ChainesProduction();
	
			Rectangle fond_menu = new Rectangle();
			fond_menu.setWidth(1000);
			fond_menu.setHeight(750);
			fond_menu.setFill(Color.WHITE);
			fond_menu.setStroke(Color.LIGHTGREY);
			fond_menu.setStrokeWidth(5);
			fond_menu.setArcHeight(30);
			fond_menu.setArcWidth(30);
	
			Label titre = new Label("Menu");
			titre.setStyle("-fx-font: 30 arial");
			titre.setTranslateX(462);
			titre.setTranslateY(50);
			
			Label labelChainePropulsions = new Label("Niveau d'activité de production de la Chaine 1 : ");
			labelChainePropulsions.setStyle("-fx-font: 15 arial");
			labelChainePropulsions.setTranslateY(labelPosY);
			labelChainePropulsions.setTranslateX(100);
			
			labelPosY += 150;
			
			Label labelChaineCoques = new Label("Niveau d'activité de production de la Chaine 2 : ");
			labelChaineCoques.setStyle("-fx-font: 15 arial");
			labelChaineCoques.setTranslateY(labelPosY);
			labelChaineCoques.setTranslateX(100);
			
			labelPosY += 150;
			
			Label labelChaineDrones = new Label("Niveau d'activité de production de la Chaine 3 : ");
			labelChaineDrones.setStyle("-fx-font: 15 arial");
			labelChaineDrones.setTranslateY(labelPosY);
			labelChaineDrones.setTranslateX(100);
			
			
			//Informations sur les propulsions
			TextField textFieldPropulsion = new TextField("0");
			textFieldPropulsion.setTranslateX(600);
			textFieldPropulsion.setTranslateY(textFieldPosY);
			textFieldPosY += 150;
			
			//Informations sur les coques
			TextField textFieldCoques = new TextField("0");
			textFieldCoques.setTranslateX(600);
			textFieldCoques.setTranslateY(textFieldPosY);
			textFieldPosY += 150;
			
			//Informations sur les drones
			TextField textFieldDrones = new TextField("0");
			textFieldDrones.setTranslateX(600);
			textFieldDrones.setTranslateY(textFieldPosY);
			
			Pane root = new Pane();
			root.setMinSize(750, 750);
			
			
			
			Button boutonReset = new Button("Reset");
			boutonReset.setStyle("-fx-font: 30 arial");
			boutonReset.setTranslateX(300);
			boutonReset.setTranslateY(650);
			boutonReset.setMinSize(100, 50);
			// rajouter le setOnAction reset
			
			//root.getChildren().add(boutonReset);
			
		
			Button boutonProduire = new Button("Produire");
			boutonProduire.setStyle("-fx-font: 30 arial");
			boutonProduire.setTranslateX(570);
			boutonProduire.setTranslateY(300);
			boutonProduire.setMinSize(100, 50);
			
			boutonProduire.setOnAction(e->
			{
				Integer niveauProdDrones = 0,niveauProdCoques = 0,niveauProdPropulsions= 0;
				
				 niveauProdDrones = Integer.valueOf(textFieldDrones.getText());
				 niveauProdCoques = Integer.valueOf(textFieldCoques.getText());
				 niveauProdPropulsions = Integer.valueOf(textFieldPropulsion.getText());
				
				 
				 if (niveauProdDrones != 0){
					 c.getChaine("Drones").fabriquer(niveauProdDrones, s);
				 }
		            
		         if(niveauProdCoques != 0) {
		        	 c.getChaine("Coques").fabriquer(niveauProdCoques, s);
		         }
		          
		         if(niveauProdPropulsions != 0){
		           c.getChaine("Propulsion").fabriquer(niveauProdPropulsions, s);
		         }
		              
		       try {
				s.ValiderLaProduction();
		       } catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		       }
		       
		      stage.setScene(resultats());
		       
			});

		root.getChildren().add(boutonProduire);
				
		root.getChildren().add(fond_menu);
		root.getChildren().add(titre);
	    
		root.getChildren().add(labelChainePropulsions);
		root.getChildren().add(textFieldPropulsion);
		
		root.getChildren().add(labelChaineCoques);
		root.getChildren().add(textFieldCoques);
		
		root.getChildren().add(labelChaineDrones);
		root.getChildren().add(textFieldDrones);
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
