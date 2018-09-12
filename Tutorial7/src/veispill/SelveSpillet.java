package veispill;

import java.util.ArrayList;
import java.util.Scanner;

public class SelveSpillet {

	private static ArrayList<Rute> ruter;
	private static ArrayList<Spiller> spillere;
	
	public static Boolean kast(Spiller spilleren){
		AbstraktRute abstrakt = new AbstraktRute(0) {
			
			@Override
			public void flyttHit(Spiller spilleren) {
				// TODO Auto-generated method stub
				
			}
		};
		Scanner inn = new Scanner(System.in);
		Terning terningen = new Terning();	
		System.out.print( "\n"+ spilleren.getNavn() + " står på rute " + spilleren.getPosisjon() +
		". Trykk enter for å kaste.");
		inn.nextLine();
		terningen.kast();
		System.out.print("Det ble " + terningen.getTall() + ". ");
		int posisjon = spilleren.getPosisjon();
		posisjon += terningen.getTall();
		
		if(posisjon>=20){
			System.out.println(spilleren.getNavn() + " har kommet i mål, gratulerer!");
			return true;
		}else{
			Rute nvRute = ruter.get(posisjon);
			nvRute.flyttHit(spilleren);
			return false;
		}
	}

	
	
	public static void main(String[] args) {
		ruter = new ArrayList<Rute>();
		spillere = new ArrayList<Spiller>();
		Scanner inn = new Scanner(System.in);
		for(int i = 0; i < 20;i++){
			double ruteOppsett = Math.random();
			if(ruteOppsett <= 0.6){
				ruter.add(new VanligRute(i));
			}else if(ruteOppsett <= 0.7 && ruteOppsett > 0.6){
				ruter.add(new TilbakeTilStart(i));
			}else if(ruteOppsett <= 0.8 && ruteOppsett > 0.7){
				ruter.add(new Hinder(i));
			}else if(ruteOppsett <= 0.9 && ruteOppsett > 0.8){
				ruter.add(new EkstraKast(i));
			}else{
				ruter.add(new StaaOverTur(i));
			}
		}
		
		System.out.print("Antall spillere: ");
		int antallSpillere = inn.nextInt();
		inn.nextLine();
		
		for(int i = 0; i < antallSpillere; i++){
			System.out.print("Skriv inn navnet på spiller " + (i+1) + ": ");
			Spiller spilleren = new Spiller(inn.nextLine());
			spillere.add(spilleren);
		}
	
		spillokke: while(true){
			for(Spiller spilleren: spillere){
				if (spilleren.getStaaOverTur() == false){
					Boolean avslutt = kast(spilleren);
					if(avslutt == true){
						break spillokke;
					}
				}else{
					spilleren.setStaaOverTur(false);
				}
			}		
		}
		System.out.print("\nSpillet er slutt!");

	}

}
