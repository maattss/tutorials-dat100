package klasserOgObjekter;

public class FikseBokstavstorrelse {
	
	public static String fikseBokstaver(String streng){
		String forsteBokstav = streng.substring(0, 1);
		forsteBokstav = forsteBokstav.toUpperCase();
		String resterendeBokstaver = streng.substring(1);
		resterendeBokstaver = resterendeBokstaver.toLowerCase();
		StringBuilder strengBygger = new StringBuilder();
		strengBygger.append(forsteBokstav);
		strengBygger.append(resterendeBokstaver);
		return strengBygger.toString();
	}

	public static void main(String[] args) {

	}

}
