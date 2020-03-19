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
			Minion decrease = oppField.get(0) ;//using the variable (decrease) to get the data of the selected minion
			decrease.setAttack(decrease.getAttack()-3); //decreases the attack by 3 
		}
		else if (oppField.size()>1)
		{
			int [] randomNumbers = new int [2] ;//Creating an array to hold the two random numbers
			int max = oppField.size(); //the maximum random number that can be generated
			int min = 0 ;
			int requiredRange = max - min +1 ; //The required range of randomly generated numbers 
			for (int i=0 ; i<randomNumbers.length-1 ; i++)
			{
				randomNumbers[i] = (int)(Math.random()*requiredRange) ;
			}
			int firstDamagedMinion = randomNumbers[0] ;
			int secondDamagedMionion = randomNumbers[1] ;
			Minion firstDecrease = oppField.get(firstDamagedMinion) ;//using the variable (firstDecrease) to get the data of the selected minion
			firstDecrease.setAttack(firstDecrease.getAttack()-3); //decreases the attack by 3 
			Minion secondDecrease = oppField.get(secondDamagedMionion) ;//using the variable (secondDecrease) to get the data of the selected minion
			secondDecrease.setAttack(secondDecrease.getAttack()-3); //decreases the attack by 3 
			
		}
	}

}
