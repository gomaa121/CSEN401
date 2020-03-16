package model.heroes;

import model.cards.minions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;

abstract public class Hero { // No Heros Instantiated
	private String name;
	private int currentHP = 30;
	private boolean heroPowerUsed;
	private int totalManaCrystals;
	private int currentManaCrystals;
	private ArrayList<Card> deck;
	private ArrayList<Minion> field;
	private ArrayList<Card> hand;
	private int fatigueDamage;

	public Hero(String name) {
		this.name = name;
		deck = new ArrayList<>();
	}
	// Getters & Setters

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public ArrayList<Minion> getField() {
		return field;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		if (currentHP <= 30 && currentHP >= 0)
			this.currentHP = currentHP;
		else if(currentHP>30)
			this.currentHP = 30;
		else if(currentHP<0)
			this.currentHP=0;
	}

	public boolean isHeroPowerUsed() {
		return heroPowerUsed;
	}

	public void setHeroPowerUsed(boolean heroPowerUsed) {
		this.heroPowerUsed = heroPowerUsed;
	}

	public int getTotalManaCrystals() {
		return totalManaCrystals;
	}

	public void setTotalManaCrystals(int totalManaCrystals) {
		if (totalManaCrystals <= 10 && totalManaCrystals >= 0)
			this.totalManaCrystals = totalManaCrystals;
		else
			this.totalManaCrystals = 10;
	}

	public int getCurrentManaCrystals() {
		return currentManaCrystals;
	}

	public void setCurrentManaCrystals(int currentManaCrystals) {
		if (currentManaCrystals >= 0 && currentManaCrystals <= 10)
			this.currentManaCrystals = currentManaCrystals;
		else
			this.currentManaCrystals = 10;
	}

	public String getName() {
		return name;
	}

	// methods
	public static String[] readFile(String path) throws IOException {
		FileReader fileReader = new FileReader(path);
		BufferedReader br = new BufferedReader(fileReader);
		String currentLine = br.readLine();
		String data = "";
		while (currentLine != null) {
			data += currentLine + ",";
			currentLine = br.readLine();
		}
		String[] dataBase = data.split(",");
		return dataBase;
	}

	public static final ArrayList<Minion> getAllNeutralMinions(String filePath) throws IOException {
		String dataBase[] = readFile(filePath);// reads csv file, return array of Strings
		ArrayList<Minion> result = new ArrayList<>();
		// for loop: parses String elements to their respective data types
		for (int i = 0; i < dataBase.length; i = i + 8) {
			if (dataBase[i].equals("Icehowl")) {
				Icehowl temp = new Icehowl();
				result.add(temp);
			} else {

				// NAME, MANA COST,RARITY, ATTACK, MAX HP,TAUNT, DIVINE, CHARGE.
				String name = dataBase[i];
				int manaCost = Integer.parseInt(dataBase[i + 1]);
				Rarity rarity = getMinionRarity(dataBase[i + 2].charAt(0));
				int attack = Integer.parseInt(dataBase[i + 3]);
				int maxHP = Integer.parseInt(dataBase[i + 4]);
				boolean taunt;
				boolean divine;
				boolean charge;
				if (dataBase[i + 5].equals("TRUE"))
					taunt = true;
				else
					taunt = false;
				if (dataBase[i + 6].equals("TRUE"))
					divine = true;
				else
					divine = false;
				if (dataBase[i + 7].equals("TRUE"))
					charge = true;
				else
					charge = false;
				Minion tmp = new Minion(name, manaCost, rarity, attack, maxHP, taunt, divine, charge);
				result.add(tmp);
			}
		}
		return result;

	}

	// helper method for getAllNeutralMinions, return rarity
	private static Rarity getMinionRarity(char s) {
		if (s == 'b')
			return Rarity.BASIC;
		else if (s == 'r')
			return Rarity.RARE;
		else if (s == 'l')
			return Rarity.LEGENDARY;
		else if (s == 'c')
			return Rarity.COMMON;
		else
			return Rarity.EPIC;
	}

	public static final ArrayList<Minion> getNeutralMinions(ArrayList<Minion> minions, int count) {
		ArrayList<Minion> result = new ArrayList<>();
		int[] numberOfSelections = new int[minions.size()];
		// NOTE: a player can get only one legendary card, 2 of any other cards
		// create the counter array to ensure previous constraint^
		for (int i = 0; i < minions.size(); i++) {
			if (minions.get(i).getRarity() == Rarity.LEGENDARY) {
				numberOfSelections[i] = 1;
			} else {
				numberOfSelections[i] = 2;
			}
		}
		// pick minions randomly and according to the constraint
		while (result.size() < count) {
			int index = (int) (Math.random() * minions.size());
			if (numberOfSelections[index] > 0) {
				Minion tmp = minions.get(index);
				result.add(new Minion(tmp.getName(), tmp.getManaCost(), tmp.getRarity(), tmp.getAttack(),
						tmp.getMaxHP(), tmp.isTaunt(), tmp.isDivine(), tmp.isCharge()));
				numberOfSelections[index]--;
			}
		}
		return result;
	}
	

	// helper method for buildDeck, shuffles the whole deck
	protected final void shuffle(ArrayList<Card> cards) {
		int inputSize = cards.size();
		ArrayList<Card> temp = new ArrayList<>();
		while (temp.size() < inputSize) {
			int randomNum = (int) (Math.random() * cards.size());
			temp.add(cards.get(randomNum));
			cards.remove(randomNum);
		}
		while (!temp.isEmpty()) {
			cards.add(temp.remove(0));
		}
	}

	// -----------------abstract
	public abstract void buildDeck() throws IOException;
	
}

