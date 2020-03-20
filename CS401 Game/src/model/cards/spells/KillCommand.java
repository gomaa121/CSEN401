package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class KillCommand extends Spell implements MinionTargetSpell, HeroTargetSpell {

	public KillCommand() {
		super("Kill Command", 3, Rarity.COMMON);
		
	}
	public void performAction(Minion m) throws InvalidTargetException 
	{
		m.setCurrentHP(m.getCurrentHP()-5); //deals 5 damage to a minion 
	}
	public void performAction(Hero h)
	{
		h.setCurrentHP(h.getCurrentHP()-3) ; //deals 3 damage to a hero 
	}
}
