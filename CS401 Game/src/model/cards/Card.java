package model.cards;

public abstract class Card {
	private String name;
	private int manaCost;
	private Rarity rarity;

	public Card(String name, int manaCost, Rarity rarity) {
		this.name = name;
		if (manaCost > 10) {
			this.manaCost = 10;
		} else if (manaCost < 0) {
			this.manaCost = 0;
		} else {
			this.manaCost = manaCost;
		}
		this.rarity = rarity;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManaCost() {
		return this.manaCost;
	}

	public void setManaCost(int manaCost) {
		if (manaCost > 10)
			this.manaCost = 10;
		else if (manaCost < 0)
			this.manaCost = 0;
		else
			this.manaCost = manaCost;
	}

	public Rarity getRarity() {
		return this.rarity;
	}
}
