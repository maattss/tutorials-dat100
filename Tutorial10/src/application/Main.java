package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lyttere.ButtonNyHendelseLytter;
import lyttere.ButtonNyPersonLytter;
import lyttere.MainPersonerInvitertLytter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	private static ArrayList<Person> allePersoner;
	private static ArrayList<Hendelse> alleHendelser;
	private static ListView<Hendelse> hendelsesliste;

	
	@Override
	public void start(Stage primaryStage) {
		try {
			allePersoner = new ArrayList<Person>();
			alleHendelser = new ArrayList<Hendelse>();
			testHendelse1();
			testHendelse2();
			guiOppsett(primaryStage);
		} catch(Exception e) { 
			e.printStackTrace();
		}
	}

	public void guiOppsett(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		
		ObservableList<Hendelse> observerbareHendelser = FXCollections.observableArrayList(alleHendelser);
		hendelsesliste = new ListView<>(observerbareHendelser);
		root.setTop(hendelsesliste);
		hendelsesliste.getSelectionModel().selectedItemProperty().addListener(new MainPersonerInvitertLytter());
		
		HBox hbox = new HBox();
		Button nyHendelse = new Button("Ny hendelse");
		nyHendelse.setOnAction(new ButtonNyHendelseLytter());
		
		Button nyPerson = new Button("Ny person");
		nyPerson.setOnAction(new ButtonNyPersonLytter());
		
		Button lagre = new Button("Lagre");
		lagre.setOnAction(e -> {
			//FileChooser filvelger = new FileChooser();
			//File fil = filvelger.showOpenDialog(null);
			try {
				FileOutputStream fos = new FileOutputStream("/Users/mats/Desktop/AlleHendelser.ser");
				ObjectOutputStream os = new ObjectOutputStream(fos);
				os.writeObject(alleHendelser);
				fos = new FileOutputStream("/Users/mats/Desktop/AllePersoner.ser");
				os = new ObjectOutputStream(fos);
				os.writeObject(allePersoner);
				os.close();
				fos.close();
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		Button Importer = new Button("Importer");
		Importer.setOnAction(e -> {
			try {
				FileInputStream fis = new FileInputStream("/Users/mats/Desktop/AlleHendelser.ser");
				ObjectInputStream is = new ObjectInputStream(fis);
				alleHendelser.clear();
				alleHendelser = (ArrayList<Hendelse>) is.readObject();
				fis = new FileInputStream("/Users/mats/Desktop/AllePersoner.ser");
				is = new ObjectInputStream(fis);
				allePersoner.clear();
				allePersoner = (ArrayList<Person>) is.readObject();
				is.close();
				fis.close();
			} catch (ClassNotFoundException | IOException e1) {
				e1.printStackTrace();
			}
		});

		hbox.setSpacing(10);
		hbox.getChildren().addAll(nyHendelse, nyPerson, lagre, Importer);
		
		root.setBottom(hbox);
		hbox.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 500, 460);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("Hendelsessystem");
		primaryStage.show();
	}
	
	public static void oppdatereHendelseliste(){
		ObservableList<Hendelse> nyObserverbar = FXCollections.observableArrayList(alleHendelser);
		if (!(hendelsesliste.getItems() == nyObserverbar)){
			hendelsesliste.setItems(nyObserverbar);
		}
	}
	
	public static ArrayList<Person> getPersoner() {
		return allePersoner;
	}

	public static ArrayList<Hendelse> getHendelser() {
		return alleHendelser;
	}
	
	public static void leggTilIAllePersoner(String fornavn, String etternavn, int fodselsar){
		Person P = new Person(fornavn, etternavn, fodselsar);
		allePersoner.add(P);
		System.out.println("Person lagt til. Fornavn: " + P.getFornavn() + ", Etternavn: " + 
		P.getEtternavn() + ", Fødselsår: " + P.getFodselsaar());
	}
	
	public static void leggTilIAlleHendelse(int startAar, int startMaaned, int startDag,
			int sluttAar, int sluttMaaned, int sluttDag, String beskrivelse){
		
		Hendelse H = new Hendelse();
		H.setBeskrivelse(beskrivelse);
		H.setStartDato(LocalDate.of(startAar, startMaaned, startDag));
		H.setSluttDato(LocalDate.of(sluttAar, sluttMaaned, sluttDag));
		alleHendelser.add(H);
		System.out.println("Hendelse lagt til. Beskrivelse: " + beskrivelse 
				+ " Startdato: " + H.getStartDato().toString() 
				+ " Sluttdato: " + H.getSluttDato().toString());
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void testHendelse1() {
		Hendelse hendelse1 = new Hendelse();
		hendelse1.setBeskrivelse("Testhendelse 1");
		hendelse1.setStartDato(LocalDate.of(2017, 01, 25));
		hendelse1.setSluttDato(LocalDate.of(2017, 02, 07));
			
		Person P1 = new Person("Mats", "Tyldum", 1994);
		allePersoner.add(P1);
		Person P2 = new Person("Lars", "Larsen", 1991);
		allePersoner.add(P2);
		
		hendelse1.leggTilPerson(P1);
		hendelse1.leggTilPerson(P2);
		
		alleHendelser.add(hendelse1);
	}
	
	public void testHendelse2() {
		Hendelse hendelse1 = new Hendelse();
		hendelse1.setBeskrivelse("Testhendelse 2");
		hendelse1.setStartDato(LocalDate.of(2017, 01, 25));
		hendelse1.setSluttDato(LocalDate.of(2017, 02, 07));
			
		Person P1 = new Person("Mats", "Tyldum", 1994);
		allePersoner.add(P1);
		Person P2 = new Person("Lars", "Larsen", 1991);
		allePersoner.add(P2);
		
		hendelse1.leggTilPerson(P1);
		hendelse1.leggTilPerson(P2);
		
		alleHendelser.add(hendelse1);
	}
}
