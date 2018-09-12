package lyttere;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

import application.*;

public class MainPersonerInvitertLytter implements ChangeListener<Hendelse> {
	private Label invitertLabel;
	private Label ikkeInvitertLabel;
	private Label hendelseLabel;
	private Hendelse hendelsen;
	private ArrayList<Person> invitertePersoner;
	private ArrayList<Person> resterendePersoner;
	
	@Override
	public void changed(ObservableValue<? extends Hendelse> observable, 
			Hendelse oldValue, Hendelse newValue) {
		hendelsen = newValue;
		Stage vindu = new Stage();
		BorderPane layout = new BorderPane();
		Scene scenen = new Scene(layout, 600, 600);
		layout.setPadding(new Insets(10,10,10,10));
		hendelseLabel = new Label(hendelsen.toString());
		hendelseLabel.setPadding(new Insets(10,10,10,10));
		layout.setTop(hendelseLabel);
		
		invitertePersoner = hendelsen.getInvitertePersoner(); 
		resterendePersoner = new ArrayList<Person>();
		
		ObservableList<Person> obInvitertePersoner = FXCollections.observableArrayList(invitertePersoner);
		ListView<Person> personerInvitertList = new ListView<>(obInvitertePersoner);
		invitertLabel = new Label("Inviterte personer");		
		VBox invitertVBox = new VBox();
		invitertVBox.getChildren().addAll(invitertLabel, personerInvitertList);

		for(int i = 0; i< Main.getPersoner().size(); i++){
			Person person = Main.getPersoner().get(i);
			if(!invitertePersoner.contains(person)){
				resterendePersoner.add(person);
			}
		}
		ObservableList<Person> obIkkeInviterte = FXCollections.observableArrayList(resterendePersoner);
		ListView<Person> personerIkkeInvitertList = new ListView<Person>(obIkkeInviterte);
		ikkeInvitertLabel = new Label("Ikke inviterte personer");
		VBox ikkeInvitertVBox = new VBox();
		ikkeInvitertVBox.getChildren().addAll(ikkeInvitertLabel, personerIkkeInvitertList);
		
		VBox piler = new VBox(); 
		Button hoyre = new Button("--->");
		hoyre.setOnAction(e -> {
			Person person = personerInvitertList.getSelectionModel().getSelectedItem();
			invitertePersoner.remove(person);
			resterendePersoner.add(person);
			personerInvitertList.setItems(FXCollections.observableArrayList(invitertePersoner));
			personerIkkeInvitertList.setItems(FXCollections.observableArrayList(resterendePersoner));
			hendelsen.fjernPerson(person);
		});
		Button venstre = new Button("<---");
		venstre.setOnAction(e ->{
			Person person = personerIkkeInvitertList.getSelectionModel().getSelectedItem();
			resterendePersoner.remove(person);
			invitertePersoner.add(person);
			personerInvitertList.setItems(FXCollections.observableArrayList(invitertePersoner));
			personerIkkeInvitertList.setItems(FXCollections.observableArrayList(resterendePersoner));
			hendelsen.leggTilPerson(person);
		});
		piler.getChildren().addAll(hoyre, venstre);
		piler.setSpacing(10);
		piler.setAlignment(Pos.CENTER);
		
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(invitertVBox, piler, ikkeInvitertVBox);
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(10,10,10,10));
		layout.setCenter(hbox);
		
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> vindu.hide());
		layout.setBottom(tilbake);
		
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Personer invitert");
		vindu.showAndWait();
		
	}

}
