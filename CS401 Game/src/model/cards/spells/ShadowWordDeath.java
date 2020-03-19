package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class ShadowWordDeath extends Spell implements MinionTargetSpell {

	public ShadowWordDeath() {
		super("Shadow Word: Death", 3, Rarity.BASIC);	
	}
	public void performAction(Minion m) throws InvalidTargetException
	{
		if(m.getAttack()>=5)
		{
			if(m.isDivine() || !(m.isDivine())) // Defensive Programming
				m.setCurrentHP(0); //Destroys the minion 
		}
	}
}
