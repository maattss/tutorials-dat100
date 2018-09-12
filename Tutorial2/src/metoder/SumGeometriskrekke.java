package metoder;

public class SumGeometriskrekke {
	private static double a,r,n, svar;
	
	public static double regnUt (double a, double r, double n){
		double svar = 0;
		for(int i = 0;i <=n; i++){
			svar += a*Math.pow(r, i);
		}
		return svar;
	}

	public static void main(String[] args) {
		a = 2;
		r = 3;
		n = 5;
		svar = regnUt(a, r, n);
		System.out.printf("Sum geometrisk rekke: %.1f", svar);
	}

}
