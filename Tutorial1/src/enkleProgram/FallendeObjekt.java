package enkleProgram;

import java.util.Scanner;

public class FallendeObjekt {
	private static double tid, fart, nyTid;
	private static int tidsintervall;
	private static boolean suksessTidsintervall, suksessAntallIntervaller;
	private static final double akselerasjon = 9.81;

	public static void main(String[] args) {
		//enkeltFallendeObjekt();
		flereFallendeObjekt();

	}

	public static void enkeltFallendeObjekt() {
		System.out.print("Skriv inn antall sekunder objektet har falt: ");
		Scanner inn = new Scanner(System.in);
		tid = inn.nextDouble();
		if(tid > 0){
			fart = tid*akselerasjon;
			System.out.printf("Farten er %.2f m/s", fart);
		}else{
			System.out.printf("Tallet du skrev inn er ikke større enn 0! Prøv igjen.", tid);
		}
	}
	
	public static void flereFallendeObjekt(){
		Scanner inn = new Scanner(System.in);
		while (suksessTidsintervall == false){
		System.out.print("Skriv inn tidsintervall: ");
		tid = inn.nextDouble();
		nyTid = tid;
			if (tid > 0){
				suksessTidsintervall = true;
				while(suksessAntallIntervaller == false){
					System.out.print("Skriv inn antall intervaller: ");
					tidsintervall = inn.nextInt();
					if(tidsintervall > 0){
						suksessAntallIntervaller = true;
						for(int i = 0; i < tidsintervall; i++){
							fart = nyTid*akselerasjon;
							System.out.printf("Farten etter %.0f s er %.2f m/s\n", nyTid, fart);
							nyTid += tid;
						}
					}else{
						System.out.println("Prøv å skrive inn antall intervaller på ny.");
					}
				}
			}else{
				System.out.println("Prøv å skrive inn tidsintervall på ny.");
			}
		}
		inn.close();
	}
}
