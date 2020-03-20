package model.cards.spells;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class SiphonSoul extends Spell implements LeechingSpell {

	public SiphonSoul() {
		super("Siphon Soul", 6, Rarity.RARE);	
	}
	public int performAction (Minion m)
	{
		if(m.isDivine() || !(m.isDivine())) // Defensive Programming 
		{
			m.setCurrentHP(0); //Destroys the minion
		}
		return 3 ; //the amount of health points that will be restored to the hero
	}
}
