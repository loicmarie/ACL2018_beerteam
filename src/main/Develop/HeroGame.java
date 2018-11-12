package Develop;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Hero;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 *
 */
public class HeroGame implements Game {

	private Hero hero;
	/**
	 * constructeur avec fichier source pour le help
	 *
	 */
	public HeroGame(String source) {
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
		this.hero = new Hero(1,2);
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 *
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		this.hero.move(commande);
		System.out.println("Execute "+commande);
		System.out.print("Votre héro est en position" + this.hero.position.toString());
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		// le jeu n'est jamais fini
		return false;
	}

	@Override
	public Hero getHero() {
		return this.hero;
	}

	@Override
	public void setHero(Hero hero) {
		this.hero = hero;
	}

}
