package lyttere;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import application.*;

public class ButtonNyPersonLytter implements EventHandler<ActionEvent> {
	
	private Label fornavnLabel, etternavnLabel, fodselsarLabel;
	private TextField fornavnTekst, etternavnTekst, fodselsarTekst;
	private String fornavn, etternavn;
	private int fodselsar;
	
	private boolean OKTrykket = false;

	public boolean getOKTrykket() {
		return OKTrykket;
	}
	
	public ButtonNyPersonLytter() {
	} 
	
	public void nyPersonDialogvindu (){
		Stage vindu = new Stage();
		fornavnLabel = new Label ("Fornavn ");
		etternavnLabel = new Label ("Etternavn ");
		fodselsarLabel = new Label ("Fødselsår ");
		
		fornavnTekst = new TextField();
		etternavnTekst = new TextField ();
		fodselsarTekst = new TextField("ÅÅÅÅ");
		
		Button ok = new Button("OK");
		Button cancel = new Button("Cancel");
		
		ok.setOnAction(e -> {
			OKTrykket = true;
			vindu.hide();});
		
		cancel.setOnAction(e -> vindu.hide());
		
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(5,5,5,5));
		layout.setHgap(5);
		layout.setVgap(5);
		layout.add(fornavnLabel, 0, 0);
		layout.add(fornavnTekst, 1, 0);
		layout.add(etternavnLabel, 0, 1);
		layout.add(etternavnTekst, 1, 1);
		layout.add(fodselsarLabel, 0, 2);
		layout.add(fodselsarTekst, 1, 2);
		layout.add(ok, 0, 3);
		layout.add(cancel, 1, 3);
		
		Scene scenen = new Scene(layout, 265, 135);
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Ny Person");
		vindu.showAndWait();
		
		if (OKTrykket){
			fornavn = fornavnTekst.getText();
			etternavn = etternavnTekst.getText();
			fodselsar = Integer.parseInt(fodselsarTekst.getText());
			Main.leggTilIAllePersoner(fornavn, etternavn, fodselsar);
		}
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		nyPersonDialogvindu();
		
	}

}
