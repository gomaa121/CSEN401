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
		for(int i=0 ; i<field.size();i++)
		{
			Minion operations = field.get(i) ; //using the variable (operations) to get the data of the selected minion 
			operations.setAttack(operations.getAttack()+1) ; //increase minion's attack by 1
			operations.setCurrentHP(operations.getCurrentHP()+1); //increase minion's currentHP by 1
			operations.setMaxHP(operations.getMaxHP()+1); //increase minion's maxHP by 1
			
		}
	}

}
