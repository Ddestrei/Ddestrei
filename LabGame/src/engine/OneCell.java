package engine;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class OneCell extends Rectangle{
	final int xLength=10; 
	final int yLength=10;
	public int state=0;
	public boolean isVisible=false;
	static Image border = new Image("Border.jpg");
	static Image bomb = new Image("Bomb.jpg");
	static Image path = new Image("Path.jpg");
	static Image start = new Image("Start.jpg");
	static Image meta = new Image("meta.jpg");
	static Image backGroung = new Image("backGroung.jpg");
	static Image player = new Image("Player.jpg");
	static Image advice = new Image("Bulb.jpg");
	static Image mainRoad = new Image("MainRoad.jpg");
	static Image torch = new Image("Torch.jpg");
	static ImagePattern pBorder = new ImagePattern(border);
	static ImagePattern pBomb = new ImagePattern(bomb);
	static ImagePattern pPath = new ImagePattern(path);
	static ImagePattern pStart = new ImagePattern(start);
	static ImagePattern pMeta = new ImagePattern(meta);
	static ImagePattern pBackGroung = new ImagePattern(backGroung);
	static ImagePattern pPlayer = new ImagePattern(player);
	static ImagePattern pAdvice = new ImagePattern(advice);
	static ImagePattern pMainRoad = new ImagePattern(mainRoad);
	static ImagePattern pTorch = new ImagePattern(torch);
	//0-border
	//1-path
	//2-player,start
	//3-meta
	//4-bomb
	//5-advice 
	//6-mainPath
	//7-torch
	public OneCell(int state,int diff){
		this.setHeight(yLength);
		this.setWidth(xLength);
		this.state= state;
		if(diff>0) {
			if(this.state==2) {
				this.setFill(pPlayer);
				//this.setImage(player);
				this.isVisible=true;
			}
			else {
				this.setFill(pBackGroung);
				//this.setImage(backGroung);
				this.isVisible=false;
			}
		}
		else {
			this.isVisible=true;
			switch(this.state) {
			case 0:
				this.setFill(pBorder);
				//this.setImage(border);
				break;
			case 1: 
				this.setFill(pPath);
				//this.setImage(path);
				break;
			case 2: 
				this.setFill(pPlayer);
				//this.setImage(player);
				break;
			case 3: 
				this.setFill(pMeta);
				//this.setImage(meta);
				break;
			case 4: 
				this.setFill(pBomb);
				//this.setImage(bomb);
				break;
			case 5:
				this.setFill(pAdvice);
				//this.setImage(advice);
				break;
			case 7:
				this.setFill(pTorch);
				//this.setImage(torch);
				break;
			}
			
		}
		//System.out.println(isVisible);
	}
	public void setLayout(Integer x,Integer y) {
		if(x==null&&y==null) {
			this.setX(0);
			this.setY(0);
		}
		else {
			this.setX(x.intValue());
			this.setY(y.intValue());	
		}
	}
	public void setPath() {
		this.setFill(pPath);
		//this.setImage(path);
		this.isVisible=true;
	}
	public void setStart() {
		this.setFill(pStart);
		//this.setImage(start);
		this.isVisible=true;
	}
	public void setBorder() {
		this.setFill(pBorder);
		//this.setImage(border);
		this.isVisible=true;
	}
	public void setMeta() {
		this.setFill(pMeta);
		//this.setImage(meta);
		this.isVisible=true;
	}
	public void setBlack() {
		this.setFill(pBackGroung);
		//this.setImage(backGroung);
		this.isVisible=false;
	}
	public void setBomb() {
		this.setFill(pBomb);
		//this.setImage(bomb);
		this.isVisible=true;
	}
	public void setAdvice() {
		this.setFill(pAdvice);
		//this.setImage(advice);
		this.isVisible=true;
	}
	public void setMainRoad() {
		this.setFill(pMainRoad);
		//this.setImage(mainRoad);
		this.isVisible=true;
	}
	public void setTorch() {
		this.setFill(pTorch);
		//this.setImage(torch);
		this.isVisible=true;
	}
}