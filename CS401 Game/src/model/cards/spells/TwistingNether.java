package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class TwistingNether extends Spell implements AOESpell {

	public TwistingNether() {
		super("Twisting Nether", 8, Rarity.EPIC);

	}
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField)
	{
		
		for(int i=0 ; i<oppField.size();i++) // Destroys all minions of oppField
		{
			if(oppField.get(i).isDivine() || !(oppField.get(i).isDivine())) // Defensive Programming
			{	
				oppField.remove(i) ; // Destroys the selected minion
			}
		}
		for(int i=0 ; i<curField.size();i++) // Destroys all minions of curField
		{
			if(curField.get(i).isDivine() || !(curField.get(i).isDivine())) // Defensive Programming
			{	
				curField.remove(i) ; // Destroys the selected minion
			}
		}
	}

}
