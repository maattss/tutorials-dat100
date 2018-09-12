package enkleProgram;

import java.util.Scanner;

public class LeggeSammenTall {
	private static int heltall = 1, sum;

	public LeggeSammenTall() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		while(heltall > 0){
		System.out.print("Legg sammen tall. Skriv inn ett positivt heltall: ");
		Scanner inn = new Scanner(System.in);
		heltall = inn.nextInt();
		sum += heltall;
		System.out.println("Sum: " + sum);
		}
	}

}
