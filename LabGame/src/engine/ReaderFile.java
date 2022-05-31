package engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReaderFile {
	int[] arrStars;
	int startedGames;
	int endedGames;
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
	File file;
	FileReader fileReader;
	BufferedReader bufferedReader;
	public ReaderFile(){
		file = new File("Player.txt");
		try {
			arrStars = new int [12];
			String s;
			if(emptyFile()==false) {
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				for (int i=0;i<12;i++){
					s = bufferedReader.readLine();
					arrStars[i]=Integer.parseInt(s);
					//System.out.println(s);
				}
				if((s = bufferedReader.readLine())!=null) {
					startedGames=Integer.parseInt(s);
				}
				if((s = bufferedReader.readLine())!=null) {
					endedGames=Integer.parseInt(s);
				}
			fileReader.close();
			bufferedReader.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean emptyFile() {
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			String s;
			try {
				if((s = bufferedReader.readLine())==null) {
					fileReader.close();
					bufferedReader.close();
					return true;
				}
				else {
					fileReader.close();
					bufferedReader.close();
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	}
	public int returnStartedGames() {
		return startedGames;
	}
	public int returnEndedGames() {
		return endedGames;
	}
	public int returnEasyThree() {
		return arrStars[0];
	}
	public int returnEasyTwo() {
		return arrStars[1];
	}
	public int returnEasyOne() {
		return arrStars[2];
	}
	public int returnEasyZero() {
		return arrStars[3];
	}
	public int returnNormalThree() {
		return arrStars[4];
	}
	public int returnNormalTwo() {
		return arrStars[5];
	}
	public int returnNormalOne() {
		return arrStars[6];
	}
	public int returnNormalZero() {
		return arrStars[7];
	}
	public int returnHardThree() {
		return arrStars[8];
	}
	public int returnHardTwo(){
		return arrStars[9];
	}
	public int returnHardOne() {
		return arrStars[10];
	}
	public int returnHardZero() {
		return arrStars[11];
	}
}
