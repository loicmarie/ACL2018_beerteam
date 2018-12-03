package model;

import java.io.*;
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
	private Teleporter[][] teleporters;
	private ArrayList<Monster> monsters;
	/**
	 * constructeur avec fichier source pour le help
	 *
	 */
	public LabyrinthGame(String source) {
		BufferedReader helpReader;
		try {
			InputStream is = getClass().getResourceAsStream(source);
			InputStreamReader isr = new InputStreamReader(is);
			helpReader = new BufferedReader(isr);
			String ligne;
			int y = -1;
			int nbTeleporters = 0;
			while ((ligne = helpReader.readLine()) != null) {
				if (y == -1) {
					String[] splited = ligne.split("\\s+");
					this.width = Integer.parseInt(splited[0]);
					this.height = Integer.parseInt(splited[1]);
					this.isWall = new boolean[this.height][this.width];
					this.isTrap = new boolean[this.height][this.width];
					this.teleporters = new Teleporter[this.height][this.width];
					this.monsters = new ArrayList<Monster>();
				} else if (y == this.height) {
					nbTeleporters = Integer.parseInt(ligne);
				} else if (y > this.height) {
					String[] splited = ligne.split("\\s+");
					int tx = Integer.parseInt(splited[0]);
					int ty = Integer.parseInt(splited[1]);
					int ntx = Integer.parseInt(splited[2]);
					int nty = Integer.parseInt(splited[3]);
					this.teleporters[ty][tx] = new Teleporter(tx, ty, ntx, nty);
				} else {
					for (int x = 0; x < ligne.length(); x++) {
						switch(ligne.charAt(x)) {
							case '#': this.isWall[y][x] = true; break;
							case 'E': this.treasure = new Treasure(x, y); break;
							case 'H': this.hero = new Hero(x, y); break;
							case 'M': this.monsters.add(new Monster(x, y)); break;
							case 'G': this.monsters.add(new Ghost(x, y)); break;
							case 'T': this.isTrap[y][x] = true; break;
						}
					}
				}
				y++;
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}

	public LabyrinthGame() {
		this("resources/lvl1.txt");
	}

	private void moveHero(Cmd commande) {
		int prevX = this.hero.getX(),
				prevY = this.hero.getY();
		this.hero.move(commande);
		int x = this.hero.getX(),
				y = this.hero.getY();
		if (this.isTreasure(x,y)) {
			System.out.println("Felicitations, vous avez gagne !");
		} else if (this.isTeleporter(x, y)) {
			Teleporter tp = this.getTeleporter(x, y);
			Position nextPos = tp.getNextPosition();
			this.hero.setX(nextPos.x);
			this.hero.setY(nextPos.y);
		} else if (this.isWall(x, y)) {
			this.hero.setX(prevX);
			this.hero.setY(prevY);
		} else if (this.isMonster(x, y) || this.isTrap(x, y)) {
			System.out.println("Votre heros est mort !");
			this.hero.setDead();
		}
	}

	private void moveMonsters() {
		Cmd cmd;
		for (Monster monster: this.monsters) {
			if (monster instanceof Ghost)
				cmd = ((Ghost)monster).getMove(this);
			else
				cmd = monster.getMove(this);
			monster.move(cmd);
		}
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
	* @return le trésor
	*/
	@Override
	public Treasure getTreasure() {
		return this.treasure;
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
	* @return true si il y a un teleporteur à la position (x,y)
	*/
	@Override
	public boolean isTeleporter(int x, int y) {
		return this.teleporters[y][x] != null;
	}

	/**
	* @param x
	* @param y
	* @return teleporteur à la position (x,y)
	*/
	@Override
	public Teleporter getTeleporter(int x, int y) {
		return this.teleporters[y][x];
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
