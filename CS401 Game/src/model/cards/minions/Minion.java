package model.cards.minions;

import exceptions.InvalidTargetException;
import model.cards.Card;
import model.cards.Rarity;
import model.heroes.Hero;

public class Minion extends Card implements Cloneable {
	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean divine;
	private boolean sleeping;
	private boolean attacked;
	private boolean charge ;

	public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean divine,
			boolean charge) {
		super(name, manaCost, rarity);
		setAttack(attack);
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.taunt = taunt;
		this.divine = divine;
		if (!charge)
			this.sleeping = true;
	}

	public boolean isTaunt() {
		return taunt;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHp) {
		this.maxHP = maxHp;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
		if (this.currentHP > maxHP)
			this.currentHP = maxHP;
		else if (this.currentHP <= 0) {
			this.currentHP = 0;
		}
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
		if (this.attack <= 0)
			this.attack = 0;
	}

	public void setTaunt(boolean isTaunt) {
		this.taunt = isTaunt;
	}

	public void setDivine(boolean divine) {
		this.divine = divine;
	}

	public boolean isAttacked() {
		return attacked;
	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public boolean isSleeping() {
		return sleeping;
	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public boolean isDivine() {
		return divine;
	}
	public boolean isCharge()
	{
		return charge ;
	}
	public void setCharge(boolean charge)
	{
		this.charge = charge ;
	}
	public void attack(Minion target) // Action of minion attacking a minion
	{
		if(this.isDivine() && target.isDivine()) //Both having Divine shield
		{
			this.setDivine(false); //the shield will break after the first attack the minion receives
			target.setDivine(false); //the shield will break after the first attack the minion receives
		}
		else 
			if(this.isDivine() && !(target.isDivine())) //The current minion has a Divine shield while the (target) minion do not have a Divine shield
			{
				this.setDivine(false); //the shield will break after the first attack the minion receives
				target.setCurrentHP(target.getCurrentHP()-(this.getCurrentHP())); //the (target) minion inflicted by the HP of the current minion
			}
		else
			if(!(this.isDivine()) && target.isDivine())  //The (target) minion has a Divine shield while the current minion do not have a Divine shield
			{
				this.setCurrentHP(this.getCurrentHP()-(target.getCurrentHP())); //the current minion inflicted by the HP of the (target) minion
				target.setDivine(false); //the shield will break after the first attack the minion receives
			}
		else // Both of them do not have a Divine shield
		{
			this.setCurrentHP(this.getCurrentHP()-(target.getCurrentHP())); //the current minion inflicted by the HP of the (target) minion
			target.setCurrentHP(target.getCurrentHP()-(this.getCurrentHP())); //the (target) minion inflicted by the HP of the current minion
		}
		}
	public void attack(Hero target) throws InvalidTargetException // Action of minion attacking a hero
	{
		if(this.getName().equals("Icehowl"))
		{
			throw new InvalidTargetException("Icehowl can not attack heroes.") ;
		}
		else //Only the hero target will take damage
		{
			target.setCurrentHP(target.getCurrentHP()-(this.getAttack())); // the hero target inflicted by the attack points of the current minion
		}
	}
	public Minion clone() throws CloneNotSupportedException 
	{
		Minion m = (Minion) super.clone() ; //Type casting the generic type (Object) to (Minion)
		return m ;
	}
	

}
