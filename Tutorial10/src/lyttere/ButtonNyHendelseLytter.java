package lyttere;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonNyHendelseLytter implements EventHandler<ActionEvent> {
	private Label startdatoLabel, sluttdatoLabel, beskrivelseLabel;
	private TextField startdatoTekst, sluttdatoTekst, beskrivelseTekst;
	private Button ok, cancel;
	private boolean OKTrykket;

	public boolean getOKTrykket() {
		return OKTrykket;
	}
	
	public ButtonNyHendelseLytter() {
	} 
	
	public void nyHendelseDialogvindu (){
		Stage vindu = new Stage();
		startdatoLabel = new Label("Startdato ");
		sluttdatoLabel = new Label("Sluttdato ");
		beskrivelseLabel = new Label ("Beskrivelse ");
		
		startdatoTekst = new TextField("ÅÅÅÅ-MM-DD");
		sluttdatoTekst = new TextField ("ÅÅÅÅ-MM-DD");
		beskrivelseTekst = new TextField();
		
		ok = new Button("OK");
		cancel = new Button("Cancel");
		
		ok.setOnAction(e -> {
			OKTrykket = true;
			vindu.hide();
		});
		
		cancel.setOnAction(e -> vindu.hide());
		
		GridPane layout = new GridPane();
		layout.setHgap(5);
		layout.setVgap(5);
		layout.setPadding(new Insets(5,5,5,5));
		layout.add(startdatoLabel, 0, 0);
		layout.add(startdatoTekst, 1, 0);
		layout.add(sluttdatoLabel, 0, 1); 
		layout.add(sluttdatoTekst, 1, 1);
		layout.add(beskrivelseLabel, 0, 2);
		layout.add(beskrivelseTekst, 1, 2);
		layout.add(ok, 0, 3);
		layout.add(cancel, 1, 3);
		
		Scene scenen = new Scene(layout, 265, 135);
		vindu.setScene(scenen);
		vindu.sizeToScene();
		vindu.setTitle("Ny hendelse"); 
		vindu.showAndWait();
		
		if (OKTrykket){
			String startdatoHelTekst = startdatoTekst.getText();
			String [] startDatoDeler = startdatoHelTekst.split("-");
			String startAarStreng =  startDatoDeler[0];
			String startMaanedStreng =  startDatoDeler[1];
			String startDagStreng =  startDatoDeler[2];
			
			String sluttdatoHelTekst = sluttdatoTekst.getText();
			String [] sluttDatoDeler = sluttdatoHelTekst.split("-");
			String sluttAarStreng =  sluttDatoDeler[0];
			String sluttMaanedStreng =  sluttDatoDeler[1];
			String sluttDagStreng =  sluttDatoDeler[2];

			//Exceptions
			int startAar = Integer.parseInt(startAarStreng);
			int startMaaned = Integer.parseInt(startMaanedStreng);
			int startDag = Integer.parseInt(startDagStreng);
			
			int sluttAar = Integer.parseInt(sluttAarStreng);
			int sluttMaaned = Integer.parseInt(sluttMaanedStreng);
			int sluttDag = Integer.parseInt(sluttDagStreng);
			
			String beskrivelse = beskrivelseTekst.getText();
			Main.leggTilIAlleHendelse(startAar, startMaaned, startDag,sluttAar, sluttMaaned, sluttDag, beskrivelse);
			Main.oppdatereHendelseliste();
		}
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		nyHendelseDialogvindu();
		
	}

}
