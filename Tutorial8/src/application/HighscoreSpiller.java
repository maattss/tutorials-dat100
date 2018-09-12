package application;

public class HighscoreSpiller{
	private String navn;
	private int highscore;

	public HighscoreSpiller(String navn, int highscore) {
		this.navn = navn;
		this.highscore = highscore;
	}
	public String toString(){
		String utskrift = "Navn: " + navn + ", Highscore: " + highscore;
		return utskrift;
	}

	public int getHighscore(){
		return highscore;
	}
	public String getNavn(){
		return navn;
	}
}

