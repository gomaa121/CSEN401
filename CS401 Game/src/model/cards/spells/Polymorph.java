package model.cards.spells;

import exceptions.InvalidTargetException;
import model.cards.Rarity;
import model.cards.minions.Minion;

public class Polymorph extends Spell implements MinionTargetSpell {

	public Polymorph() {
		super("Polymorph", 4, Rarity.BASIC);
	}
	public void performAction(Minion m) throws InvalidTargetException 
	{
		if(m.getName().equals("Icehowl")) 
		{
								//can normally attack heroes
		}
		m.setCurrentHP(1); //transform the currentHP value to 1 
		m.setMaxHP(1); //transform the maxHP value to 1 
		m.setAttack(1); //transform the attack value to 1
		m.setName("Sheep"); // transform the name to "Sheep"
		m.setDivine(false) ; // transform to a non-divine minion
		m.setTaunt(false); // transform to a non-taunt minion
		m.setCharge(false); // transform to a non-charge minion
		m.setManaCost(1); // transform to a manaCost of 1 
		
	}

}
