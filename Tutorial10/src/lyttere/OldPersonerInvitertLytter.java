package lyttere;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

import application.*;

public class OldPersonerInvitertLytter implements ChangeListener<Hendelse> {
	private Label invitertePersonerLabel;
	private ArrayList<Person> invitertePersoner;
	
	@Override
	public void changed(ObservableValue<? extends Hendelse> observable, 
			Hendelse oldValue, Hendelse newValue) {
		Stage vindu = new Stage();
		BorderPane layout = new BorderPane();
		Scene scenen = new Scene(layout, 265, 135);
		layout.setPadding(new Insets(5,5,5,5));
		
		invitertePersoner = newValue.getInvitertePersoner(); 
		VBox vbox = new VBox();
		for (Person personen: invitertePersoner){
			invitertePersonerLabel = new Label(personen.toString());
			vbox.getChildren().add(invitertePersonerLabel);
		}
		layout.setTop(vbox);
		
		Button tilbake = new Button("Tilbake");
		tilbake.setOnAction(e -> vindu.hide());
		layout.setBottom(tilbake);
		
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Personer invitert");
		vindu.showAndWait();
		
	}

}
