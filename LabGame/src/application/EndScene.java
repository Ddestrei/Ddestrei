package application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class EndScene extends Parent{
	int steps=0;
	int playerSteps=0;
	int difficulty=0;
	Rectangle stars = new Rectangle();
	Label textLabel = new Label();
	Button endGame = new Button();
	Button conGame = new Button();
	AnchorPane main = new AnchorPane();
	Image yellowthree = new Image("YellowThreestars.jpg");
	
	Image blueone = new Image("BlueOnestars.jpg");
	
	Image redzero = new Image("RedZerostars.jpg");
	
	Image greentwo = new Image("GreenTwostars.jpg");
	
	Image yellow = new Image("PlayagainYellow.jpg");
	Image red = new Image("PlayagainRed.jpg");
	Image green = new Image("PlayagainGreen.jpg");
	Image blue = new Image("PlayagainBlue.jpg");
	
	Image yellowEnd = new Image("EndGameYellow.jpg");
	Image redEnd = new Image("EndGameRed.jpg");
	Image greenEnd = new Image("EndGameGreen.jpg");
	Image blueEnd = new Image("EndGameBlue.jpg");
	ImageView conImage = new ImageView();
	ImageView endImage = new ImageView();
	Rectangle mainSquere= new Rectangle();
	EndScene(int steps,int playerSteps,int diff){
		//System.out.println("EndWork");
		this.steps=steps;
		this.playerSteps=playerSteps;
		main.setPrefWidth(1010);
		main.setPrefHeight(1010);
		mainSquere.setWidth(1010);
		mainSquere.setHeight(1010);
		mainSquere.setX(0);
		mainSquere.setY(0);
		this.getChildren().add(main);
		final int easyThree=steps;
		final int easyTwo=(int) (steps+steps*0.1);
		final int easyOne=(int) (steps+steps*0.2);
		final int normalThree=(int) (steps+steps*0.1);
		final int normalTwo=(int) (steps+steps*0.2);
		final int normalOne=(int) (steps+steps*0.3);
		final int hardThree=(int) (steps+steps*0.2);
		final int hardTwo=(int) (steps+steps*0.4);
		final int hardOne=(int) (steps+steps*0.6);
		difficulty=diff;
		/*main.setPrefWidth(1010);
		main.setPrefHeight(1010);*/
		conImage.setX(355);
		conImage.setY(455);
		conImage.setFitWidth(300);
		conImage.setFitHeight(100);
		endImage.setX(355);
		endImage.setY(655);
		endImage.setFitWidth(300);
		endImage.setFitHeight(100);
		conGame = new Button();
		conGame.setLayoutX(355);
		conGame.setLayoutY(455);
		conGame.setPrefWidth(300);
		conGame.setPrefHeight(100);
		conGame.setOpacity(0);
		endGame.setLayoutX(355);
		endGame.setLayoutY(655);
		endGame.setPrefWidth(300);
		endGame.setPrefHeight(100);
		endGame.setOpacity(0);
		textLabel.setPrefWidth(1000);
		textLabel.setPrefHeight(100);
		textLabel.setLayoutX(5);
		textLabel.setLayoutY(55);
		textLabel.setFont(new Font("System",30));
		textLabel.setAlignment(Pos.CENTER);
		stars.setWidth(300);
		stars.setHeight(100);
		stars.setX(355);
		stars.setY(255);
		if (difficulty==0) {
			if(playerSteps<=easyThree) {
				stars.setFill(new ImagePattern(yellowthree));
				conImage.setImage(yellow);
				endImage.setImage(yellowEnd);
				mainSquere.setFill(Color.rgb(241, 255, 31));
				textLabel.setText("You done it for three stars in easy mode!!!");
			}
			else if(playerSteps>easyThree&&playerSteps<=easyTwo) {
				stars.setFill(new ImagePattern(greentwo));
				mainSquere.setFill(Color.rgb(33, 255, 104));
				conImage.setImage(green);
				endImage.setImage(greenEnd);
				textLabel.setText("You done it for two stars in easy mode!!!");
			}
			else if (playerSteps>easyTwo&&playerSteps<=easyOne) {
				stars.setFill(new ImagePattern(blueone));
				mainSquere.setFill(Color.rgb(33, 75, 255));
				conImage.setImage(blue);
				endImage.setImage(blueEnd);
				textLabel.setText("You done it for one stars in easy mode!!!");
			}
			else {
				stars.setFill(new ImagePattern(redzero));
				mainSquere.setFill(Color.rgb(233, 33, 33));
				conImage.setImage(red);
				endImage.setImage(redEnd);
				textLabel.setText("You done it for zero stars in easy mode!!!");
			}
		}
		else if(difficulty==1) {
			if(playerSteps<=normalThree) {
				stars.setFill(new ImagePattern(yellowthree));
				conImage.setImage(yellow);
				endImage.setImage(yellowEnd);
				mainSquere.setFill(Color.rgb(241, 255, 31));
				textLabel.setText("You done it for three stars in normal mode!!!");
			}
			else if(playerSteps>normalThree&&playerSteps<=normalTwo) {
				stars.setFill(new ImagePattern(greentwo));
				mainSquere.setFill(Color.rgb(33, 255, 104));
				conImage.setImage(green);
				endImage.setImage(greenEnd);
				textLabel.setText("You done it for two stars in normal mode!!!");
			}
			else if (playerSteps>normalTwo&&playerSteps<=normalOne) {
				stars.setFill(new ImagePattern(blueone));
				mainSquere.setFill(Color.rgb(33, 75, 255));
				conImage.setImage(blue);
				endImage.setImage(blueEnd);
				textLabel.setText("You done it for one stars in normal mode!!!");
			}
			else {
				stars.setFill(new ImagePattern(redzero));
				mainSquere.setFill(Color.rgb(233, 33, 33));
				conImage.setImage(red);
				endImage.setImage(redEnd);
				textLabel.setText("You done it for zero stars in normal mode!!!");
			}
		}
		else if(difficulty==2) {
			if(playerSteps<=hardThree) {
				stars.setFill(new ImagePattern(yellowthree));
				conImage.setImage(yellow);
				endImage.setImage(yellowEnd);
				mainSquere.setFill(Color.rgb(241, 255, 31));
				textLabel.setText("You done it for three stars in hard mode!!!");
			}
			else if(playerSteps>hardThree&&playerSteps<=hardTwo) {
				stars.setFill(new ImagePattern(greentwo));
				mainSquere.setFill(Color.rgb(33, 255, 104));
				conImage.setImage(green);
				endImage.setImage(greenEnd);
				textLabel.setText("You done it for two stars in hard mode!!!");
			}
			else if (playerSteps>hardTwo&&playerSteps<=hardOne) {
				stars.setFill(new ImagePattern(blueone));
				mainSquere.setFill(Color.rgb(33, 75, 255));
				conImage.setImage(blue);
				endImage.setImage(blueEnd);
				textLabel.setText("You done it for one stars in hard mode!!!");
			}
			else {
				stars.setFill(new ImagePattern(redzero));
				mainSquere.setFill(Color.rgb(233, 33, 33));
				conImage.setImage(red);
				endImage.setImage(redEnd);
				textLabel.setText("You done it for zero stars in hard mode!!!");
			}
		}
		this.getChildren().add(mainSquere);
		this.getChildren().add(conImage);
		this.getChildren().add(endImage);
		this.getChildren().add(conGame);
		this.getChildren().add(endGame);
		this.getChildren().add(stars);
		this.getChildren().add(textLabel);
	}
}
