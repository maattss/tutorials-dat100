package metoder;

public class MinsteDeleligTall {
	public static int minsteDelelig(int tall){
		int minsteDelelig = 1;
		boolean avslutt = false;
		for(int i = 2;avslutt == false; i++){
			int rest = tall%i;
			if (rest == 0){
				minsteDelelig = i;
				avslutt = true;
			}
		}
	return minsteDelelig;
	}
	
	
	public static void main (String [] args){
		int input = 9;
		int svar = minsteDelelig(input);
		System.out.printf("Minste delelige for %d er %d", input, svar);		
	}
	
}
