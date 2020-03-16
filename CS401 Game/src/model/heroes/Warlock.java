package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Warlock extends Hero {
	ArrayList<Card> warlockDeck;

	public Warlock() throws IOException {
		// builds empty deck
		super("Gul'dan");
		warlockDeck = getDeck();
		this.buildDeck();

	}

	@Override
	public void buildDeck() throws IOException {
		ArrayList<Minion> dataBaseOfMinions = getAllNeutralMinions(
				"neutral_minions.csv");
		ArrayList<Minion> neutralMinions = getNeutralMinions(dataBaseOfMinions, 13);
		Card wilfredFizzlebang = new Minion("Wilfred Fizzlebang", 6, Rarity.LEGENDARY, 4, 4, false, false, false);
		Card curseOfWeakness1 = new CurseOfWeakness();
		Card curseOfWeakness2 = new CurseOfWeakness();
		Card siphonSoul1 = new SiphonSoul();
		Card siphonSoul2 = new SiphonSoul();
		Card twistingNether1 = new TwistingNether();
		Card twistingNether2 = new TwistingNether();

		warlockDeck.add(curseOfWeakness1);
		warlockDeck.add(curseOfWeakness2);
		warlockDeck.add(siphonSoul1);
		warlockDeck.add(siphonSoul2);
		warlockDeck.add(twistingNether1);
		warlockDeck.add(twistingNether2);
		warlockDeck.add(wilfredFizzlebang);

		warlockDeck.addAll(neutralMinions);
		shuffle(warlockDeck);
	}

}
