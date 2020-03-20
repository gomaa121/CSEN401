package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class HolyNova extends Spell implements AOESpell {

	public HolyNova() {
		super("Holy Nova", 5, Rarity.BASIC);
	
	}
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField)
	{
		
		for(int i=0 ; i<oppField.size();i++) //To traverse the arrayList of oppField
		{
			
			oppField.get(i).setAttack(oppField.get(i).getAttack()-2); //decreases the attack by 4 
			if(oppField.get(i).getAttack()==0) // To handle the case where an enemy minion dies during the process
				oppField.remove(i) ;
		}
		for(int i=0 ; i<curField.size(); i++) //To traverse the arrayList of curField
		{
			curField.get(i).setCurrentHP(curField.get(i).getCurrentHP()+2); // to restore 2 health points
			
		}
	}

}
