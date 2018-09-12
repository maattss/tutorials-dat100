package application;

import java.util.ArrayList;

public class SpillSpillet {

	private int omgang = 0, vinnerTall, forrigeTall;
	private String lengerFraNarmere, lavereHoyere;
	private boolean vunnet;
	private ArrayList<HighscoreSpiller> highscore;
	private int highscoreVerdi = Integer.MAX_VALUE;

	
	public SpillSpillet(){
		highscore = new ArrayList<HighscoreSpiller>();
		vinnerTall = (int)(Math.random() * 1000) + 1;
		System.out.println(vinnerTall);
	}
	
	public void spill(int gjettetTall){
		omgang++;
		if(gjettetTall < vinnerTall){
			lavereHoyere = "lavere";
		}else if(gjettetTall > vinnerTall){
			lavereHoyere = "høyere";
		}else{
			vunnet = true;
		}
		
		if(Math.pow((gjettetTall - vinnerTall), 2) 
				< (Math.pow((forrigeTall - vinnerTall), 2))){
			lengerFraNarmere = "nærmere";
		}else{
			lengerFraNarmere = "lenger i fra";
		}
		forrigeTall = gjettetTall;	
	}
	
	public void nyRunde(){
		vunnet = false;
		omgang = 0;
		vinnerTall = (int)(Math.random() * 1000) + 1;
		System.out.println(vinnerTall);
		
	}
	
	//gettere og settere

	public int getHighscoreVerdi() {
		return highscoreVerdi;
	}

	public void setHighscoreVerdi(int highscoreVerdi) {
		this.highscoreVerdi = highscoreVerdi;
	}

	public boolean isVunnet() {
		return vunnet;
	}
	
	public String getLengerFraNarmere() {
		return lengerFraNarmere;
	}

	public String getLavereHoyere() {
		return lavereHoyere;
	}

	public void setHighscore(){
		
	}

	public int getOmgang() {
		return omgang;
	}

	public ArrayList<HighscoreSpiller> getHighscore() {
		return highscore;
	}

	public void leggTilHighscore(HighscoreSpiller spiller) {
		highscore.add(spiller);
	}
}
