package engine;

import java.util.ArrayList;

import exceptions.CannotAttackException;
import exceptions.FullFieldException;
import exceptions.HeroPowerAlreadyUsedException;
import exceptions.InvalidTargetException;
import exceptions.NotEnoughManaException;
import exceptions.NotSummonedException;
import exceptions.NotYourTurnException;
import exceptions.TauntBypassException;
import model.cards.Card;
import model.cards.minions.Minion;
import model.heroes.Hero;

public class Game implements ActionValidator {
	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;
	
	public Game(Hero p1, Hero p2)
	{
		firstHero=p1;
		secondHero=p2;
		
		int coin = (int) (Math.random()*2);
		currentHero= coin==0?firstHero:secondHero;
		opponent= currentHero==firstHero?secondHero:firstHero;
		currentHero.setCurrentManaCrystals(1);
		currentHero.setTotalManaCrystals(1);
		
	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

	@Override
	public void validateTurn(Hero user) throws NotYourTurnException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateAttack(Minion attacker, Minion target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		attacker.isOnField(currentHero);
		ArrayList<Minion>heroField=currentHero.getField();
		for(int i=0;i<heroField.size();i++) {
			if(target==heroField.get(i))
				throw new InvalidTargetException("Cannot attack friendly minion");
		}
		target.isOnField(opponent);
		if(attacker.getAttack()>0) {
			if(!target.isTaunt()) {
				
				
			
				ArrayList<Minion> oppField=opponent.getField();
				for(int i=0;i<oppField.size();i++) {
					if(oppField.get(i).isTaunt()&&oppField.get(i)!=target)
						throw new TauntBypassException("There is one or more taunt minion");
				
			}
		}
		else
			throw new CannotAttackException("Minion attack is zero");
	}
	}

	@Override
	public void validateAttack(Minion attacker, Hero target)
			throws CannotAttackException, NotSummonedException, TauntBypassException, InvalidTargetException {
		if(target==currentHero)
			throw new InvalidTargetException("Cannot attack yourself");
		attacker.isOnField(currentHero);
		if(attacker.getAttack()>0) {
		ArrayList<Minion> oppField=opponent.getField();
		for(int i=0;i<oppField.size();i++) {
			if(oppField.get(i).isTaunt())
				throw new TauntBypassException("There is one or more taunt minion");
			}
		}
		else
			throw new CannotAttackException("Minion attack is zero");
	}

	@Override
	public void validateManaCost(Card card) throws NotEnoughManaException {
		if(currentHero.getCurrentManaCrystals()<card.getManaCost())
			throw new NotEnoughManaException("Not enough Mana");
		
	}

	@Override
	public void validatePlayingMinion(Minion minion) throws FullFieldException {
		if(currentHero.getField().size()>=7)
			throw new FullFieldException("No space to summon");
		
	}

	@Override
	public void validateUsingHeroPower(Hero hero) throws NotEnoughManaException, HeroPowerAlreadyUsedException {
		if(hero.getCurrentManaCrystals()<2)
			throw new NotEnoughManaException("Not enough Mana");
		if(hero.isHeroPowerUsed())
			throw new HeroPowerAlreadyUsedException("You already used your hero power");
		
	}

	
	
	

}
