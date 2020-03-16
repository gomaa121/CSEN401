package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Paladin extends Hero {
	ArrayList<Card> paladinDeck;
	public Paladin() throws IOException {
		super("Uther Lightbringer");
		paladinDeck = getDeck();
		this.buildDeck();
	}

	@Override
	public void buildDeck() throws IOException {
		
		
		ArrayList<Minion> dataBaseOfMinions = getAllNeutralMinions(
				"neutral_minions.csv");
		ArrayList<Minion> neutralMinions = getNeutralMinions(dataBaseOfMinions, 15);
		Card tirionFordring = new Minion("Tirion Fordring", 4, Rarity.LEGENDARY, 6, 6, true, true, false);
		Card sealOfChampions1 = new SealOfChampions();
		Card sealOfChampions2 = new SealOfChampions();
		Card levelUp1 = new LevelUp();
		Card levelUp2 = new LevelUp();

		paladinDeck.add(sealOfChampions1);
		paladinDeck.add(sealOfChampions2);
		paladinDeck.add(levelUp1);
		paladinDeck.add(levelUp2);
		paladinDeck.add(tirionFordring);

		paladinDeck.addAll(neutralMinions);
		shuffle(paladinDeck);
		

	}}
