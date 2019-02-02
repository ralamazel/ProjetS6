import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Menu extends Parent{
	
	private int textFieldPosY = 200;
	
	public Menu(int NbChaines) throws IOException {
		Stock s=new Stock();
		ChainesProduction c= new ChainesProduction();

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
		titre.setTranslateY(50);
		
		Button bouton = new Button("Produire");
		bouton.setStyle("-fx-font: 30 arial");
		bouton.setTranslateX(429);
		bouton.setTranslateY(650);
		bouton.setMinSize(100, 50);
		
		//Informations sur les propulsions
		TextField textFieldPropulsion = new TextField();
		textFieldPropulsion.setTranslateX(600);
		textFieldPropulsion.setTranslateY(textFieldPosY);
		textFieldPosY += 150;
		
		//Informations sur les coques
		TextField textFieldCoques = new TextField();
		textFieldCoques.setTranslateX(600);
		textFieldCoques.setTranslateY(textFieldPosY);
		textFieldPosY += 150;
		
		//Informations sur les drones
		TextField textFieldDrones = new TextField();
		textFieldDrones.setTranslateX(600);
		textFieldDrones.setTranslateY(textFieldPosY);
		
		bouton.setOnAction(e->
		{
			 Integer niveauProd = Integer.valueOf(textFieldDrones.getText());
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
		
		
		InfosChainePropulsions infochaine1 = new InfosChainePropulsions("Niveau d'activité de production de la Chaine 1 : ",c,s);
		infochaine1.setStyle("-fx-font: 15 arial");
		
		InfosChaineCoques infochaine2 = new InfosChaineCoques("Niveau d'activité de production de la Chaine 2 : ", c, s);
		infochaine2.setStyle("-fx-font: 15 arial");
		
		InfosChaineDrones infochaine3 = new InfosChaineDrones("Niveau d'activité de production de la Chaine 3 : ", c, s);
		infochaine3.setStyle("-fx-font: 15 arial");
		
		
		this.getChildren().add(fond_menu);
        this.getChildren().add(titre);
        
		this.getChildren().add(infochaine1);
		this.getChildren().add(textFieldPropulsion);
		
		this.getChildren().add(infochaine2);
		this.getChildren().add(textFieldCoques);
		
		this.getChildren().add(infochaine3);
		this.getChildren().add(textFieldDrones);
		
		this.getChildren().add(bouton);
		
		
		
		
		
		


	}
}
