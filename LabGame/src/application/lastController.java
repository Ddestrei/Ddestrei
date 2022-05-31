package application;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class lastController {
	public void continueGame(ActionEvent e) {
		MainLabThirth again = new  MainLabThirth();
	    Stage stage =  (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.close();
		stage.setTitle("Labyrinth Game");
		again.start(stage);
	}
	public void endGame(ActionEvent e) {
		System.exit(0);
	}
}
