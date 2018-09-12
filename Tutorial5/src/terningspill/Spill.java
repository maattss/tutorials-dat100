package terningspill;

import java.util.ArrayList;
import java.util.Scanner;

public class Spill {
	private static ArrayList <Spiller> spillere;
	private static ArrayList <Spiller> spillereIgjen;

	public static Spiller lagSpiller(Scanner input){
		Terning terningen = new Terning();
		int poeng = 0;
		for (int i=0; i<2; i++){
			terningen.kast();	
			poeng += terningen.getTall();
		}
		
		Boolean avslutt = false;
		String navn = null;
		while(avslutt == false){
		System.out.print("Skriv inn navnet på spilleren: ");
		navn = input.nextLine();
		if(!navn.isEmpty())avslutt = true;
		}
		Spiller spilleren = new Spiller(navn);
		spilleren.setPoengsum(poeng);
		return spilleren;
	}
	public static void spillOmgangEnSpiller(Spiller spilleren, Scanner input){
		System.out.println("\nDet er " + spilleren.getNavn() + " med " +
		spilleren.getPoengsum() + " poeng sin tur.");
		
		String svar;
		Boolean avslutt = false;
		while(avslutt == false){
		System.out.print("Vil du kaste på ny? (j/n) ");
		svar = input.nextLine();
			if(svar.equals("j")){
				avslutt = true;
				Terning terningen = new Terning();
				int poeng = spilleren.getPoengsum();
				terningen.kast();
				poeng += terningen.getTall();
				spilleren.setPoengsum(poeng);
				if(poeng > 21){
					System.out.println(spilleren.getNavn() + " fikk mer enn 21 "
							+ "poeng, og har dermed tapt spillet.");
					spillereIgjen.remove(spilleren);
				}
			}else if(svar.equals("n")){
				avslutt = true;
				System.out.print(spilleren.getNavn() + " har valgt å avslutte. "
						+ "Poengsummen ble: " + spilleren.getPoengsum() + "\n");
				spillereIgjen.remove(spilleren);
			}else{
				System.out.print("Du må skrive j eller n!\n");
			}
		}
	}
	
	public static void spillOmgang(Scanner input){
		for(int i = 0; i < spillereIgjen.size(); i++){
			Spiller spilleren = spillereIgjen.get(i);
			spillOmgangEnSpiller(spilleren, input);
		}
	}
	
	public static void antallSpillere (Scanner input){
		spillere = new ArrayList<Spiller>();
		spillereIgjen = new ArrayList<Spiller>();
		System.out.print("Skriv inn antall spillere: ");
		int antallSpillere = input.nextInt();
		input.nextLine();
		for(int i=0; i<antallSpillere; i++){
			Spiller spilleren = lagSpiller(input);
			spillere.add(spilleren);
			spillereIgjen.add(spilleren);
		}
		
	}
	public static void sjekkVinner(Scanner input){
		Spiller leder = spillere.get(0);
		
			for(Spiller spilleren: spillere){
				int poengsum = spilleren.getPoengsum();
				if (poengsum < 22){
					if(poengsum > leder.getPoengsum()){
						leder = spilleren;
					}
				}
			}
			
			if (leder.getPoengsum() == 0){
				System.out.print("\nDet ble dessverre ingen vinnere denne runden.");
			}else{
				System.out.print("\nVinneren ble " + leder.getNavn() + " med " +
						leder.getPoengsum() + " poeng.");
			}
	}
	
	public static void main (String [] args){
		Scanner input = new Scanner(System.in);
		antallSpillere(input);
		while(spillereIgjen.size() > 0){
			spillOmgang(input);
		}
		sjekkVinner(input);
		input.close();
	}
}
