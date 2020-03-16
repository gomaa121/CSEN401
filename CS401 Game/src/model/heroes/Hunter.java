package model.heroes;
import java.io.IOException;
import java.util.ArrayList;
import model.cards.Card;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.cards.spells.*;

public class Hunter extends Hero {
	ArrayList<Card> hunterDeck;
	public Hunter() throws IOException {
		super("Rexxar");
		hunterDeck = getDeck();
		this.buildDeck();
	}

	@Override
	public void buildDeck() throws IOException {
		
		ArrayList<Minion> dataBaseOfMinions = getAllNeutralMinions("neutral_minions.csv");
		ArrayList<Minion>neutralMinions = getNeutralMinions(dataBaseOfMinions, 15);
		Card kingKrush = new Minion("King Krush",9,Rarity.LEGENDARY,8,8,false,false,true);
		Card killCommand1 = new KillCommand();
		Card killCommand2 = new KillCommand();
		Card multiShot1 = new MultiShot();
		Card multiShot2 = new MultiShot();
		
		hunterDeck.add(killCommand1);
		hunterDeck.add(killCommand2);
		hunterDeck.add(multiShot1);
		hunterDeck.add(multiShot2);
		hunterDeck.add(kingKrush);

		
		
		hunterDeck.addAll(neutralMinions);
		shuffle(hunterDeck);
		
	}
}
