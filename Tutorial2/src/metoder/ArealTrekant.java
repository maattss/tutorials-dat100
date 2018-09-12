package metoder;

public class ArealTrekant {
	private static double side1, side2, vinkel, areal;

	public static void main(String[] args) {
		side1 = 3;
		side2 = 5;
		vinkel = 43;
		
		areal = 0.5*side1*side2*(Math.sin(Math.toRadians(vinkel)));
		System.out.printf("Side 1: %.1f cm\nSide 2: %.1f cm\nVinkel: %.0f grader\nAreal: %.2f cm^2", side1, side2, vinkel, areal);

	}

}
