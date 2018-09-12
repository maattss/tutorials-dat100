package klasserOgObjekter;

import java.util.Scanner;
import klasserOgObjekter.FikseBokstavstorrelse;

public class LageSpillere {
	
	public static Spiller hoyestPoengsum(Spiller spiller1, Spiller spiller2){
		if (spiller1.getPoengsum() < spiller2.getPoengsum()){
			return spiller2;
		}else{
			return spiller1;
		}
	}

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		
		Spiller spiller1 = lagSpiller(inn);
		spiller1.skrivUtSpiller();
		
		Spiller spiller2 = lagSpiller(inn);
		spiller2.skrivUtSpiller();
		
		Spiller hoyestPoengsum = hoyestPoengsum(spiller1, spiller2);
		System.out.printf("%nSpilleren med høyeste poengsum er %s med %d poeng."
				, hoyestPoengsum.getNavn(), hoyestPoengsum.getPoengsum());
	}

	private static Spiller lagSpiller(Scanner inn) {
		System.out.print("Skriv inn navn: ");
		String navn = inn.nextLine();
		navn = FikseBokstavstorrelse.fikseBokstaver(navn);
		Spiller spiller = new Spiller(navn);
		System.out.print("Skriv inn poengsum: ");
		try {
			int poeng = Integer.parseInt(inn.nextLine());
			spiller.setPoengsum(poeng);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return spiller;
	}
}
