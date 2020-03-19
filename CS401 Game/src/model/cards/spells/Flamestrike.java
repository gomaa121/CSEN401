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
		
		for(int i=0 ; i<oppField.size();i++)
		{
			Minion decrease = oppField.get(i) ; //using the variable (decrease) to get the data of the selected minion
			decrease.setAttack(decrease.getAttack()-4); //decreases the attack by 4 ; 
			if(decrease.getAttack()==0) // To handle the case where an enemy minion dies during the process
				oppField.remove(i) ;
		}
	}
	
}
