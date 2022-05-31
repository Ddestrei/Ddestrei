package application;

import java.util.ArrayList;
import java.util.Random;

import engine.Creator;
import engine.OneCell;
import engine.Player;
import engine.PointClass;
import javafx.scene.Group;

public class GameScene extends Group{
	OneCell cellArr[][];
	int arrLab[][];
	Creator creator;
	int difficulty=0;
	int xPlayer;
	int yPlayer;
	int steps;
	Player player = new Player();
	int playerSteps=0;
	boolean end = false;
	int endPos=0;
	int mainSteaps[];
	int radius=1;
	ArrayList<PointClass> mainRoad;
	ArrayList<PointClass> advices;
	ArrayList<PointClass> torches;
	PointClass leftTop;
	int seenLengthHalf;
	int sceneXPlayer;
	int sceneYPlayer;
	boolean firstCheck=true;
	public GameScene(int diff,int XLength,int seenLength){
		difficulty=diff;
		seenLengthHalf = seenLength;
		cellArr = new OneCell[XLength+2][XLength+2];
		arrLab = new int[XLength+2][XLength+2];
		for (int i=0;i<=XLength+1;i++) {
			arrLab[i][0]=9;
			arrLab[i][XLength+1]=9;
			arrLab[0][i]=9;
			arrLab[XLength+1][i]=9;
		}
		int start=rand(XLength);
	 	for (int i=1;i<XLength-1;i++) {
	 		for (int j=1;j<XLength-1;j++) {
	 			arrLab[i][j]=0;
	 		}
	 	}
	 	if(start<seenLengthHalf/2) {
	 		leftTop = new PointClass(0,0);
	 	}
	 	else if(start>XLength-seenLengthHalf/2) {
	 		leftTop = new PointClass(XLength-seenLengthHalf,0);
	 	}
	 	else if(start<=100+seenLengthHalf/2||start>=seenLengthHalf/2) {
	 		leftTop = new PointClass(start-seenLengthHalf/2,0);
	 	}
	 	creator = new Creator(start,XLength,difficulty);
	 	xPlayer=start;
	 	yPlayer=0;
	 	arrLab[start][0]=2;
	 	endPos = creator.returnEnd();
	 	steps=creator.returnSteps();
	 	arrLab[creator.returnEnd()][XLength]=3;
	 	mainRoad = creator.returnMainRoad();
	 	advices = creator.returnAdvices();
	 	torches = creator.returnTorches();
	 	for (int i=0;i<=XLength;i++) {
			for(int j=0;j<=XLength;j++) {
				arrLab[i][j]=creator.returnArr(i, j);
	 			if(arrLab[i][j]==1) {
	 				OneCell c = new OneCell(1,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
	 			else if(arrLab[i][j]==0||arrLab[i][j]==9) {
	 				OneCell c =  new OneCell(0,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
	 			else if(arrLab[i][j]==2) {
	 				OneCell c =new OneCell(2,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
	 			else if(arrLab[i][j]==3) {
	 				OneCell c = new OneCell(3,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;		
	 			}
	 			else if(arrLab[i][j]==4) {
	 				OneCell c = new OneCell(4,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
	 			else if(arrLab[i][j]==5) {
	 				OneCell c = new OneCell(5,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
	 			else if(arrLab[i][j]==7) {
	 				OneCell c = new OneCell(7,diff);
	 				this.getChildren().add(c);
	 				cellArr[i][j]= c;
	 			}
			}
		}
	 	//	setNull();
	 	setScene();
	 	this.getChildren().add(player);
	 	if(diff>0) {
	 		refreshSeenMain(xPlayer,yPlayer,radius,XLength);
	 	}
	 	//System.out.println(player.getLayoutX());
	 			//System.out.println(player.getLayoutY());	
}
	private void setNull() {
		int x=leftTop.returnX();
		int y=leftTop.returnY();
		/*System.out.println(leftTop.returnX()+"X");
		System.out.println(leftTop.returnY()+"Y");
		System.out.println(end);*/
		for (int i=0;i<=seenLengthHalf;i++) {
			for (int j=0;j<=seenLengthHalf;j++) {
				cellArr[i+x][j+y].setLayout(null, null);
			}
		}
	}
	private void setScene() {
		int x=leftTop.returnX();
		int y=leftTop.returnY();
		/*System.out.println(leftTop.returnX()+"X");
		System.out.println(leftTop.returnY()+"Y");
		System.out.println(end);*/
		for (int i=0;i<=seenLengthHalf;i++) {
			for (int j=0;j<=seenLengthHalf;j++) {
				//System.out.println(i+"i");
				//System.out.println(j+"j");
				cellArr[i+x][j+y].setLayout(new Integer(i*10),new Integer(j*10));
				if(cellArr[i+x][j+y].state==2) {
					if(firstCheck==true) {
						sceneXPlayer=i;
						sceneYPlayer=j;
						player.setLayX(i*10);
						player.setLayY(j*10);
						firstCheck=false;
					}
				}
			}
		}
	}
	private static int rand(int max) {
		Random rand = new Random();
		int sum=0;
		for (int i=0;i<max;i++) {
			sum+=rand.nextInt(max);
		}
		
		return Math.abs(sum/max);
	}
	public void setEyeShot() {
		for (int i=0;i<torches.size();i++) {
			if(cellArr[torches.get(i).returnX()][torches.get(i).returnY()].isVisible==true) {
				cellArr[torches.get(i).returnX()][torches.get(i).returnY()].state=1;
				cellArr[torches.get(i).returnX()][torches.get(i).returnY()].setPath();
			}
			else {
				cellArr[torches.get(i).returnX()][torches.get(i).returnY()].state=1;
			}
		}
		radius+=1;
	}
	public void setAdvice(int XLength) {
		//System.out.println("Work");
		int a=0;
		for (int i=0;i<20*(XLength/100);i++) {
			int randNum=rand(30);
			a+=randNum;
			if(a<mainRoad.size()) {
				cellArr[mainRoad.get(a).returnX()][mainRoad.get(a).returnY()].state=6;
				if(cellArr[mainRoad.get(a).returnX()][mainRoad.get(a).returnY()].isVisible==true) {
					cellArr[mainRoad.get(a).returnX()][mainRoad.get(a).returnY()].setMainRoad();
				}
			}
		}
		for (int i=0;i<advices.size();i++) {
			if(cellArr[advices.get(i).returnX()][advices.get(i).returnY()].isVisible==true) {
				
				cellArr[advices.get(i).returnX()][advices.get(i).returnY()].state=1;
				cellArr[advices.get(i).returnX()][advices.get(i).returnY()].setPath();
			}
			else {
				cellArr[advices.get(i).returnX()][advices.get(i).returnY()].state=1;
			}
		}
	}
	public void refreshSeenMain(int x,int y,int radius,int XLength) {
		refrashSeenBasic(x,y,XLength);
		if(radius==2) {
			if(x-2>=0) {
				if(y-1>=0) {
					if(cellArr[x-2][y-1].state==2) {
						cellArr[x-2][y-1].setStart();
					}
					else if(cellArr[x-2][y-1].state==3) {
						cellArr[x-2][y-1].setMeta();
					}
					else if(cellArr[x-2][y-1].state==1) {
						cellArr[x-2][y-1].setPath();
					}
					else if(cellArr[x-2][y-1].state==0) {
						cellArr[x-2][y-1].setBorder();
					}
					else if(cellArr[x-2][y-1].state==4) {
						cellArr[x-2][y-1].setBomb();
					}
					else if(cellArr[x-2][y-1].state==5) {
						cellArr[x-2][y-1].setAdvice();
					}
					else if(cellArr[x-2][y-1].state==6) {
						cellArr[x-2][y-1].setMainRoad();
					}
					else if(cellArr[x-2][y-1].state==7) {
						cellArr[x-2][y-1].setTorch();
					}
				}
				if(y-2>=0) {
					if(cellArr[x-2][y-2].state==2) {
						cellArr[x-2][y-2].setStart();
					}
					else if(cellArr[x-2][y-2].state==3) {
						cellArr[x-2][y-2].setMeta();
					}
					else if(cellArr[x-2][y-2].state==1) {
						cellArr[x-2][y-2].setPath();
					}
					else if(cellArr[x-2][y-2].state==0) {
						cellArr[x-2][y-2].setBorder();
					}
					else if(cellArr[x-2][y-2].state==4) {
						cellArr[x-2][y-2].setBomb();
					}
					else if(cellArr[x-2][y-2].state==5) {
						cellArr[x-2][y-2].setAdvice();
					}
					else if(cellArr[x-2][y-2].state==6) {
						cellArr[x-2][y-2].setMainRoad();
					}
					else if(cellArr[x-2][y-2].state==7) {
						cellArr[x-2][y-2].setTorch();
					}
				}
				if(y+1<=XLength) {
					if(cellArr[x-2][y+1].state==2) {
						cellArr[x-2][y+1].setStart();
					}
					else if(cellArr[x-2][y+1].state==3) {
						cellArr[x-2][y+1].setMeta();
					}
					else if(cellArr[x-2][y+1].state==1) {
						cellArr[x-2][y+1].setPath();
					}
					else if(cellArr[x-2][y+1].state==0) {
						cellArr[x-2][y+1].setBorder();
					}
					else if(cellArr[x-2][y+1].state==4) {
						cellArr[x-2][y+1].setBomb();
					}
					else if(cellArr[x-2][y+1].state==5) {
						cellArr[x-2][y+1].setAdvice();
					}
					else if(cellArr[x-2][y+1].state==6) {
						cellArr[x-2][y+1].setMainRoad();
					}
					else if(cellArr[x-2][y+1].state==7) {
						cellArr[x-2][y+1].setTorch();
					}
				}
				if(y+2<=XLength) {
					if(cellArr[x-2][y+2].state==2) {
						cellArr[x-2][y+2].setStart();
					}
					else if(cellArr[x-2][y+2].state==3) {
						cellArr[x-2][y+2].setMeta();
					}
					else if(cellArr[x-2][y+2].state==1) {
						cellArr[x-2][y+2].setPath();
					}
					else if(cellArr[x-2][y+2].state==0) {
						cellArr[x-2][y+2].setBorder();
					}
					else if(cellArr[x-2][y+2].state==4) {
						cellArr[x-2][y+2].setBomb();
					}
					else if(cellArr[x-2][y+2].state==5) {
						cellArr[x-2][y+2].setAdvice();
					}
					else if(cellArr[x-2][y+2].state==6) {
						cellArr[x-2][y+2].setMainRoad();
					}
					else if(cellArr[x-2][y+2].state==7) {
						cellArr[x-2][y+2].setTorch();
					}
				}
				if(cellArr[x-2][y].state==2) {
					cellArr[x-2][y].setStart();
				}
				else if(cellArr[x-2][y].state==3) {
					cellArr[x-2][y].setMeta();
				}
				else if(cellArr[x-2][y].state==1) {
					cellArr[x-2][y].setPath();
				}
				else if(cellArr[x-2][y].state==0) {
					cellArr[x-2][y].setBorder();
				}
				else if(cellArr[x-2][y].state==4) {
					cellArr[x-2][y].setBomb();
				}
				else if(cellArr[x-2][y].state==5) {
					cellArr[x-2][y].setAdvice();
				}
				else if(cellArr[x-2][y].state==6) {
					cellArr[x-2][y].setMainRoad();
				}	
				else if(cellArr[x-2][y].state==7) {
					cellArr[x-2][y].setTorch();
				}	
			}
			if(x+2<=XLength) {
				if(y-1>=0) {
					if(cellArr[x+2][y-1].state==2) {
						cellArr[x+2][y-1].setStart();
					}
					else if(cellArr[x+2][y-1].state==3) {
						cellArr[x+2][y-1].setMeta();
					}
					else if(cellArr[x+2][y-1].state==1) {
						cellArr[x+2][y-1].setPath();
					}
					else if(cellArr[x+2][y-1].state==0) {
						cellArr[x+2][y-1].setBorder();
					}
					else if(cellArr[x+2][y-1].state==4) {
						cellArr[x+2][y-1].setBomb();
					}
					else if(cellArr[x+2][y-1].state==5) {
						cellArr[x+2][y-1].setAdvice();
					}
					else if(cellArr[x+2][y-1].state==6) {
						cellArr[x+2][y-1].setMainRoad();
					}
					else if(cellArr[x+2][y-1].state==7) {
						cellArr[x+2][y-1].setTorch();
					}
				}
				if(y-2>=0) {
					if(cellArr[x+2][y-2].state==2) {
						cellArr[x+2][y-2].setStart();
					}
					else if(cellArr[x+2][y-2].state==3) {
						cellArr[x+2][y-2].setMeta();
					}
					else if(cellArr[x+2][y-2].state==1) {
						cellArr[x+2][y-2].setPath();
					}
					else if(cellArr[x+2][y-2].state==0) {
						cellArr[x+2][y-2].setBorder();
					}
					else if(cellArr[x+2][y-2].state==4) {
						cellArr[x+2][y-2].setBomb();
					}
					else if(cellArr[x+2][y-2].state==5) {
						cellArr[x+2][y-2].setAdvice();
					}
					else if(cellArr[x+2][y-2].state==6) {
						cellArr[x+2][y-2].setMainRoad();
					}
					else if(cellArr[x+2][y-2].state==7) {
						cellArr[x+2][y-2].setTorch();
					}
				}
				if(y+1<=XLength) {
					if(cellArr[x+2][y+1].state==2) {
						cellArr[x+2][y+1].setStart();
					}
					else if(cellArr[x+2][y+1].state==3) {
						cellArr[x+2][y+1].setMeta();
					}
					else if(cellArr[x+2][y+1].state==1) {
						cellArr[x+2][y+1].setPath();
					}
					else if(cellArr[x+2][y+1].state==0) {
						cellArr[x+2][y+1].setBorder();
					}
					else if(cellArr[x+2][y+1].state==4) {
						cellArr[x+2][y+1].setBomb();
					}
					else if(cellArr[x+2][y+1].state==5) {
						cellArr[x+2][y+1].setAdvice();
					}
					else if(cellArr[x+2][y+1].state==6) {
						cellArr[x+2][y+1].setMainRoad();
					}
					else if(cellArr[x+2][y+1].state==7) {
						cellArr[x+2][y+1].setTorch();
					}
				}
				if(y+2<=XLength) {
					if(cellArr[x+2][y+2].state==2) {
						cellArr[x+2][y+2].setStart();
					}
					else if(cellArr[x+2][y+2].state==3) {
						cellArr[x+2][y+2].setMeta();
					}
					else if(cellArr[x+2][y+2].state==1) {
						cellArr[x+2][y+2].setPath();
					}
					else if(cellArr[x+2][y+2].state==0) {
						cellArr[x+2][y+2].setBorder();
					}
					else if(cellArr[x+2][y+2].state==4) {
						cellArr[x+2][y+2].setBomb();
					}
					else if(cellArr[x+2][y+2].state==5) {
						cellArr[x+2][y+2].setAdvice();
					}
					else if(cellArr[x+2][y+2].state==6) {
						cellArr[x+2][y+2].setMainRoad();
					}
					else if(cellArr[x+2][y+2].state==7) {
						cellArr[x+2][y+2].setTorch();
					}
				}
				if(cellArr[x+2][y].state==2) {
					cellArr[x+2][y].setStart();
				}
				else if(cellArr[x+2][y].state==3) {
					cellArr[x+2][y].setMeta();
				}
				else if(cellArr[x+2][y].state==1) {
					cellArr[x+2][y].setPath();
				}
				else if(cellArr[x+2][y].state==0) {
					cellArr[x+2][y].setBorder();
				}
				else if(cellArr[x+2][y].state==4) {
					cellArr[x+2][y].setBomb();
				}
				else if(cellArr[x+2][y].state==5) {
					cellArr[x+2][y].setAdvice();
				}
				else if(cellArr[x+2][y].state==6) {
					cellArr[x+2][y].setMainRoad();
				}
				else if(cellArr[x+2][y].state==7) {
					cellArr[x+2][y].setTorch();
				}
			}
			if(y-2>=0) {
				if(x-1>=0) {
					if(cellArr[x-1][y-2].state==2) {
						cellArr[x-1][y-2].setStart();
					}
					else if(cellArr[x-1][y-2].state==3) {
						cellArr[x-1][y-2].setMeta();
					}
					else if(cellArr[x-1][y-2].state==1) {
						cellArr[x-1][y-2].setPath();
					}
					else if(cellArr[x-1][y-2].state==0) {
						cellArr[x-1][y-2].setBorder();
					}
					else if(cellArr[x-1][y-2].state==4) {
						cellArr[x-1][y-2].setBomb();
					}
					else if(cellArr[x-1][y-2].state==5) {
						cellArr[x-1][y-2].setAdvice();
					}
					else if(cellArr[x-1][y-2].state==6) {
						cellArr[x-1][y-2].setMainRoad();
					}
					else if(cellArr[x-1][y-2].state==7) {
						cellArr[x-1][y-2].setTorch();
					}
				}
				if(x+1<=XLength) {
					if(cellArr[x+1][y-2].state==2) {
						cellArr[x+1][y-2].setStart();
					}
					else if(cellArr[x+1][y-2].state==3) {
						cellArr[x+1][y-2].setMeta();
					}
					else if(cellArr[x+1][y-2].state==1) {
						cellArr[x+1][y-2].setPath();
					}
					else if(cellArr[x+1][y-2].state==0) {
						cellArr[x+1][y-2].setBorder();
					}
					else if(cellArr[x+1][y-2].state==4) {
						cellArr[x+1][y-2].setBomb();
					}
					else if(cellArr[x+1][y-2].state==5) {
						cellArr[x+1][y-2].setAdvice();
					}
					else if(cellArr[x+1][y-2].state==6) {
						cellArr[x+1][y-2].setMainRoad();
					}
					else if(cellArr[x+1][y-2].state==7) {
						cellArr[x+1][y-2].setTorch();
					}
				}
				if(cellArr[x][y-2].state==2) {
					cellArr[x][y-2].setStart();
				}
				else if(cellArr[x][y-2].state==3) {
					cellArr[x][y-2].setMeta();
				}
				else if(cellArr[x][y-2].state==1) {
					cellArr[x][y-2].setPath();
				}
				else if(cellArr[x][y-2].state==0) {
					cellArr[x][y-2].setBorder();
				}
				else if(cellArr[x][y-2].state==4) {
					cellArr[x][y-2].setBomb();
				}
				else if(cellArr[x][y-2].state==5) {
					cellArr[x][y-2].setAdvice();
				}
				else if(cellArr[x][y-2].state==6) {
					cellArr[x][y-2].setMainRoad();
				}
				else if(cellArr[x][y-2].state==7) {
					cellArr[x][y-2].setMainRoad();
				}
			}
			if(y+2<=XLength) {
				if(x-1>=0) {
					if(cellArr[x-1][y+2].state==2) {
						cellArr[x-1][y+2].setStart();
					}
					else if(cellArr[x-1][y+2].state==3) {
						cellArr[x-1][y+2].setMeta();
					}
					else if(cellArr[x-1][y+2].state==1) {
						cellArr[x-1][y+2].setPath();
					}
					else if(cellArr[x-1][y+2].state==0) {
						cellArr[x-1][y+2].setBorder();
					}
					else if(cellArr[x-1][y+2].state==4) {
						cellArr[x-1][y+2].setBomb();
					}
					else if(cellArr[x-1][y+2].state==5) {
						cellArr[x-1][y+2].setAdvice();
					}
					else if(cellArr[x-1][y+2].state==6) {
						cellArr[x-1][y+2].setMainRoad();
					}
					else if(cellArr[x-1][y+2].state==7) {
						cellArr[x-1][y+2].setMainRoad();
					}
				}
				if(x+1<=XLength) {
					if(cellArr[x+1][y+2].state==2) {
						cellArr[x+1][y+2].setStart();
					}
					else if(cellArr[x+1][y+2].state==3) {
						cellArr[x+1][y+2].setMeta();
					}
					else if(cellArr[x+1][y+2].state==1) {
						cellArr[x+1][y+2].setPath();
					}
					else if(cellArr[x+1][y+2].state==0) {
						cellArr[x+1][y+2].setBorder();
					}
					else if(cellArr[x+1][y+2].state==4) {
						cellArr[x+1][y+2].setBomb();
					}
					else if(cellArr[x+1][y+2].state==5) {
						cellArr[x+1][y+2].setAdvice();
					}
					else if(cellArr[x+1][y+2].state==6) {
						cellArr[x+1][y+2].setMainRoad();
					}
					else if(cellArr[x+1][y+2].state==7) {
						cellArr[x+1][y+2].setTorch();
					}
				}
				if(cellArr[x][y+2].state==2) {
					cellArr[x][y+2].setStart();
				}
				else if(cellArr[x][y+2].state==3) {
					cellArr[x][y+2].setMeta();
				}
				else if(cellArr[x][y+2].state==1) {
					cellArr[x][y+2].setPath();
				}
				else if(cellArr[x][y+2].state==0) {
					cellArr[x][y+2].setBorder();
				}
				else if(cellArr[x][y+2].state==4) {
					cellArr[x][y+2].setBomb();
				}
				else if(cellArr[x][y+2].state==5) {
					cellArr[x][y+2].setAdvice();
				}
				else if(cellArr[x][y+2].state==6) {
					cellArr[x][y+2].setMainRoad();
				}
				else if(cellArr[x][y+2].state==7) {
					cellArr[x][y+2].setTorch();
				}
			}
		}
	}
	public void refrashSeenBasic(int x,int y,int XLength) {
		if(x-1>=0) {
			if(cellArr[x-1][y].state==2) {
				cellArr[x-1][y].setStart();
			}
			else if(cellArr[x-1][y].state==3) {
				cellArr[x-1][y].setMeta();
			}
			else if(cellArr[x-1][y].state==1) {
				cellArr[x-1][y].setPath();
			}
			else if(cellArr[x-1][y].state==0) {
				cellArr[x-1][y].setBorder();
			}
			else if(cellArr[x-1][y].state==4) {
				cellArr[x-1][y].setBomb();
			}
			else if(cellArr[x-1][y].state==5) {
				cellArr[x-1][y].setAdvice();
			}
			else if(cellArr[x-1][y].state==6) {
				cellArr[x-1][y].setMainRoad();
			}
			else if(cellArr[x-1][y].state==7) {
				cellArr[x-1][y].setTorch();
			}
		}
		if(x+1<=XLength) {
			if(cellArr[x+1][y].state==2) {
				cellArr[x+1][y].setStart();
			}
			else if(cellArr[x+1][y].state==3) {
				cellArr[x+1][y].setMeta();
			}
			else if(cellArr[x+1][y].state==1) {
				cellArr[x+1][y].setPath();
			}
			else if(cellArr[x+1][y].state==0) {
				cellArr[x+1][y].setBorder();
			}
			else if(cellArr[x+1][y].state==4) {
				cellArr[x+1][y-1].setBomb();
			}
			else if(cellArr[x+1][y].state==5) {
				cellArr[x+1][y].setAdvice();
			}
			else if(cellArr[x+1][y].state==6) {
				cellArr[x+1][y].setMainRoad();
			}
			else if(cellArr[x+1][y].state==7) {
				cellArr[x+1][y].setTorch();
			}
		}
		if(y-1>=0) {
			if(cellArr[x][y-1].state==2) {
				cellArr[x][y-1].setStart();
			}
			else if(cellArr[x][y-1].state==3) {
				cellArr[x][y-1].setMeta();
			}
			else if(cellArr[x][y-1].state==1) {
				cellArr[x][y-1].setPath();
			}
			else if(cellArr[x][y-1].state==0) {
				cellArr[x][y-1].setBorder();
			}
			else if(cellArr[x][y-1].state==4) {
				cellArr[x][y-1].setBomb();
			}
			else if(cellArr[x][y-1].state==5) {
				cellArr[x][y-1].setAdvice();
			}
			else if(cellArr[x][y-1].state==6) {
				cellArr[x][y-1].setMainRoad();
			}
			else if(cellArr[x][y-1].state==7) {
				cellArr[x][y-1].setTorch();
			}
		}
		if(y+1<=XLength) {
			if(cellArr[x][y+1].state==2) {
				cellArr[x][y+1].setStart();
			}
			else if(cellArr[x][y+1].state==3) {
				cellArr[x][y+1].setMeta();
			}
			else if(cellArr[x][y+1].state==1) {
				cellArr[x][y+1].setPath();
			}
			else if(cellArr[x][y+1].state==0) {
				cellArr[x][y+1].setBorder();
			}
			else if(cellArr[x][y+1].state==4) {
				cellArr[x][y+1].setBomb();
			}
			else if(cellArr[x][y+1].state==5) {
				cellArr[x][y+1].setAdvice();
			}
			else if(cellArr[x][y+1].state==6) {
				cellArr[x][y+1].setMainRoad();
			}
			else if(cellArr[x][y+1].state==7) {
				cellArr[x][y+1].setTorch();
			}
		}
		if(x-1>=0&&y-1>=0) {
			if(cellArr[x-1][y-1].state==2) {
				cellArr[x-1][y-1].setStart();
			}
			else if(cellArr[x-1][y-1].state==3) {
				cellArr[x-1][y-1].setMeta();
			}
			else if(cellArr[x-1][y-1].state==1) {
				cellArr[x-1][y-1].setPath();
			}
			else if(cellArr[x-1][y-1].state==0) {
				cellArr[x-1][y-1].setBorder();
			}
			else if(cellArr[x-1][y-1].state==4) {
				cellArr[x-1][y-1].setBomb();
			}
			else if(cellArr[x-1][y-1].state==5) {
				cellArr[x-1][y-1].setAdvice();
			}
			else if(cellArr[x-1][y-1].state==6) {
				cellArr[x-1][y-1].setMainRoad();
			}
			else if(cellArr[x-1][y-1].state==7) {
				cellArr[x-1][y-1].setTorch();
			}
		}
		if(x-1>=0&&y+1<=XLength) {
			if(cellArr[x-1][y+1].state==2) {
				cellArr[x-1][y+1].setStart();
			}
			else if(cellArr[x-1][y+1].state==3) {
				cellArr[x-1][y+1].setMeta();
			}
			else if(cellArr[x-1][y+1].state==1) {
				cellArr[x-1][y+1].setPath();
			}
			else if(cellArr[x-1][y+1].state==0) {
				cellArr[x-1][y+1].setBorder();
			}
			else if(cellArr[x-1][y+1].state==4) {
				cellArr[x-1][y+1].setBomb();
			}
			else if(cellArr[x-1][y+1].state==5) {
				cellArr[x-1][y+1].setAdvice();
			}
			else if(cellArr[x-1][y+1].state==6) {
				cellArr[x-1][y+1].setMainRoad();
			}
			else if(cellArr[x-1][y+1].state==7) {
				cellArr[x-1][y+1].setTorch();
			}
		}
		if(x+1<=XLength&&y-1>=0) {
			if(cellArr[x+1][y-1].state==2) {
				cellArr[x+1][y-1].setStart();
			}
			else if(cellArr[x+1][y-1].state==3) {
				cellArr[x+1][y-1].setMeta();
			}
			else if(cellArr[x+1][y-1].state==1) {
				cellArr[x+1][y-1].setPath();
			}
			else if(cellArr[x+1][y-1].state==0) {
				cellArr[x+1][y-1].setBorder();
			}
			else if(cellArr[x+1][y-1].state==4) {
				cellArr[x+1][y-1].setBomb();
			}
			else if(cellArr[x+1][y-1].state==5) {
				cellArr[x+1][y-1].setAdvice();
			}
			else if(cellArr[x+1][y-1].state==6) {
				cellArr[x+1][y-1].setMainRoad();
			}
			else if(cellArr[x+1][y-1].state==7) {
				cellArr[x+1][y-1].setTorch();
			}
		}
		if(x+1<=XLength&&y+1<=XLength) {
			if(cellArr[x+1][y+1].state==2) {
				cellArr[x+1][y+1].setStart();
			}
			else if(cellArr[x+1][y+1].state==3) {
				cellArr[x+1][y+1].setMeta();
			}
			else if(cellArr[x+1][y+1].state==1) {
				cellArr[x+1][y+1].setPath();
			}
			else if(cellArr[x+1][y+1].state==0) {
				cellArr[x+1][y+1].setBorder();
			}
			else if(cellArr[x+1][y+1].state==4) {
				cellArr[x+1][y+1].setBomb();
			}
			else if(cellArr[x+1][y+1].state==5) {
				cellArr[x+1][y+1].setAdvice();
			}
			else if(cellArr[x+1][y+1].state==6) {
				cellArr[x+1][y+1].setMainRoad();
			}
			else if(cellArr[x+1][y+1].state==7) {
				cellArr[x+1][y+1].setTorch();
			}
		}
	}
	public void useBomb(int x,int y,int XLength) {
		cellArr[x][y].setPath();
		cellArr[x][y].state=1;
		if(x-1>=0) {
			if(cellArr[x-1][y].state!=3) {
				cellArr[x-1][y].setPath();
				cellArr[x-1][y].state=1;
			}
		}
		if(x+1<=XLength) {
			if(cellArr[x+1][y].state!=3) {
				cellArr[x+1][y].setPath();
				cellArr[x+1][y].state=1;
			}
		}
		if(y-1>=0) {
			if(cellArr[x][y-1].state!=3) {
				cellArr[x][y-1].setPath();
				cellArr[x][y-1].state=1;
			}
		}
		if(y+1<=XLength) {
			if(cellArr[x][y+1].state!=3) {
				cellArr[x][y+1].setPath();
				cellArr[x][y+1].state=1;
			}
		}
		if(x-1>=0&&y-1>=0) {
			if(cellArr[x-1][y-1].state!=3) {
				cellArr[x-1][y-1].setPath();
				cellArr[x-1][y-1].state=1;
			}
		}
		if(x-1>=0&&y+1<=XLength) {
			if(cellArr[x-1][y+1].state!=3) {
				cellArr[x-1][y+1].setPath();
				cellArr[x-1][y+1].state=1;
			}
		}
		if(x+1<=XLength&&y-1>=0) {
			if(cellArr[x+1][y-1].state!=3) {
				cellArr[x+1][y-1].setPath();
				cellArr[x+1][y-1].state=1;
			}
		}
		if(x+1<=XLength&&y+1<=XLength) {
			if(cellArr[x+1][y+1].state!=3) {
				cellArr[x+1][y+1].setPath();
				cellArr[x+1][y+1].state=1;
			}
		}
	}
	public void moveW(int XLength) {
		if(yPlayer>0) {
			if(cellArr[xPlayer][yPlayer-1].state==1||cellArr[xPlayer][yPlayer-1].state==2||cellArr[xPlayer][yPlayer-1].state==4||cellArr[xPlayer][yPlayer-1].state==5||cellArr[xPlayer][yPlayer-1].state==6||cellArr[xPlayer][yPlayer-1].state==7) {
				//System.out.println("W");
				if(sceneYPlayer>seenLengthHalf/2) {
					sceneYPlayer-=1;
					player.move(sceneXPlayer*10, sceneYPlayer*10);
					yPlayer-=1;
				}
				else if(sceneYPlayer<=seenLengthHalf/2) {
					if(leftTop.returnY()>0) {
						setNull();
						leftTop.setY(leftTop.returnY()-1);
						yPlayer-=1;
						setScene();
					}
					else {
						sceneYPlayer-=1;
						player.move(sceneXPlayer*10,sceneYPlayer*10);
						yPlayer-=1;
					}
				}
				if(difficulty>1) {
					if(radius==1) {
						if(yPlayer>=2) {
							cellArr[xPlayer][yPlayer+2].setBlack();
							cellArr[xPlayer-1][yPlayer+2].setBlack();
							cellArr[xPlayer+1][yPlayer+2].setBlack();
						}	
					}
					else if (radius==2) {
						if(yPlayer>=3) {
							cellArr[xPlayer-2][yPlayer+3].setBlack();
							cellArr[xPlayer][yPlayer+3].setBlack();
							cellArr[xPlayer-1][yPlayer+3].setBlack();
							cellArr[xPlayer+1][yPlayer+3].setBlack();
							cellArr[xPlayer+2][yPlayer+3].setBlack();
						}
					}
				}
				playerSteps+=1;
				if(cellArr[xPlayer][yPlayer].state==4) {
					useBomb(xPlayer,yPlayer,XLength);
				}
				if(cellArr[xPlayer][yPlayer].state==5) {
					setAdvice(XLength);
				}
				if(cellArr[xPlayer][yPlayer].state==7) {
					setEyeShot();
				}
			}
		}
		refreshSeenMain(xPlayer,yPlayer,radius,XLength);
		//System.out.println(player.getLayoutX());
		//System.out.println(player.getLayoutY());
		//System.out.println(leftTop.returnX()+"X");
		//System.out.println(leftTop.returnY()+"Y");
		//System.out.println("MOve");
	}
	public void moveS(int XLength) {
		if(cellArr[xPlayer][yPlayer+1].state==1||cellArr[xPlayer][yPlayer+1].state==3||cellArr[xPlayer][yPlayer+1].state==4||cellArr[xPlayer][yPlayer+1].state==5||cellArr[xPlayer][yPlayer+1].state==6||cellArr[xPlayer][yPlayer+1].state==7) {
			//System.out.println("W");
			if(sceneYPlayer<seenLengthHalf/2) {
				sceneYPlayer+=1;
				player.move(sceneXPlayer*10,sceneYPlayer*10);
				yPlayer+=1;
			}
			else if(sceneYPlayer>=seenLengthHalf/2) {
				if(leftTop.returnY()<XLength-seenLengthHalf) {
					setNull();
					leftTop.setY(leftTop.returnY()+1);
					yPlayer+=1;
					setScene();
				}
				else {
					sceneYPlayer+=1;
					player.move(sceneXPlayer*10,sceneYPlayer*10);
					yPlayer+=1;
				}
			}
			if(difficulty>1) { 
				if(radius==1) {
					if(yPlayer>=2) {
						cellArr[xPlayer][yPlayer-2].setBlack();
						cellArr[xPlayer-1][yPlayer-2].setBlack();
						cellArr[xPlayer+1][yPlayer-2].setBlack();
					}	
				}
				else if (radius==2) {
					if(yPlayer>=3) {
						cellArr[xPlayer-2][yPlayer-3].setBlack();
						cellArr[xPlayer][yPlayer-3].setBlack();
						cellArr[xPlayer-1][yPlayer-3].setBlack();
						cellArr[xPlayer+1][yPlayer-3].setBlack();
						cellArr[xPlayer+2][yPlayer-3].setBlack();
					}
				}
			}
			playerSteps+=1;
			if(cellArr[xPlayer][yPlayer].state==4) {
				useBomb(xPlayer,yPlayer,XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==5) {
				setAdvice(XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==7) {
				setEyeShot();
			}
		}
		if(cellArr[xPlayer][yPlayer].state==3) {
			end=true;
		}
		refreshSeenMain(xPlayer,yPlayer,radius,XLength);
		//System.out.println(player.getLayoutX());
				//System.out.println(player.getLayoutY());
		//System.out.println(leftTop.returnX()+"X");
				//System.out.println(leftTop.returnY()+"Y");
				//System.out.println("MOve");
	}
	public void moveA(int XLength) {
		if(cellArr[xPlayer-1][yPlayer].state==1||cellArr[xPlayer-1][yPlayer].state==4||cellArr[xPlayer-1][yPlayer].state==5||cellArr[xPlayer-1][yPlayer].state==6||cellArr[xPlayer-1][yPlayer].state==7) {
			//System.out.println("W");
			if(sceneXPlayer>seenLengthHalf/2) {
				sceneXPlayer-=1;
				player.move(sceneXPlayer*10, sceneYPlayer*10);
				xPlayer-=1;
			}
			else if(sceneXPlayer<=seenLengthHalf/2) {
				if(leftTop.returnX()>0) {
					setNull();
					leftTop.setX(leftTop.returnX()-1);
					xPlayer-=1;
					setScene();
				}
				else {
					sceneXPlayer-=1;
					player.move(sceneXPlayer*10, sceneYPlayer*10);
					xPlayer-=1;
				}
			}
			if(difficulty>1) {
				if(radius==1) {
					if(xPlayer>=2) {
						cellArr[xPlayer+2][yPlayer].setBlack();
						cellArr[xPlayer+2][yPlayer+1].setBlack();
						cellArr[xPlayer+2][yPlayer-1].setBlack();
					}	
				}
				else if (radius==2) {
					if(xPlayer>=3) {
						cellArr[xPlayer+3][yPlayer].setBlack();
						cellArr[xPlayer+3][yPlayer+1].setBlack();
						cellArr[xPlayer+3][yPlayer+2].setBlack();
						cellArr[xPlayer+3][yPlayer-1].setBlack();
						cellArr[xPlayer+3][yPlayer-2].setBlack();
					}
				}
			}
			playerSteps+=1;
			if(cellArr[xPlayer][yPlayer].state==4) {
				useBomb(xPlayer,yPlayer,XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==5) {
				setAdvice(XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==7) {
				setEyeShot();
			}
		}
		refreshSeenMain(xPlayer,yPlayer,radius,XLength);
		//System.out.println(player.getLayoutX());
				//System.out.println(player.getLayoutY());
		//System.out.println(leftTop.returnX()+"X");
				//System.out.println(leftTop.returnY()+"Y");
				//System.out.println("MOve");
	}
	public void moveD(int XLength) {
		if(cellArr[xPlayer+1][yPlayer].state==1||cellArr[xPlayer+1][yPlayer].state==4||cellArr[xPlayer+1][yPlayer].state==5||cellArr[xPlayer+1][yPlayer].state==6||cellArr[xPlayer+1][yPlayer].state==7) {
			//System.out.println("W");
			if(sceneXPlayer<seenLengthHalf/2) {
				sceneXPlayer+=1;
				player.move(sceneXPlayer*10,sceneYPlayer*10);
				xPlayer+=1;
			}
			else if(sceneXPlayer>=seenLengthHalf/2) {
				if(leftTop.returnX()<XLength-seenLengthHalf) {
					setNull();
					leftTop.setX(leftTop.returnX()+1);
					xPlayer+=1;
					setScene();
				}
				else {
					sceneXPlayer+=1;
					player.move(sceneXPlayer*10,sceneYPlayer*10);
					xPlayer+=1;
				}
			}
			if(difficulty>1) {
				if(radius==1) {
					if(xPlayer>=2) {
						cellArr[xPlayer-2][yPlayer].setBlack();
						cellArr[xPlayer-2][yPlayer+1].setBlack();
						cellArr[xPlayer-2][yPlayer-1].setBlack();
					}	
				}
				else if (radius==2) {
					if(xPlayer>=3) {
						cellArr[xPlayer-3][yPlayer].setBlack();
						cellArr[xPlayer-3][yPlayer+1].setBlack();
						cellArr[xPlayer-3][yPlayer+2].setBlack();
						cellArr[xPlayer-3][yPlayer-1].setBlack();
						cellArr[xPlayer-3][yPlayer-2].setBlack();
					}
				}
			}
			playerSteps+=1;
			if(cellArr[xPlayer][yPlayer].state==4) {
				useBomb(xPlayer,yPlayer,XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==5) {
				setAdvice(XLength);
			}
			if(cellArr[xPlayer][yPlayer].state==7) {
				setEyeShot();
			}
		}
		refreshSeenMain(xPlayer,yPlayer,radius,XLength);
		//System.out.println(player.getLayoutX());
				//System.out.println(player.getLayoutY());
		//System.out.println(leftTop.returnX()+"X");
				//System.out.println(leftTop.returnY()+"Y");
				//System.out.println("MOve");
	}
}
