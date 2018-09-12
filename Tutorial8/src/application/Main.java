package application;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	private static Label centerLabel;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 575, 125);
			HBox topBox = new HBox(); 
			
			SpillSpillet spillet = new SpillSpillet();
			Label topLabel = new Label("Gjett et tall fra 1 til 1000:");
			TextField tekstfelt = new TextField();
			
			topBox.getChildren().addAll(topLabel, tekstfelt);
			topBox.setSpacing(10);
			topBox.setPadding(new Insets(10,10,10,10));
			topBox.setAlignment(Pos.CENTER);
			root.setTop(topBox);
			
			centerLabel = new Label("Skriv inn tall og trykk ok for å gjette");
			HBox centerBox = new HBox();
			centerBox.getChildren().add(centerLabel);
			centerBox.setPadding(new Insets(10,10,10,10));
			centerBox.setAlignment(Pos.CENTER);;
			root.setCenter(centerBox);
			
			Button ok = new Button("OK");
			ok.setOnAction(new OkLytter(tekstfelt, spillet, primaryStage));
			Button avslutt = new Button("Avslutt");
			avslutt.setOnAction(e -> primaryStage.close());
			Button highscore = new Button("Highscore");
			highscore.setOnAction(new VisHighscoreListeLytter(spillet, primaryStage));
			Button nyttSpillKnapp = new Button("Nytt spill");
			nyttSpillKnapp.setOnAction(e ->{
				spillet.nyRunde();
				centerLabel.setText("Skriv inn tall og trykk ok for å gjette");
				tekstfelt.clear();
			});
			
			HBox bottomBox = new HBox();
			bottomBox.getChildren().addAll(ok, avslutt, highscore, nyttSpillKnapp);
			bottomBox.setSpacing(10);
			bottomBox.setPadding(new Insets(10,10,10,10));
			bottomBox.setAlignment(Pos.CENTER);
			root.setBottom(bottomBox);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void setCenterLabel(String tekst) {
		centerLabel.setText(tekst);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
