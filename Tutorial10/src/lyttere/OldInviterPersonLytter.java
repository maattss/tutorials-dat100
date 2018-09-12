package lyttere;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.TooManyListenersException;

import application.*;

public class OldInviterPersonLytter implements EventHandler<ActionEvent> {
	
	private ArrayList<Person> person;
	private ArrayList<Hendelse> hendelse;
	
	public OldInviterPersonLytter(ArrayList<Person> person, ArrayList<Hendelse> hendelse) {
		this.person = person;
		this.hendelse = hendelse;
	} 
	
	public void visInvitertePersoner(){
		Stage vindu = new Stage();
		BorderPane layout = new BorderPane();
		Scene scenen = new Scene(layout, 1000, 500);
		
		HBox hbox = new HBox();
		hbox.setSpacing(20);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		
		VBox vboxhendelser = new VBox();
		vboxhendelser.setSpacing(10);
		ObservableList<Hendelse> observerbareHendelser = FXCollections.observableArrayList(hendelse);
		ListView<Hendelse> hendelseliste = new ListView<>(observerbareHendelser);
		hendelseliste.setMinWidth(300);
		hendelseliste.setMinHeight(400);
		Label hendelseLabel = new Label("Hendelse");
		hendelseLabel.setMinHeight(30);
		vboxhendelser.getChildren().addAll(hendelseLabel, hendelseliste);
		
		ObservableList<Person> observerbarInviter = FXCollections.observableArrayList(person);
		ListView<Person> personerInvitertList = new ListView<>(observerbarInviter);
		personerInvitertList.setMinWidth(200);
		personerInvitertList.setMinHeight(400);
		VBox personerInvitert = new VBox();
		Label personerVenstreLabel = new Label("Personer ikke invitert til hendelsen");
		personerVenstreLabel.setMinHeight(30);
		personerInvitert.setSpacing(10);
		personerInvitert.getChildren().addAll(personerVenstreLabel, personerInvitertList);
		
		ObservableList<Person> observerbarePersoner = FXCollections.observableArrayList();
		ListView<Person> personerIkkeInvitertList = new ListView<>(observerbarePersoner);
		personerIkkeInvitertList.setMinWidth(200);
		personerIkkeInvitertList.setMinHeight(400);
		VBox personerIkkeInvitert = new VBox();
		Label personerHoyreLabel = new Label("Personer invitert til hendelsen");
		personerHoyreLabel.setMinHeight(30);
		personerIkkeInvitert.setSpacing(10);
		personerIkkeInvitert.getChildren().addAll(personerHoyreLabel, personerIkkeInvitertList);
		
		hendelseliste.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Hendelse>(){
			@Override
			public void changed(ObservableValue<? extends Hendelse> observable, Hendelse oldValue, Hendelse newValue) {
				ObservableList<Person> observerbarInviter = FXCollections.observableArrayList(newValue.getInvitertePersoner());
				ListView<Person> personerInvitertListe = new ListView<> (observerbarInviter);
				personerInvitertListe.setMinWidth(200);
				personerIkkeInvitert.getChildren().remove(1);
				personerIkkeInvitert.getChildren().add(personerInvitertListe);
				}});
	
		VBox piler = new VBox(); 
		Button hoyre = new Button("--->");
		Button venstre = new Button("<---");
		piler.getChildren().addAll(venstre, hoyre);
		piler.setSpacing(10);
		piler.setAlignment(Pos.CENTER);
		
		hbox.getChildren().addAll(vboxhendelser, personerIkkeInvitert, piler, personerInvitert);
		layout.setCenter(hbox);

		HBox tilbakeknapp = new HBox();
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> vindu.hide());
		tilbakeknapp.getChildren().add(tilbake);
		tilbakeknapp.setSpacing(10);
		tilbakeknapp.setPadding(new Insets(10,10,10,10));
		
		layout.setBottom(tilbake);
		
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Inviter personer");
		vindu.showAndWait();
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		visInvitertePersoner();
		
	}

}
