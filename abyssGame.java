package Across_The_Abyss;

import java.io.*;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class abyssGame {

	public static void main(String[] args) throws IOException {
		//Declares variables
		GameSave game;
		String gameName;
		String saveChoice;
		
		//Asks the user what game to load, or to start a new one
		Scanner input = new Scanner(System.in);
		System.out.println("WELCOME TO *INSERT GAME NAME*\n"
				+ "Please select an option:\n"
				+ "\tNew Save\t|\tLoad Save\t|\tDelete Save");
		
		 
		do {
			saveChoice = input.nextLine();
			saveChoice = saveChoice.toLowerCase();
			if (saveChoice.equals("new save")) {
				System.out.println("Please enter a name for your new save game:");
				gameName = input.nextLine();
				game = new GameSave(gameName);
				game.saveGame(game);
			}
			else if (saveChoice.equals("load save")) {
				//insert code for loading game here
			}
			else if (saveChoice.equals("delete save")) {
				
			}
			else {
				System.out.println("Typo. Try again!");
			}
		} while (isSaveNotValid(saveChoice));
		
		
	}

	public static boolean isSaveNotValid(String saveChoice) {
		switch(saveChoice) {
			case "new save":
				return false;
			case "load save":
				return false;
			case "delete save":
				return false;
			default:
				return true;
		}
	}
}
