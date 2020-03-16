package model.heroes;

import java.io.IOException;
import java.util.ArrayList;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Priest extends Hero {
	ArrayList<Card> priestDeck;

	public Priest() throws IOException {
		super("Anduin Wrynn");
		priestDeck = getDeck();
		this.buildDeck();
	}

	@Override
	public void buildDeck() throws IOException {

		ArrayList<Minion> dataBaseOfMinions = getAllNeutralMinions(
				"neutral_minions.csv");
		ArrayList<Minion> neutralMinions = getNeutralMinions(dataBaseOfMinions, 13);
		Card prophetVelen = new Minion("Prophet Velen", 7, Rarity.LEGENDARY, 7, 7, false, false, false);
		Card divineSpirit1 = new DivineSpirit();
		Card divineSpirit2 = new DivineSpirit();
		Card holyNova1 = new HolyNova();
		Card holyNova2 = new HolyNova();
		Card shadowWordDeath1 = new ShadowWordDeath();
		Card shadowWordDeath2 = new ShadowWordDeath();

		priestDeck.add(divineSpirit1);
		priestDeck.add(divineSpirit2);
		priestDeck.add(holyNova1);
		priestDeck.add(holyNova2);
		priestDeck.add(shadowWordDeath1);
		priestDeck.add(shadowWordDeath2);
		priestDeck.add(prophetVelen);

		priestDeck.addAll(neutralMinions);
		shuffle(priestDeck);

	}

}
