package engine;

import model.heroes.Hero;
import model.cards.minions.*;
import model.cards.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	// attributes------------------------
	private Hero firstHero;
	private Hero secondHero;
	private Hero currentHero;
	private Hero opponent;

	// constructor--------------------
	public Game(Hero p1, Hero p2) {
		int x = (int) (Math.random() * 2); // Either 0 or 1 to Pick Who Goes First
		if (x == 0) {
			firstHero = p1;
			currentHero = p2;
			secondHero = p2;
			opponent = p1;
		}
		if (x == 1) {
			firstHero = p1;
			currentHero = p1;
			secondHero = p2;
			opponent = p2;
		}
	}

	public Hero getCurrentHero() {
		return currentHero;
	}

	public Hero getOpponent() {
		return opponent;
	}

}
