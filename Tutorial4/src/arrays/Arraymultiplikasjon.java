package arrays;

public class Arraymultiplikasjon {
	
	public static double [] multiplikasjonArray(double[] tallArray, double enkeltTall){
		for (int i =0; i < tallArray.length; i++){
			tallArray[i] *= enkeltTall;
		}
		return tallArray;
	}

	public static void main(String[] args) {
		double tallArray[];
		tallArray = new double [5];
		tallArray[0] = 1;
		tallArray[1] = 2;
		tallArray[2] = 3;
		tallArray[3] = 4;
		tallArray[4] = 5;
		
		multiplikasjonArray(tallArray, 10);
		
		for (double tall: tallArray){
			System.out.println(tall);
		}
	}

}