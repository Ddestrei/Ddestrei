package engine;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaverFile {
	BufferedWriter saveFile;
	FileWriter fileWriter;
	PrintWriter printWriter;
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
	public SaverFile(int arrStars[],int startedGames,int endedGames) {
		try {
			fileWriter = new FileWriter("Player.txt",false);
			printWriter = new PrintWriter(fileWriter,false);
			printWriter.flush();
			saveFile= new BufferedWriter(fileWriter);
			for (int i=0;i<12;i++) {
				saveFile.write(String.valueOf(arrStars[i])+"\n");
			}
			saveFile.write(String.valueOf(startedGames)+"\n");
			saveFile.write(String.valueOf(endedGames)+"\n");
			saveFile.close();
			fileWriter.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
