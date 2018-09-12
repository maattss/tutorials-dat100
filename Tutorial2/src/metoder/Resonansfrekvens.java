package metoder;

public class Resonansfrekvens {
	public static double beregnef(double R, double L, double C){
		double frekvens = 1/(2*Math.PI*Math.sqrt(L*C));
		return frekvens;
	}
	
	public static void main (String [] args){
		double R=3, L=4, C=5;
		double frekvens = beregnef(R, L, C);
		System.out.printf("Resonansfrekvensen er: %.2f Hz", frekvens);
	}
}
