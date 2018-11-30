package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;

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
	private Treasure treasure;
	private boolean[][] isWall;
	private boolean[][] isTrap;
	private ArrayList<Monster> monsters;
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
		// Treasure
		this.treasure = new Treasure(14, 8);
		// Walls
		this.isWall = new boolean[this.height][this.width];
		for (int y = 0; y < height; y++)
			for (int x = 0; x < width; x++)
				if (!this.isTreasure(x,y))
					this.isWall[y][x] = x == 0 || x == width-1 || y == 0 || y == height-1;
		// Traps
		this.isTrap = new boolean[this.height][this.width];
		this.isTrap[1][7] = true;
		this.isTrap[1][8] = true;
		this.isTrap[8][7] = true;
		this.isTrap[8][8] = true;
		// Monsters
		this.monsters = new ArrayList<Monster>();
		this.monsters.add(new Monster(1, this.height-2));
		this.monsters.add(new Monster(this.width-2, 1));
		// Hero
		this.hero = new Hero(1,1);
	}

	private void moveHero(Cmd commande) {
		int prevX = this.hero.getX(),
				prevY = this.hero.getY();
		this.hero.move(commande);
		int x = this.hero.getX(),
				y = this.hero.getY();
		if (this.isTreasure(x,y)) {
			System.out.println("Felicitations, vous avez gagne !");
		} else if (this.isWall(x, y)) {
			this.hero.setX(prevX);
			this.hero.setY(prevY);
		} else if (this.isMonster(x, y)) {
			System.out.println("Votre heros est mort !");
			this.hero.setDead();
		}
	}

	private void moveMonsters() {
		for (Monster monster: this.monsters)
			monster.move(monster.getMove(this));
	}

	/**
	* @param x
	* @param y
	* @return true si la position correspond à la sortie
	*/
	@Override
	public boolean isTreasure(int x, int y) {
		return this.treasure.isOn(new Position(x,y));
	}

	/**
	* @param x
	* @param y
	* @return true si la position correspond à celle d'un monstre
	*/
	@Override
	public boolean isMonster(int x, int y) {
		for (Monster monster: this.monsters)
			if (monster.isOn(new Position(x,y)))
				return true;
		return false;
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 *
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		this.moveMonsters();
		this.moveHero(commande);
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		return this.hero.isDead() || this.isTreasure(this.hero.getX(), this.hero.getY());
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

	@Override
	public ArrayList<Monster> getMonsters() {
		return this.monsters;
	}

	/**
	* @param x
	* @param y
	* @return true si il y a un mur à la position (x,y)
	*/
	@Override
	public boolean isWall(int x, int y) {
		return this.isWall[y][x];
	}

	/**
	* @param x
	* @param y
	* @return true si il y a un piege à la position (x,y)
	*/
	@Override
	public boolean isTrap(int x, int y) {
		return this.isTrap[y][x];
	}

}
