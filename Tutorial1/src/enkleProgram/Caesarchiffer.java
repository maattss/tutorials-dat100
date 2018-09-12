package enkleProgram;

import java.util.Scanner;

public class Caesarchiffer {
	private static String ukryptert, kryptert;
	private static int skift;
	
	public static void main(String[] args) {
		Scanner inn = new Scanner(System.in);
		System.out.print("Skriv inn streng som skal krypters: ");
		ukryptert = inn.nextLine();
		System.out.print("Skriv inn kryperingstall: ");
		skift = inn.nextInt();
		
		kryptert = kryptering(ukryptert, skift);
		System.out.println("Kryptert: " + kryptert);
		
		/*System.out.print("Vil du dekryptere? (j/n): ");
		String spm = inn.nextLine();
		if(spm == "j"){}*/
		
		ukryptert = dekryptering(kryptert, skift);
		System.out.println("Ukryptert: " + ukryptert);
		
	}
	private static String kryptering(String ukryptert, int skift) {
		ukryptert = ukryptert.toLowerCase();
		int lengde = ukryptert.length();
		StringBuilder strengBygger = new StringBuilder();
		for(int i = 0; i < lengde; i++){
			char c = ukryptert.charAt(i);
				if (Character.isLetter(c)){
					c = (char)(ukryptert.charAt(i) + skift);
					if (c > 'z'){
					c = (char)(ukryptert.charAt(i) - (26 - skift));
					}
				}
			strengBygger.append(c);
		}	
		return strengBygger.toString();
		
	}
	private static String dekryptering(String kryptert, int skift){
		kryptert = kryptert.toLowerCase();
		int lengde = kryptert.length();
		StringBuilder strengBygger = new StringBuilder();
		for(int i = 0; i < lengde; i++){
			char c = kryptert.charAt(i);
				if (Character.isLetter(c)){
					c = (char)(kryptert.charAt(i) - skift);
					if (c < 'a'){
					c = (char)(kryptert.charAt(i) + (26 - skift));
				}
			}
			strengBygger.append(c);
		}
		return strengBygger.toString();
	}
}
