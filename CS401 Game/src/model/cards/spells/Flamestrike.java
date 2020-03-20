package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class Flamestrike extends Spell implements AOESpell {

	
	public Flamestrike()
	{
		super("Flamestrike",7,Rarity.BASIC);
	}
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField)
	{
		
		for(int i=0 ; i<oppField.size();i++) // To traverse the arrayList of oppField
		{
			oppField.get(i).setAttack(oppField.get(i).getAttack()-4); //decreases the attack by 4 
			if(oppField.get(i).getAttack()==0) // To handle the case where an enemy minion dies during the process
				oppField.remove(i) ;
		}
	}
	
}
