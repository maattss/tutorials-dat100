package metoder;

import java.util.Scanner;

public class FallendeObjekt {
	private static double tid, distanse;
	private static boolean suksess;
	private static final double akselerasjon = 9.81;

	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		while(suksess == false){
			System.out.print("Antall sekunder: ");
			tid = inn.nextDouble();
			distanse = flereFallendeObjekt(tid);
		}
		System.out.printf("Distansen objektet har falt etter " 
				+ "%.0f sekunder er %.2f meter.", tid, distanse);
	}
	
	public static double flereFallendeObjekt(double tidsintervall){
			tid = tidsintervall;
			if (tid > 0){
					distanse = 0.5*akselerasjon*Math.pow(tid, 2);
					suksess = true;
			}else{
				System.out.println("Prøv å skrive inn antall sekunder på ny.");
			}
		return distanse;
	}
}
