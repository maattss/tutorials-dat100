package arrays;

public class ArealPolygon {

	private static double xKoordinat [];
	private static double yKoordinat [];
	
	public static void utregning(){
		double xKoordinat [] = new double [8];
		double yKoordinat [] = new double [8];
		
		xKoordinat [0] = 1;
		yKoordinat [0] = 1;
		xKoordinat [1] = 1;
		yKoordinat [1] = 2;
		xKoordinat [2] = 2;
		yKoordinat [2] = 3;
		xKoordinat [3] = 3;
		yKoordinat [3] = 4;
		xKoordinat [4] = 3.5;
		yKoordinat [4] = 3;
		xKoordinat [5] = 2.5;
		yKoordinat [5] = 2.5;
		xKoordinat [6] = 3;
		yKoordinat [6] = 1.5;
		xKoordinat [7] = 4;
		yKoordinat [7] = 1;
		
		double areal = 0;
		for(int i = 0; i < (xKoordinat.length-1) ; i++){
			double x1, x2, y1, y2;
			x1 = xKoordinat[i];
			x2 = xKoordinat[i + 1];
			y1 = yKoordinat[i];
			y2 = yKoordinat[i+1];
			areal += (x2 - x1)*(y1 + (y2 - y1)/2);
		}
		System.out.println(areal);
		
	}
	public static void main (String [] args){
		utregning();
	}
}
