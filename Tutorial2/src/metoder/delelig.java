package metoder;

public class delelig {
	
	public static boolean sjekkDelelig (int tall1, int tall2){
		int sum = tall1%tall2;
		if (sum == 0){
			return true;
		}else{
			return false;
		}
	}

	public static void main (String [] args){
		boolean delelig = sjekkDelelig(4, 2);
		System.out.println("4%2 --> " + delelig);
		delelig = sjekkDelelig(3, 2);
		System.out.println("3%2 --> " + delelig);
		delelig = sjekkDelelig(678, 5);
		System.out.println("678%5 --> " + delelig);
	}
}
