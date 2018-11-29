package presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Game;


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
	protected static final int WIDTH = 1024;
	protected static final int HEIGHT = 768;
	/**
	 * la taille des cases
	 */
	protected static final int CELL_WIDTH = 50;
	protected static final int CELL_HEIGHT = 50;

	private int x;
	private int y;

	/**
	 * appelle constructeur parent
	 *
	 * @param game
	 *            le jeu est a afficher
	 */
	public LabyrinthPainter() {
	}

	private void drawHero(Graphics2D crayon, Game game) {
		int x = game.getHero().getX() * CELL_WIDTH;
		int y = game.getHero().getY() * CELL_HEIGHT;
		crayon.setColor(Color.blue);
		crayon.fillOval(x,y,CELL_WIDTH,CELL_HEIGHT);
	}

	private void drawWalls(Graphics2D crayon, Game game) {
		crayon.setColor(Color.red);
		for (int y = 0; y < 10; y++)
			for (int x = 0; x < 10; x++)
				if (game.isWall(x,y))
					crayon.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im, Game game) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		drawWalls(crayon, game);
		drawHero(crayon, game);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

	public int getCellWidth() {
		return CELL_WIDTH;
	}

	public int getCellHeight() {
		return CELL_HEIGHT;
	}

}
