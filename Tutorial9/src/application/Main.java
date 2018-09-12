package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import ruter.Gang;
import ruter.Illusjon;
import ruter.LabyrintRute;
import ruter.Utgang;
import ruter.Vegg;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class Main extends Application {
	private LabyrintRute [][] spillbrett;
	private int bredde;
	private int hoyde;
	private Spiller spilleren;
	private GridPane brett;
	private static Label scoreLabel;
	private static int antallflytt = 0;

	public static void leggTilantallflytt() {
		antallflytt++;
		scoreLabel.setText(Integer.toString(antallflytt));
		
	}
	
	
	public static int getAntallflytt() {
		return antallflytt;
	}


	public void settOppSpillet(){
		//Forhåndsdefinert fil
		//File fil = new File("/Users/mats/Desktop/testlabyrint_egen.txt");
		
		FileChooser filvelger = new FileChooser();
		File fil = filvelger.showOpenDialog(null);
		if(fil != null){
			try(Scanner filleser = new Scanner(fil)){
				bredde = filleser.nextInt();
				hoyde = filleser.nextInt();
				filleser.nextLine();
				spillbrett = new LabyrintRute [bredde][hoyde];
				for(int y = 0; y < hoyde; y++){
					String rad = filleser.nextLine();
					for(int x = 0; x < bredde; x++){
						char tegn = rad.charAt(x);
						switch(tegn){
						//Vegg
							case '#': spillbrett [x][y] = new Vegg(x, y);
							break;
						//Utgang
							case '-': spillbrett [x][y] = new Utgang(x, y);
							break; 
						//Start
							case '*': spillbrett [x][y] = new Gang(x, y);
								  spilleren = new Spiller(x, y);
							break;
						//Gang
							case ' ': spillbrett[x][y] = new Gang(x, y);
							break;
						//Illusjon
							case '$': spillbrett[x][y] = new Illusjon(x, y);
							break;
						}
					}
				}
				oppdagRuter();
			}catch(FileNotFoundException e){
				System.err.print("Feil med innlesing av fil");
			}
		}else{
			System.exit(1);
		}
		
	}
	
	public void flyttSpillerBrikke(int deltaX, int deltaY){
		int x = spilleren.getxKoordinat();
		int y = spilleren.getyKoordinat();
		int nyX = x + deltaX;
		int nyY = y + deltaY;
		LabyrintRute rute = spillbrett[nyX][nyY];
		rute.flyttTilRute(spilleren);
		
		GridPane.setColumnIndex(spilleren.getUtseende(), spilleren.getxKoordinat());
		GridPane.setRowIndex(spilleren.getUtseende(), spilleren.getyKoordinat());
		oppdagRuter();

		//Alternativ:
		//root.add(spilleren.getUtseende(),spilleren.getxKoordinat(), spilleren.getyKoordinat());
		
		
	}
	public void oppdagRuter() {
		int x = spilleren.getxKoordinat();
		int y = spilleren.getyKoordinat();
	
		spillbrett[x][y].settOppdaget(true);
		spillbrett[x-1][y].settOppdaget(true);
		spillbrett[x+1][y].settOppdaget(true);
		spillbrett[x][y-1].settOppdaget(true);
		spillbrett[x-1][y-1].settOppdaget(true);
		spillbrett[x+1][y-1].settOppdaget(true);
		spillbrett[x][y+1].settOppdaget(true);
		spillbrett[x-1][y+1].settOppdaget(true);
		spillbrett[x+1][y+1].settOppdaget(true);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			settOppSpillet();
			BorderPane root = new BorderPane();
			VBox spillet = new VBox();
			brett = new GridPane();
			HBox score = new HBox ();
			scoreLabel = new Label(Integer.toString(antallflytt));
			scoreLabel.setFont(Font.font("SansSerif", 40));
			scoreLabel.setTextFill(Color.BLACK);
			scoreLabel.setMaxWidth(Double.MAX_VALUE);
			scoreLabel.setAlignment(Pos.CENTER);
			scoreLabel.setBackground(new Background(new BackgroundFill(Color.GAINSBORO,CornerRadii.EMPTY, Insets.EMPTY)));
			score.getChildren().add(scoreLabel);
			score.setPadding(new Insets(10,10,10,10));
			
			for(int y = 0; y < hoyde; y++){
				for(int x = 0; x < bredde; x++){
					brett.add(spillbrett[x][y].getUtseende(), x, y);
				}
			}
			brett.add(spilleren.getUtseende(),spilleren.getxKoordinat(), spilleren.getyKoordinat());
			root.setCenter(brett);
			root.setTop(scoreLabel);
			
			Scene scenen = new Scene(root);
			scenen.setOnKeyPressed(e ->{
				KeyCode tast = e.getCode();
				if(tast == KeyCode.UP){
					flyttSpillerBrikke(0, -1);
				}else if(tast == KeyCode.DOWN){
					flyttSpillerBrikke(0, 1);
				}else if(tast == KeyCode.LEFT){
					flyttSpillerBrikke(-1, 0);
				}else if(tast == KeyCode.RIGHT){
					flyttSpillerBrikke(1, 0);
				}
			});
			
			scenen.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scenen);
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
