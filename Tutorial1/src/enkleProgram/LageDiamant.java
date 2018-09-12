package enkleProgram;

import java.util.Scanner;

public class LageDiamant {
	private static int storrelse;

	public static void main(String[] args) {
		/*
		Scanner inn = new Scanner(System.in);
		System.out.print("Lag en diamant. Skriv inn størrelse på diamanten: ");
		storrelse = inn.nextInt();
		*/
		skrivDiamant(4);
		
	}
	
	private static void skrivDiamant(int storrelse){
		int x, y;
		for(y = 0; y < storrelse; y++){
			for (x = 0; x < storrelse; x++){
				if (storrelse-y-1 == x){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			for (x = storrelse - 1; x > 0; x--){
				if (storrelse-y == x){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();	
		}
		for(y = storrelse - 2; y >= 0; y--){
			for (x = 0; x < storrelse; x++){
				if (storrelse-y-1 == x){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			for (x = storrelse - 1; x > 0; x--){
				if (storrelse - y == x){
					System.out.print("*");
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
