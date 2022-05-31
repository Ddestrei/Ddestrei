package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainLabThirth extends Application {
	public void start(Stage main) {
		try {
			Scene scene;
			Parent root;
			FXMLLoader loader;
			loader = new FXMLLoader(getClass().getResource("scenes/MenuScene.fxml"));
			main = new Stage();
			root = loader.load();
			scene = new Scene(root);
			main.setTitle("Labyrinth Game");
			main.setScene(scene);
			main.show();	  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
