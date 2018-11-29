package presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.*;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 *
 */
public class LabyrinthPainter implements GamePainter {

	/**
	 * la taille de l'interface
	 */
	// protected static final int WIDTH = 1024;
	// protected static final int HEIGHT = 768;
	/**
	 * la taille des cases
	 */
	protected static final int CELL_WIDTH = 50;
	protected static final int CELL_HEIGHT = 50;

	/**
	* jeu à afficher
	*/
	private Game game;

	/**
	 * appelle constructeur parent
	 *
	 * @param game
	 *            le jeu est a afficher
	 */
	public LabyrinthPainter(Game game) {
		this.game = game;
	}

	private void drawEntities(Graphics2D crayon) {
		int x = this.game.getHero().getX() * CELL_WIDTH;
		int y = this.game.getHero().getY() * CELL_HEIGHT;
		crayon.setColor(Color.blue);
		crayon.fillOval(x, y, CELL_WIDTH, CELL_HEIGHT);
		crayon.setColor(Color.red);
		for (Monster monster: this.game.getMonsters()) {
			int xm = monster.getX(),
					ym = monster.getY();
			crayon.fillOval(xm * CELL_WIDTH, ym * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
		}
	}

	private void drawCells(Graphics2D crayon) {
		for (int y = 0; y < this.game.getHeight(); y++) {
			for (int x = 0; x < this.game.getWidth(); x++) {
				if(this.game.isTreasure(x,y)) {
					crayon.setColor(Color.green);
					crayon.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
				} else if (this.game.isWall(x,y)) {
					crayon.setColor(Color.gray);
					crayon.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
				}
			}
		}
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		drawCells(crayon);
		drawEntities(crayon);
	}

	@Override
	public int getWidth() {
		return this.game.getWidth() * CELL_WIDTH;
	}

	@Override
	public int getHeight() {
		return this.game.getHeight() * CELL_HEIGHT;
	}

	public int getCellWidth() {
		return CELL_WIDTH;
	}

	public int getCellHeight() {
		return CELL_HEIGHT;
	}

}
