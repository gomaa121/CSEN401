package model.cards.spells;

import java.util.ArrayList;

import model.cards.Rarity;
import model.cards.minions.Minion;

public class MultiShot extends Spell implements AOESpell{

	public MultiShot() {
		super("Multi-Shot", 4,Rarity.BASIC);
		
	}
	public void performAction(ArrayList<Minion> oppField,ArrayList<Minion> curField)
	{
		if(oppField.size()==1)
		{
			oppField.get(0).setAttack(oppField.get(0).getAttack()-3); //decreases the attack by 3 
		}
		else if (oppField.size()>1)
		{
			int [] randomNumbers = new int [2] ;//Creating an array to hold the two random numbers
			int max = oppField.size(); //the maximum random number that can be generated
			int min = 0 ;
			int requiredRange = max - min +1 ; //The required range of randomly generated numbers 
			for (int i=0 ; i<randomNumbers.length-1 ; i++) //To save generated random numbers in an Array
			{
				randomNumbers[i] = (int)(Math.random()*requiredRange) ; //To generate two random numbers within the required range
			}
			oppField.get(randomNumbers[0]).setAttack(oppField.get(randomNumbers[0]).getAttack()-3); //decreases the attack by 3 
			oppField.get(randomNumbers[1]).setAttack(oppField.get(randomNumbers[1]).getAttack()-3); //decreases the attack by 3 
			
		}
	}

}
