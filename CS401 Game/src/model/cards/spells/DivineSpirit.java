package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class DivineSpirit extends Spell implements MinionTargetSpell {

	public DivineSpirit() {
		super("Divine Spirit", 3, Rarity.BASIC);
		
	}
	public void performAction(Minion m) throws InvalidTargetException
	{
		m.setCurrentHP(m.getCurrentHP()*2); //doubles the current HP 
		m.setMaxHP(m.getMaxHP()*2 ); //doubles the max HP
		
	}
	
	

}
