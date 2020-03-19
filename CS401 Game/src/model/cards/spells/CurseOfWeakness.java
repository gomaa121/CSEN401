package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class CurseOfWeakness extends Spell implements AOESpell {

	public CurseOfWeakness() {
		super("Curse of Weakness", 2, Rarity.RARE);
		
	}
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField)
	{
		for(int i=0 ; i<oppField.size();i++)
		{
			Minion decrease = oppField.get(i) ;//using the variable (decrease) to get the data of the selected minion
			decrease.setAttack(decrease.getAttack()-2); //decreases the attack by 2 ;
		}
	}

	
}
