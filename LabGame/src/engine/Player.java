package engine;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle{
	int x;
	int y;
	final int xLength=10; 
	final int yLength=10;
	Image player = new Image("/Player.jpg");
	public Player(){
		this.setHeight(yLength);
		this.setWidth(xLength);
		this.setFill(new ImagePattern(player));
	}
	public void setLayX(int x) {
		this.setLayoutX(x);
		this.x=x;
	}
	public void setLayY(int y) {
		this.setLayoutY(y);
		this.y=y;
	}
	public void move(int newX,int newY) {
		this.setLayoutX(newX);
		this.setLayoutY(newY);
		this.x=newX;
		this.y=newY;
		this.setFill(new ImagePattern(player));
	}
}
