package metoder;

public class PrimtallSjekk {
	public static boolean sjekkPrimtall(int tall){
		int minsteDelelig = 1;
		boolean avslutt = false;
		for(int i = 2;avslutt == false; i++){
			int rest = tall%i;
			if (rest == 0){
				minsteDelelig = i;
				avslutt = true;
			}
		}
		if (minsteDelelig == tall || minsteDelelig == 1){
			return true;
		}else return false;
	}
	
	public static void main (String [] args){
		boolean sju = sjekkPrimtall(7);
		boolean seks = sjekkPrimtall(6);
		System.out.printf("7:%b, 6:%b", sju, seks);
	}
}
