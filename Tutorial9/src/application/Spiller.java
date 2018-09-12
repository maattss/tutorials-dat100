package application;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Spiller {
	
	private int xKoordinat;
	private int yKoordinat;
	private Node utseende;

	public Spiller(int xKoordinatStart, int yKoordinatStart) {
		this.xKoordinat = xKoordinatStart;
		this.yKoordinat = yKoordinatStart;
		utseende = new Circle(20, Color.YELLOW);
	}

	public Node getUtseende() {
		return utseende;
	}
	
	public void settOppdaget(boolean oppdaget) {
		if (oppdaget == true){
			utseende = new Circle(20, Color.YELLOW);
			
		}else{
			utseende = new Rectangle(40, 40, Color.GAINSBORO);
		}
	}

	public void setxKoordinat(int xKoordinat) {
		this.xKoordinat = xKoordinat;
	}

	public void setyKoordinat(int yKoordinat) {
		this.yKoordinat = yKoordinat;
	}

	public int getxKoordinat() {
		return xKoordinat;
	}

	public int getyKoordinat() {
		return yKoordinat;
	}
}
