package Across_The_Abyss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GameSave {
	public String gameName;
	public Character player;
	public NPC[] npcs; // all NPC's the player has encountered thus far
	public LocationNode currentLocation; // the current location of the player saved as a node
	
	/**
	 * Default constructor for creating a new game save
	 */
	public GameSave(String name) {
		this.gameName = name;
		this.player = new Character();
		this.npcs = new NPC[200];
		this.currentLocation = new LocationNode(true);
	}
	
	public void saveGame(GameSave game) throws IOException {
		File file = new File("game/saves/save_file_list/saveList.txt");
		Scanner input = new Scanner(System.in);
		ArrayList<String> saveList = new ArrayList<String>();
		String overWrite;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String newName = br.readLine();
		
		//Grabs all save names from file
		while ((newName != null) && (!newName.equals(""))) {
			saveList.add(newName);
			newName = br.readLine();
		}
		//checks to see if there is savefile with existing name
		if (saveList.contains(game.gameName)) {
			System.out.println("Warning: Game with current name already exists. Would you like to overwrite ?");
			overWrite = input.nextLine();
			overWrite = overWrite.toLowerCase();
			if (overWrite.equals("yes")) {
				System.out.println("Saving game...");
				save(game, saveList);
			} else if (overWrite.equals("no")){
				System.out.println("Not saving game...");
			} else {
				System.out.println("Typo.... not saving game...");
			}
		} else {
			save(game, saveList);
		}
		
		//Closes readers/writers
		input.close();
		fr.close();
		br.close();
		
		
	}
	
	private static void save(GameSave game, ArrayList<String> saveList) throws IOException {
		//Writes the new save name to the save name list
		File namesFile = new File("game/saves/save_file_list/saveList.txt");
		FileWriter fw = new FileWriter(namesFile, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(game.gameName + "\n");

		//Closes readers/writers
		bw.flush();
		fw.flush();
		bw.close();
		fw.close();
		
		//Saves the game to its own game save file
		File saveFile = new File("game/saves/save_files/" + game.gameName + ".txt");
		FileWriter saveFileWriter = new FileWriter(saveFile, true);
		BufferedWriter saveBufferedWriter = new BufferedWriter(saveFileWriter);
		saveBufferedWriter.write(game.toString());
		
		//Closes readers/writer
		saveFileWriter.flush();
		saveBufferedWriter.flush();
		saveFileWriter.close();
		saveBufferedWriter.close();
	}
	
	public String toString(GameSave game) {
		return "test";
	}
	
}
