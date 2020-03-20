package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class LevelUp extends Spell implements FieldSpell {

	public LevelUp() {
		super("Level Up!", 6, Rarity.EPIC);
		
	}
	public void performAction(ArrayList<Minion>field)
	{
		for(int i=0 ; i<field.size();i++) // To traverse the arrayList of (field) 
		{
			field.get(i).setAttack(field.get(i).getAttack()+1) ; //increase minion's attack by 1
			field.get(i).setCurrentHP(field.get(i).getCurrentHP()+1); //increase minion's currentHP by 1
			field.get(i).setMaxHP(field.get(i).getMaxHP()+1); //increase minion's maxHP by 1
		}
	}

}
