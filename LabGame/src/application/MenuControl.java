package application;

import java.io.IOException;

import engine.ReaderFile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MenuControl {
	Stage main;
	Scene scene;
	/*@FXML
	static ImageView five;
	@FXML
	static ImageView six;
	@FXML
	static ImageView seven;
	@FXML
	static ImageView eight;
	@FXML
	static ImageView nine;
	@FXML
	static ImageView ten;
	@FXML
	static ImageView oneHundert;
	@FXML
	static ImageView twoHundert;
	@FXML
	static ImageView threeHundert;
	@FXML
	static ImageView fourHundert;*/
	/////////////////
	@FXML
	TextField easyThree;
	@FXML
	TextField easyTwo;
	@FXML
	TextField easyOne;
	@FXML
	TextField easyZero;
	@FXML
	TextField normalThree;
	@FXML
	TextField normalTwo;
	@FXML
	TextField normalOne;
	@FXML
	TextField normalZero;
	@FXML
	TextField hardThree;
	@FXML
	TextField hardTwo;
	@FXML
	TextField hardOne;
	@FXML
	TextField hardZero;
	@FXML
	TextField started;
	@FXML
	TextField ended;
	/*public MenuControl() {
		loaderOption = new FXMLLoader(getClass().getResource("scenes/Option.fxml"));
		try {
			root = loaderOption.load();
			sceneOption = new Scene(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setOption();
	}*/
	public void startGame(ActionEvent e) {
		try {
			main =  (Stage)((Node)e.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/FirstPanel.fxml"));
			main.close();
			main = new Stage();
		 	Parent root = loader.load();
			scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			//main.setFullScreen(true);
			main.setScene(scene);
			main.show();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void endGame(ActionEvent e) {
		System.exit(0);
	}
	public void addOption(ActionEvent e) {
		try {
			main =  (Stage)((Node)e.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/Option.fxml"));
			main.close();
			main = new Stage();
		 	Parent root = loader.load();
			scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			//main.setFullScreen(true);
			main.setScene(scene);
			main.show();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void toOption(ActionEvent e) {
		addOption(e);
		//setOption();
	}

	public void refreshText(ActionEvent e) {
		//System.out.print(false);
		ReaderFile readerFile = new ReaderFile();
		if (readerFile.emptyFile()==false) {
			//System.out.println(readerFile.returnEasyThree());
			easyThree.setText(String.valueOf(readerFile.returnEasyThree()));
			easyTwo.setText(String.valueOf(readerFile.returnEasyTwo()));
			easyOne.setText(String.valueOf(readerFile.returnEasyOne()));
			easyZero.setText(String.valueOf(readerFile.returnEasyZero()));
			normalThree.setText(String.valueOf(readerFile.returnNormalThree()));
			normalTwo.setText(String.valueOf(readerFile.returnNormalTwo()));
			normalOne.setText(String.valueOf(readerFile.returnNormalOne()));
			normalZero.setText(String.valueOf(readerFile.returnNormalZero()));
			hardThree.setText(String.valueOf(readerFile.returnHardThree()));
			hardTwo.setText(String.valueOf(readerFile.returnHardTwo()));
			hardOne.setText(String.valueOf(readerFile.returnHardOne()));
			hardZero.setText(String.valueOf(readerFile.returnHardZero()));
			started.setText(String.valueOf(readerFile.returnStartedGames()));
			ended.setText(String.valueOf(readerFile.returnEndedGames()));
		}
		else {
			easyThree.setText("0");
			
			easyTwo.setText("0");
			easyOne.setText("0");
			easyZero.setText("0");
			normalThree.setText("0");
			normalTwo.setText("0");
			normalOne.setText("0");
			normalZero.setText("0");
			hardThree.setText("0");
			hardTwo.setText("0");
			hardOne.setText("0");
			hardZero.setText("0");
			started.setText("0");
			ended.setText("0");
		}
	}
	public void toPlayer(ActionEvent e) {
		
		try {
			main =  (Stage)((Node)e.getSource()).getScene().getWindow();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/PlayerScene.fxml"));
			main.close();
			main = new Stage();
		 	Parent root = loader.load();
		 	scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			//main.setFullScreen(true);
			main.setScene(scene);
			main.show();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	public void toMenu(ActionEvent e) {
		try {
			Stage main =  (Stage)((Node)e.getSource()).getScene().getWindow();
			main.close();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/MenuScene.fxml"));
			main.close();
			main = new Stage();
		 	Parent root = loader.load();
			scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			//main.setFullScreen(true);
			main.setScene(scene);
			main.show();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}
	/*public void aboutGame(ActionEvent e) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AboutGame.fxml"));
			main =  (Stage)((Node)e.getSource()).getScene().getWindow();
			main.close();
			main = new Stage();
		 	Parent root = loader.load();
			scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			//main.setFullScreen(true);
			main.setScene(scene);
			main.show();
			
		} catch(Exception e1) {
			e1.printStackTrace();
		}
	}*/
}
/*<TextField fx:id="easyThree" alignment="CENTER" disable="true" layoutX="5.0" layoutY="205.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="easyTwo" alignment="CENTER" disable="true" layoutX="105.0" layoutY="205.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="easyOne" alignment="CENTER" disable="true" layoutX="405.0" layoutY="205.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="easyZero" alignment="CENTER" disable="true" layoutX="505.0" layoutY="205.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="normalZero" alignment="CENTER" disable="true" layoutX="505.0" layoutY="305.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="normalOne" alignment="CENTER" disable="true" layoutX="405.0" layoutY="305.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="normalTwo" alignment="CENTER" disable="true" layoutX="105.0" layoutY="305.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="normalThree" alignment="CENTER" disable="true" layoutX="5.0" layoutY="305.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="hardThree" alignment="CENTER" disable="true" layoutX="5.0" layoutY="405.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="hardTwo" alignment="CENTER" disable="true" layoutX="105.0" layoutY="405.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="hardOne" alignment="CENTER" disable="true" layoutX="405.0" layoutY="405.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>
<TextField fx:id="hardZero" alignment="CENTER" disable="true" layoutX="505.0" layoutY="405.0" prefHeight="90.0" prefWidth="90.0" text="0">
<font>
   <Font size="20.0" />
</font></TextField>*/
