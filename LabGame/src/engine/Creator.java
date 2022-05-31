package engine;

import java.util.ArrayList;
import java.util.Random;
 
public class Creator {
	int arrLab[][];
	int steps=0;
	int end=0;
	// 0-border
	// 1-path
	// 2-start
	// 3-end
	// 4-bomb
	// 5-teleport
	int mainSteps[];
	int difficulty;
	ArrayList<PointClass> mainRoad;
	ArrayList<PointClass> advices;
	ArrayList<PointClass> torches;
	public Creator(int start,int XLength,int diff){
		difficulty=diff;
		arrLab=new int [XLength+1][XLength+1];
		mainRoad = new ArrayList<PointClass>();
		advices = new ArrayList<PointClass>();
		torches = new ArrayList<PointClass>();
		end=setMainRoad(start,XLength,1);
		setRestRoad(XLength);
		arrLab[start][0]=2;
		arrLab[end][XLength]=3;
		addPawers(XLength);
		mainSteps = new int [steps]; 
	}
	public void addPawers(int XLength) {
		for (int i=0;i<20*(XLength/100);) {
			int x=rand(XLength)+1;
			int y=rand(XLength)+1;
			if(arrLab[x][y]==1) {
				arrLab[x][y]=4;
				i+=1;
			}
		}
		for (int i=0;i<5*(XLength/100);) {
			int x=rand(XLength)+1;
			int y=rand(XLength)+1;
			if(arrLab[x][y]==1) {
				arrLab[x][y]=5;
				advices.add(new PointClass(x,y));
				i+=1;
			}
		}
		if(difficulty>0) {
			for (int i=0;i<20*(XLength/100);) {
				int x=rand(XLength)+1;
				int y=rand(XLength)+1;
				if(arrLab[x][y]==1) {
					arrLab[x][y]=7;
					torches.add(new PointClass(x,y));
					i+=1;
				}
			}
		}
	}
	public ArrayList<PointClass> returnTorches(){
		return torches;
	}
	public int returnArr(int x,int y) {
		return arrLab[x][y];
	}
	public int returnEnd() {
		return end;
	}
	public int returnSteps() {
		return steps;
	}
	public ArrayList<PointClass> returnAdvices() {
		return advices;
	}
	public ArrayList<PointClass> returnMainRoad() {
		return mainRoad;
	}
	public int setMainRoad(int currX,int XLength,int currY) {
		arrLab[currX][currY]=1;
		mainRoad.add(new PointClass(currX,currY));
		if(currY==XLength-1) {
			return currX;
		}
		else {
			/*int randNum=rand(30);
			if(randNum<10) {
				firstType(currX,XLength,currY);
			}
			else if(randNum<20) {
				secondType(currX,XLength,currY);
			}
			else if(randNum<30) {
				thirthType(currX,XLength,currY);
			}*/
			if(currX-1>=1) {
				if(checkNieghbor(currX-1,currY,XLength)<=1) {
					int randSecondNum=rand(20);
					if(randSecondNum<10) {
						currX-=1;
						steps+=1;
						return setMainRoad(currX,XLength,currY);
					}
				}
			}

			if(currX+1<=XLength) {
				if(checkNieghbor(currX+1,currY,XLength)<=1) {
					int randSecondNum=rand(20);
					if(randSecondNum<10) {
						currX+=1;
						steps+=1;
						return setMainRoad(currX,XLength,currY);
					}
				}
			}
			if(currY+1<=XLength) {
				if(checkNieghbor(currX,currY+1,XLength)<=1) {
					currY+=1;
					steps+=1;
					return setMainRoad(currX,XLength,currY);
				}
			} 
		}
		return 0;
	}
	/*public void firstType(int currX,int XLength,int currY) {
		if(currX+1<=XLength) {
			if(checkNieghbor(currX+1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX+=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currX-1>=1) {
			if(checkNieghbor(currX-1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX-=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currY+1<=XLength) {
			if(checkNieghbor(currX,currY+1,XLength)<=1) {
				currY+=1;
				steps+=1;
				setMainRoad(currX,XLength,currY);
			}
		}
	}
	public void secondType(int currX,int XLength,int currY) {
		if(currX-1>=1) {
			if(checkNieghbor(currX-1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX-=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currX+1<=XLength) {
			if(checkNieghbor(currX+1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX+=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currY+1<=XLength) {
			if(checkNieghbor(currX,currY+1,XLength)<=1) {
				currY+=1;
				steps+=1;
				setMainRoad(currX,XLength,currY);
			}
		}
	}
	public void thirthType(int currX,int XLength,int currY) {
		if(currX+1<=XLength) {
			if(checkNieghbor(currX+1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX+=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currY+1<=XLength) {
			if(checkNieghbor(currX,currY+1,XLength)<=1) {
				currY+=1;
				steps+=1;
				setMainRoad(currX,XLength,currY);
			}
		}
		if(currX-1>=1) {
			if(checkNieghbor(currX-1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX-=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
	}*/
	public void setRestRoad(int XLength) {
		for (int i=1;i<XLength-1;i++) {
			for (int j=1;j<XLength-1;j++) {
				if(checkAllNeighbor(i,j,XLength)<=3) {
					int xPos=i;
					int yPos=j;
					boolean z=true;
					ArrayList<Integer> moves = new ArrayList<Integer>();
					ArrayList<Integer> moves2 = new ArrayList<Integer>();
					while (z==true) {
						if(xPos-1>=0) {
						//1	
							if(checkNieghbor(xPos-1,yPos,XLength)==0) {
								moves.add(1);
							}
							else if(checkNieghbor(xPos-1,yPos,XLength)<=2) {
								moves2.add(1);
								z=false;
							}
							else {
								z=false;
							}
						}
						if(xPos+1<=XLength) {
						//2	
							if(checkNieghbor(xPos+1,yPos,XLength)==0) {
								moves.add(2);
							}
							else if(checkNieghbor(xPos+1,yPos,XLength)<=2) {
								moves2.add(2);
								z=false;
							}
							else {
								z=false;
							}
						}
						if(yPos+1<=XLength) {
						//3
							if(checkNieghbor(xPos,yPos+1,XLength)==0) {
								moves.add(4);
							}
							else if(checkNieghbor(xPos,yPos+1,XLength)<=2) {
								moves2.add(4);
								z=false;
							}
							else {
								z=false;
							}
						}
						if(z==true) {
							int randSecondNum1=randSecond(moves.size());
							if(moves.get(randSecondNum1)==0) {
								arrLab[xPos-1][yPos]=1;
								xPos-=1;
							}
							else if(moves.get(randSecondNum1)==1) {
								arrLab[xPos+1][yPos]=1;
								xPos+=1;
							}
							else if(moves.get(randSecondNum1)==2) {
								arrLab[xPos][yPos+1]=1;
								yPos+=1;
							}
						}
						else if (z==false && moves2.size()!=0) {
							int randSecondNum1=randSecond(moves2.size());
							if(moves2.get(randSecondNum1)==0) {
								arrLab[xPos-1][yPos]=1;
								xPos-=1;
							}
							else if(moves2.get(randSecondNum1)==1) {
								arrLab[xPos+1][yPos]=1;
								xPos+=1;
							}
							else if(moves2.get(randSecondNum1)==2) {
								arrLab[xPos][yPos+1]=1;
								yPos+=1;
							}
						}
					}
				}
			}
		}
	}
	public static int rand(int max) {
		Random rand = new Random();
		return rand.nextInt(max);
	}
	public static int randSecond(int max) {
		Random rand = new Random();
		int sum=0;
		for (int i=0;i<10;i++) {
			sum+=rand.nextInt(max);
		}
		return Math.abs(sum/10);
	}
	private int checkAllNeighbor(int x,int y, int XLength) {
		int point=0;
		if(x-1>=0) {
			if(y-1>=0) {
				if(arrLab[x-1][y-1]==1) {
					point+=1;
				}
			}
			if(arrLab[x-1][y]==1) {
				point+=1;
			}
		}
		if(y-1>=0) {
			if(x+1<=XLength) {
				if(arrLab[x+1][y-1]==1) {
					point+=1;
				}
			}
			if(arrLab[x][y-1]==1) {
				point+=1;
			}
		}
		if(x+1<=XLength) {
			if(y-1>=0) {
				if(arrLab[x+1][y-1]==1) {
					point+=1;
				}
			}
			if(arrLab[x+1][y]==1) {
				point+=1;
			}
		}
		if(y+1<=XLength) {
			if(x-1>=0) {
				if(arrLab[x-1][y+1]==1) {
					point+=1;
				}
			}
			if(arrLab[x][y+1]==1) {
				point+=1;
			}
		}
		return point;
	}
	private int checkNieghbor(int x, int y,int XLength) {
		int point=0;
		if(x-1>=0) {
			if(arrLab[x-1][y]==1) {
				point+=1;
			}
		}
		if(x+1<=XLength) {
			if(arrLab[x+1][y]==1) {
				point+=1;
			}
		}
		if(y-1>=0) {
			if(arrLab[x][y-1]==1) {
				point+=1;
			}
		}
		if(y+1<=XLength) {
			if(arrLab[x][y+1]==1) {
				point+=1;
			}
		}
		//System.out.println(point);
		return point;
	}
}
/*
 if(currX+1<=XLength) {
			if(checkNieghbor(currX+1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX+=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currX-1>=1) {
			if(checkNieghbor(currX-1,currY,XLength)<=1) {
				int randSecondNum=rand(20);
				if(randSecondNum<10) {
					currX-=1;
					steps+=1;
					setMainRoad(currX,XLength,currY);
				}
			}
		}
		if(currY+1<=XLength) {
			if(checkNieghbor(currX,currY+1,XLength)<=1) {
				currY+=1;
				steps+=1;
				setMainRoad(currX,XLength,currY);
			}
		} 
 */
