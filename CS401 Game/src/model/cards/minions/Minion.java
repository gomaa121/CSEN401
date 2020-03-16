package model.cards.minions;

import model.cards.Card;
import model.cards.Rarity;
import model.cards.spells.AOESpell;

public class Minion extends Card {
	private int attack;
	private int maxHP;
	private int currentHP;
	private boolean taunt;
	private boolean divine;
	private boolean sleeping;
	private boolean attacked;

	public Minion(String name, int manaCost, Rarity rarity, int attack, int maxHP, boolean taunt, boolean divine,
			boolean charge) {
		super(name, manaCost, rarity);
		if (attack >= 0)
			this.attack = attack;
		else {
			this.attack = 0;
		}
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.taunt = taunt;
		this.divine = divine;
		this.sleeping = !charge;
	}

	public int getAttack() {
		return this.attack;
	}

	public void setAttack(int attack) {
		if (attack >= 0)
			this.attack = attack;
		else {
			this.attack = 0;
		}
	}

	public int getMaxHP() {
		return this.maxHP;
	}

	public void setMaxHP(int maxHP) {
		if (maxHP < 0)
			this.maxHP = 0;
		else
			this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return this.currentHP;
	}

	public void setCurrentHP(int currentHP) {
		if (currentHP < 0)
			this.currentHP = 0;
		else {
			if (currentHP <= maxHP)
				this.currentHP = currentHP;
			else {
				this.currentHP = maxHP;
			}

		}
	}

	public void setTaunt(boolean taunt) {
		this.taunt = taunt;
	}

	public boolean isTaunt() {
		return this.taunt;
	}

	public void setDivine(boolean divine) {
		this.divine = divine;
	}

	public boolean isDivine() {
		return this.divine;

	}

	public void setSleeping(boolean sleeping) {
		this.sleeping = sleeping;
	}

	public boolean isSleeping() {
		return sleeping;

	}

	public boolean isAttacked() {
		return this.attacked;

	}

	public void setAttacked(boolean attacked) {
		this.attacked = attacked;
	}

	public boolean isCharge() {
		return !sleeping;
	}

}
