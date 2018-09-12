package application;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OkLytter implements EventHandler<ActionEvent> {
	 private TextField tekstfelt;
	 private SpillSpillet spillet;
	 private Stage primaryStage;

	public OkLytter(TextField tekstfelt, SpillSpillet spillet, Stage primaryStage) {
		this.tekstfelt = tekstfelt;
		this.spillet = spillet;
		this.primaryStage = primaryStage;
	}

	@Override
	public void handle(ActionEvent event) {
		int gjettetTall = konvertereTall.konverterTilTall(tekstfelt.getText());
		spillet.spill(gjettetTall);
		if(spillet.isVunnet() == true){
			if(spillet.getOmgang() < spillet.getHighscoreVerdi()){
				Stage vindu = new Stage();
				BorderPane layout = new BorderPane();
				Label infoTekst = new Label("Du brukte " +  spillet.getOmgang() + 
						" forsøk, som er ny highscore! Vil du legge til "
						+ "navnet ditt i highscorelista?");
				infoTekst.setPadding(new Insets(10,10,10,10));
				layout.setTop(infoTekst);
			
				Button ja = new Button("Ja");
				ja.setOnAction(new LeggTilHighscoreLytter(spillet, vindu));
				Button nei = new Button("Nei");
				nei.setOnAction(e -> vindu.close());
				HBox jaNeiBoks = new HBox();
				jaNeiBoks.getChildren().addAll(ja, nei);
				jaNeiBoks.setPadding(new Insets(10,10,10,10));
				jaNeiBoks.setSpacing(10);
				jaNeiBoks.setAlignment(Pos.CENTER);
				layout.setBottom(jaNeiBoks);
			
				Scene scenen = new Scene(layout);
				vindu.initOwner(primaryStage);
				vindu.initModality(Modality.APPLICATION_MODAL);
				vindu.setScene(scenen);
				vindu.sizeToScene();
				vindu.setTitle("Ny highscore");
				vindu.showAndWait();
				}
			Main.setCenterLabel("Trykk nytt spill for å spille på ny.");
		}else{
			Main.setCenterLabel("I ditt " + spillet.getOmgang() + " forsøk gjettet du et " + spillet.getLavereHoyere()+ 
					" tall enn mitt tall og ditt gjett er " + spillet.getLengerFraNarmere() + " enn sist gang");
		}
		
	}

}
