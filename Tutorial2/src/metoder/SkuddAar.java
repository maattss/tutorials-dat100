package metoder;

public class SkuddAar {
	
	public static boolean sjekkSkuddaar(int aar){
		int rest;
		rest = aar%4;
		if(rest == 0){
			rest = aar%100;
			if(rest == 0){
				rest = aar%400;
				if (rest == 0){
					return true;
				}else{
				return false;
				}
			}return true;
		}else{
			return false;
		}
	}
	
	public static void main (String [] args){
		System.out.print(sjekkSkuddaar(2000));
		
	}
}
