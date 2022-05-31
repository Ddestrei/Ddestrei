package application;

import java.io.IOException;

import engine.ReaderFile;
import engine.SaverFile;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Controller {
	Stage stage = new Stage();
	Scene scene;
	static GameScene game;
	@FXML
	ImageView stars;
	@FXML
	Label textLabel;
	@FXML
	 ImageView five;
	@FXML
	 ImageView six;
	@FXML
	 ImageView seven;
	@FXML
	 ImageView eight;
	@FXML
	 ImageView nine;
	@FXML
	 ImageView ten;
	@FXML
	 ImageView oneHundert;
	@FXML
	 ImageView twoHundert;
	@FXML
	 ImageView threeHundert;
	@FXML
	 ImageView fourHundert;
	
	ActionEvent event;
	static int diff;
	static int windowSize=50;
	static int mazeSize=100;
	public void startGame() {
		ReaderFile readerFile = new ReaderFile();
		int arrStars[] = new int [12];
		int started;
		int ended= readerFile.returnEndedGames();
		if(readerFile.emptyFile()==false) {
			arrStars[0]=(readerFile.returnEasyThree());
			arrStars[1]=(readerFile.returnEasyTwo());
			arrStars[2]=(readerFile.returnEasyOne());
			arrStars[3]=(readerFile.returnEasyZero());
			arrStars[4]=(readerFile.returnNormalThree());
			arrStars[5]=(readerFile.returnNormalTwo());
			arrStars[6]=(readerFile.returnNormalOne());
			arrStars[7]=(readerFile.returnNormalZero());
			arrStars[8]=(readerFile.returnHardThree());
			arrStars[9]=(readerFile.returnHardTwo());
			arrStars[10]=(readerFile.returnHardOne());
			arrStars[11]=(readerFile.returnHardZero());
			started = readerFile.returnStartedGames();
			ended  = readerFile.returnStartedGames();
		}
		else {
			arrStars[0]=0;
			arrStars[1]=0;
			arrStars[2]=0;
			arrStars[3]=0;
			arrStars[4]=0;
			arrStars[5]=0;
			arrStars[6]=0;
			arrStars[7]=0;
			arrStars[8]=0;
			arrStars[9]=0;
			arrStars[10]=0;
			arrStars[11]=0;
			started=0;
			ended=0;
		}
		SaverFile saverFile = new SaverFile(arrStars,started+1,ended);
	} 
	public void easy(ActionEvent e) throws IOException{
		diff=0;
		startGame();
		game = new GameScene(0,mazeSize,windowSize);
		scene = new Scene(game);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				//System.out.println(event.getCode());
				switch(event.getCode()) {
					case W:
						game.moveW(mazeSize);
						//ystem.out.println(false);
						break;
					case S:
						game.moveS(mazeSize);
						//System.out.println(false);
						if(game.end==true) {
							stage.close();
							setLastWindow(e);
						}
						break;
					case A:
						game.moveA(mazeSize);
						//System.out.println(false);
						break;
					case D:
						game.moveD(mazeSize);
						//System.out.println(false);
						break;
					default:
						break;
				}		
			}	
		});
	}
	public void normal(ActionEvent e) {
		diff=1;
		startGame();
		game = new GameScene(1,mazeSize,windowSize);
		scene = new Scene(game);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				//System.out.println(event.getCode());
				switch(event.getCode()) {
					case W:
						game.moveW(mazeSize);
						//ystem.out.println(false);
						break;
					case S:
						game.moveS(mazeSize);
						//System.out.println(false);
						if(game.end==true) {
							stage.close();
							setLastWindow(e);
						}
						break;
					case A:
						game.moveA(mazeSize);
						//System.out.println(false);
						break;
					case D:
						game.moveD(mazeSize);
						//System.out.println(false);
						break;
					default:
						break;
				}		
			}	
		});
	}
	public void hard(ActionEvent e) {
		diff=2;
		startGame();
		game = new GameScene(2,mazeSize,windowSize);
		scene = new Scene(game);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				//System.out.println(event.getCode());
				switch(event.getCode()) {
					case W:
						game.moveW(mazeSize);
						//ystem.out.println(false);
						break;
					case S:
						game.moveS(mazeSize);
						//System.out.println(false);
						if(game.end==true) {
							stage.close();
							setLastWindow(e);
						}
						break;
					case A:
						game.moveA(mazeSize);
						//System.out.println(false);
						break;
					case D:
						game.moveD(mazeSize);
						//System.out.println(false);
						break;
					default:
						break;
				}		
			}	
		});
	}
	public void oneHun(ActionEvent e) {
		if(mazeSize==200) {
			twoHundert.setImage(new Image("resources/200x200.jpg"));
		}
		else if (mazeSize==300) {
			threeHundert.setImage(new Image("resources/300x300.jpg"));
		}
		else if (mazeSize==400) {
			fourHundert.setImage(new Image("resources/400x400.jpg"));
		}
		mazeSize=100;
		oneHundert.setImage(new Image("resources/100x100RedBigger.jpg"));
	}
	public void twoHun(ActionEvent e) {
		if(mazeSize==100) {
			oneHundert.setImage(new Image("resources/100x100.jpg"));
		}
		else if (mazeSize==300) {
			threeHundert.setImage(new Image("resources/300x300.jpg"));
		}
		else if (mazeSize==400) {
			fourHundert.setImage(new Image("resources/400x400.jpg"));
		}
		mazeSize=200;
		twoHundert.setImage(new Image("resources/200x200Red.jpg"));
	}
	public void threeHun(ActionEvent e) {
		if(mazeSize==200) {
			twoHundert.setImage(new Image("resources/200x200.jpg"));
		}
		else if (mazeSize==100) {
			oneHundert.setImage(new Image("resources/100x100.jpg"));
		}
		else if (mazeSize==400) {
			fourHundert.setImage(new Image("resources/400x400.jpg"));
		}
		mazeSize=300;
		threeHundert.setImage(new Image("resources/300x300Red.jpg"));
	}
	public void fourHun(ActionEvent e) {
		if(mazeSize==200) {
			twoHundert.setImage(new Image("resources/200x200.jpg"));
		}
		else if (mazeSize==300) {
			threeHundert.setImage(new Image("resources/300x300.jpg"));
		}
		else if (mazeSize==100) {
			oneHundert.setImage(new Image("resources/100x100.jpg"));
		}
		mazeSize=400;
		fourHundert.setImage(new Image("resources/400x400Red.jpg"));
	}
	public void fifty(ActionEvent e) {
		if(windowSize==100) {
			ten.setImage(new Image("resources/100x100N.jpg"));
		}
		else if(windowSize==90) {
			nine.setImage(new Image("resources/90x90.jpg"));
		}
		else if(windowSize==80) {
			eight.setImage(new Image("resources/80x80.jpg"));
		}
		else if(windowSize==70) {
			seven.setImage(new Image("resources/70x70.jpg"));
		}
		else if(windowSize==60) {
			six.setImage(new Image("resources/60x60.jpg"));
		}
		windowSize=50;
		five.setImage(new Image("resources/50x50Red.jpg"));
	}
	public void sixty(ActionEvent e) {
		if(windowSize==100) {
			ten.setImage(new Image("resources/100x100N.jpg"));
		}
		else if(windowSize==90) {
			nine.setImage(new Image("resources/90x90.jpg"));
		}
		else if(windowSize==80) {
			eight.setImage(new Image("resources/80x80.jpg"));
		}
		else if(windowSize==70) {
			seven.setImage(new Image("resources/70x70.jpg"));
		}
		else if(windowSize==50) {
			five.setImage(new Image("resources/50x50.jpg"));
		}
		windowSize=60;
		six.setImage(new Image("resources/60x60Red.jpg"));
	}
	public void seventy(ActionEvent e) {
		if(windowSize==100) {
			ten.setImage(new Image("resources/100x100N.jpg"));
		}
		else if(windowSize==90) {
			nine.setImage(new Image("resources/90x90.jpg"));
		}
		else if(windowSize==80) {
			eight.setImage(new Image("resources/80x80.jpg"));
		}
		else if(windowSize==50) {
			five.setImage(new Image("resources/50x50.jpg"));
		}
		else if(windowSize==60) {
			six.setImage(new Image("resources/60x60.jpg"));
		}
		windowSize=70;
		seven.setImage(new Image("resources/70x70Red.jpg"));
	}
	public void eighty(ActionEvent e) {
		if(windowSize==100) {
			ten.setImage(new Image("resources/100x100N.jpg"));
		}
		else if(windowSize==90) {
			nine.setImage(new Image("resources/90x90.jpg"));
		}
		else if(windowSize==50) {
			five.setImage(new Image("resources/50x50.jpg"));
		}
		else if(windowSize==70) {
			seven.setImage(new Image("resources/70x70.jpg"));
		}
		else if(windowSize==60) {
			six.setImage(new Image("resources/60x60.jpg"));
		}
		windowSize=80;
		eight.setImage(new Image("resources/80x80Red.jpg"));
	}
	public void ninety(ActionEvent e) {
		if(windowSize==100) {
			ten.setImage(new Image("resources/100x100N.jpg"));
		}
		else if(windowSize==50) {
			five.setImage(new Image("resources/50x50.jpg"));
		}
		else if(windowSize==80) {
			eight.setImage(new Image("resources/80x80.jpg"));
		}
		else if(windowSize==70) {
			seven.setImage(new Image("resources/70x70.jpg"));
		}
		else if(windowSize==60) {
			six.setImage(new Image("resources/60x60.jpg"));
		}
		windowSize=90;
		nine.setImage(new Image("resources/90x90Red.jpg"));
	}
	public void hundert(ActionEvent e) {
		if(windowSize==100) {
			five.setImage(new Image("resources/50x50.jpg"));
		}
		else if(windowSize==90) {
			nine.setImage(new Image("resources/90x90.jpg"));
		}
		else if(windowSize==80) {
			eight.setImage(new Image("resources/80x80.jpg"));
		}
		else if(windowSize==70) {
			seven.setImage(new Image("resources/70x70.jpg"));
		}
		else if(windowSize==60) {
			six.setImage(new Image("resources/60x60.jpg"));
		}
		windowSize=100;
		ten.setImage(new Image("resources/100x100Red.jpg"));
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
	/*public void startGame(ActionEvent e ) {
		//System.out.println(false);
		//System.out.println(diff);
		game = new GameScene(diff,mazeSize,windowSize);
		scene = new Scene(game);
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				//System.out.println(event.getCode());
				switch(event.getCode()) {
					case W:
						game.moveW(XLength);
						//ystem.out.println(false);
						break;
					case S:
						game.moveS(XLength);
						//System.out.println(false);
						if(game.end==true) {
							stage.close();
							setLastWindow(e);
						}
						break;
					case A:
						game.moveA(XLength);
						//System.out.println(false);
						break;
					case D:
						game.moveD(XLength);
						//System.out.println(false);
						break;
					default:
						break;
				}		
			}	
		});
	}*/
	public void setLastWindow(ActionEvent e) {
		final int steps= game.steps;
		final int easyThree=steps;
		final int easyTwo=(int) (steps+steps*0.1);
		final int easyOne=(int) (steps+steps*0.2);
		final int normalThree=(int) (steps+steps*0.1);
		final int normalTwo=(int) (steps+steps*0.2);
		final int normalOne=(int) (steps+steps*0.3);
		final int hardThree=(int) (steps+steps*0.2);
		final int hardTwo=(int) (steps+steps*0.4);
		final int hardOne=(int) (steps+steps*0.6);
		ReaderFile readerFile = new ReaderFile();
		int arrStars[] = new int [12];
		int started;
		int ended= readerFile.returnEndedGames();
		if(readerFile.emptyFile()==false) {
			arrStars[0]=(readerFile.returnEasyThree());
			arrStars[1]=(readerFile.returnEasyTwo());
			arrStars[2]=(readerFile.returnEasyOne());
			arrStars[3]=(readerFile.returnEasyZero());
			arrStars[4]=(readerFile.returnNormalThree());
			arrStars[5]=(readerFile.returnNormalTwo());
			arrStars[6]=(readerFile.returnNormalOne());
			arrStars[7]=(readerFile.returnNormalZero());
			arrStars[8]=(readerFile.returnHardThree());
			arrStars[9]=(readerFile.returnHardTwo());
			arrStars[10]=(readerFile.returnHardOne());
			arrStars[11]=(readerFile.returnHardZero());
			started = readerFile.returnStartedGames();
			ended  = readerFile.returnStartedGames();
		}
		else {
			arrStars[0]=0;
			arrStars[1]=0;
			arrStars[2]=0;
			arrStars[3]=0;
			arrStars[4]=0;
			arrStars[5]=0;
			arrStars[6]=0;
			arrStars[7]=0;
			arrStars[8]=0;
			arrStars[9]=0;
			arrStars[10]=0;
			arrStars[11]=0;
			started=0;
			ended=0;
		}
		/*
		 0- easy three
		 1-     two
		 2-     one
		 3-     zero
		 4- normal three
		 5-     two
		 6-     one
		 7-     zero
		 8- hard three
		 9-     two
		 10-     one
		 11-     zero
		 */
		if(this.diff==0) { 
			if(game.playerSteps<=easyThree) {
				arrStars[0]+=1;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/threeStars.fxml"));
					Parent root;
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(game.playerSteps>easyThree&&game.playerSteps<=easyTwo) {
				arrStars[1]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/twoStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (game.playerSteps>easyTwo&&game.playerSteps<=easyOne) {
				arrStars[2]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/oneStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				arrStars[3]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/zeroStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if(this.diff==1) {
			if(game.playerSteps<=normalThree) {
				arrStars[4]+=1;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/threeStars.fxml"));
					Parent root;
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(game.playerSteps>normalThree&&game.playerSteps<=normalTwo) {
				arrStars[5]+=1;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/twoStars.fxml"));
					Parent root;
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (game.playerSteps>normalTwo&&game.playerSteps<=normalOne) {
				arrStars[6]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/oneStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				arrStars[7]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/zeroStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		else if (this.diff==2) {
			if(game.playerSteps<=hardThree) {
				arrStars[8]+=1;
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/threeStars.fxml"));
					Parent root;
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if(game.playerSteps>hardThree&&game.playerSteps<=hardTwo) {
				arrStars[9]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/twoStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			else if (game.playerSteps>hardTwo&&game.playerSteps<=hardOne) {
				arrStars[10]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/oneStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				arrStars[11]+=1;
				FXMLLoader loader = new FXMLLoader(getClass().getResource("scenes/zeroStars.fxml"));
				Parent root;
				try {
					root = loader.load();
					Stage stage = new Stage();
					stage.setScene(new Scene(root));
					stage.setTitle("Labyrinth Game");
					stage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		SaverFile saverFile = new SaverFile(arrStars,started,ended);
	}
}

