package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 *
 */
public class LabyrinthGame implements Game {

	private int width;
	private int height;
	private Hero hero;
	private Position exit;
	private boolean[][] isWall;
	/**
	 * constructeur avec fichier source pour le help
	 *
	 */
	public LabyrinthGame(String source) {
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

	public LabyrinthGame() {
		this.width = 15;
		this.height = 10;
		this.exit = new Position(14, 8);
		this.isWall = new boolean[this.height][this.width];
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				if (!this.isExit(x,y))
					this.isWall[y][x] = x == 0 || x == width-1 || y == 0 || y == height-1;
		this.hero = new Hero(1,2);
	}

	public void moveHero(Cmd commande) {
		int prevX = this.hero.getX(),
				prevY = this.hero.getY();
		this.hero.move(commande);
		int x = this.hero.getX(),
				y = this.hero.getY();
		if (this.isExit(x,y)) {
			System.out.println("Felicitations, vous avez gagne !");
			System.exit(0);
		} else if (this.isWall(x, y)) {
			this.hero.setX(prevX);
			this.hero.setY(prevY);
		}
	}

	/**
	* @param x
	* @param y
	* @return true si la position correspond à la sortie
	*/
	public boolean isExit(int x, int y) {
		return this.exit.getX() == x && this.exit.getY() == y;
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 *
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		this.moveHero(commande);
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

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	public boolean isWall(int x, int y) {
		return this.isWall[y][x];
	}

}
