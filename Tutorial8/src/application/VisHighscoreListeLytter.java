package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VisHighscoreListeLytter implements EventHandler<ActionEvent> {
	private SpillSpillet spillet;
	private Stage forrigeStage;
	private ArrayList<HighscoreSpiller> highscoreListe;

	public VisHighscoreListeLytter(SpillSpillet spillet, Stage forrigeStage) {
		this.spillet = spillet;
		this.forrigeStage = forrigeStage;
		highscoreListe = spillet.getHighscore();
	}

	@Override
	public void handle(ActionEvent event) {
		highscoreListe = spillet.getHighscore();
		Collections.sort(highscoreListe, new Comparator<HighscoreSpiller>() {
		        @Override public int compare(HighscoreSpiller p1, HighscoreSpiller p2) {
		            return p1.getHighscore() - p2.getHighscore(); // Ascending
		        }
		});
		Stage vindu = new Stage();
		BorderPane layout = new BorderPane();
		layout.setPadding(new Insets(10,10,10,10));
		ListView<HighscoreSpiller> highScoreListView = new ListView<HighscoreSpiller>
		(FXCollections.observableArrayList(highscoreListe));
		layout.setTop(highScoreListView);
		
		HBox bottomBox = new HBox();
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> vindu.close());
		Button lagre = new Button("Lagre");
		lagre.setOnAction(e->{
			try {
				FileWriter writer = new FileWriter("/Users/mats/Desktop/HighscoreListe.txt");
				for(HighscoreSpiller spiller: highscoreListe){
					writer.write(spiller.getNavn() + "-" + spiller.getHighscore() + "\n");
				}
				writer.close();
			} catch (IOException exception) {
				System.err.println("Problem med lagring av fil.");
			}
			
		});
		Button lastInn = new Button("Last inn");	
		lastInn.setOnAction(e->{
			File minFil = new File("/Users/mats/Desktop/HighscoreListe.txt"); 
			try (Scanner leser = new Scanner(minFil)){
				while(leser.hasNextLine() == true){
					String line = leser.nextLine();
					String [] split = line.split("-");
					String navn = split[0];
					int highscore;
					try {
						highscore = Integer.parseInt(split[1]);
						HighscoreSpiller spiller = new HighscoreSpiller(navn, highscore);
						highscoreListe.add(spiller);
					} catch (NumberFormatException e1) {
						System.err.println("Feil med konvertering av highscore til int");
						e1.printStackTrace();
					}
					
				}
			} catch (FileNotFoundException exception) {
				System.err.println("Problem med innlasting av fil.");
			}
		});
		
		bottomBox.getChildren().addAll(tilbake, lagre, lastInn);
		bottomBox.setSpacing(10);
		bottomBox.setPadding(new Insets(10,0,0,0));
		bottomBox.setAlignment(Pos.CENTER);
		layout.setBottom(bottomBox);
		
		
		Scene scenen = new Scene(layout);
		vindu.initOwner(forrigeStage);
		vindu.initModality(Modality.APPLICATION_MODAL);
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Highscore");
		vindu.showAndWait();
		
	}

}
