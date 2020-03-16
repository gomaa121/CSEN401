package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Mage extends Hero {
	ArrayList<Card> mageDeck;

	public Mage() throws IOException {
		super("Jaina Proudmoore");
		mageDeck = getDeck();
		this.buildDeck();
	}

	@Override
	public void buildDeck() throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Minion> dataBaseOfMinions = getAllNeutralMinions(
				"neutral_minions.csv");
		ArrayList<Minion> neutralMinions = getNeutralMinions(dataBaseOfMinions, 13);
		Card Kalycgos = new Minion("Kalycgos", 10, Rarity.LEGENDARY, 4, 12, false, false, false);
		Card plymorph1 = new Polymorph();
		Card plymorph2 = new Polymorph();
		Card flamestrike1 = new Flamestrike();
		Card flamestrike2 = new Flamestrike();
		Card pyroblast1 = new Pyroblast();
		Card pyroblast2 = new Pyroblast();

		mageDeck.add(plymorph1);
		mageDeck.add(plymorph2);
		mageDeck.add(flamestrike1);
		mageDeck.add(flamestrike2);
		mageDeck.add(pyroblast1);
		mageDeck.add(pyroblast2);
		mageDeck.add(Kalycgos);

		mageDeck.addAll(neutralMinions);
		shuffle(mageDeck);

	}
}
