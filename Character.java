package Across_The_Abyss;

import javax.swing.JOptionPane;

public class Character {
	//Character attributes
	private int maxHealth;
	private int currentHealth;
	private int stealth;
	private int strength;
	private int intelligence;
	private int speed;
	private int clumsyness;
	
	//Character weapon skills
	private int axe;
	private int sword;
	private int blunt;
	private int spear;
	
	//Character skills
	private int firstaid;
	private int maintenence;
	
	//Character possessions
	private int coins;
	private Quest[] quests;
	private Item[] inventory;
	
	/**
	 * Default constructor for character
	 */
	public Character() {
		this.maxHealth = 100;
		this.currentHealth = 100;
		this.stealth = 1; // max 100
		this.strength = 1; //max 100
		this.intelligence = 1; //max 100
		this.speed = 1; //max 100
		this.clumsyness = 5; //max 100
	}
	

}
