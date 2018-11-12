package Develop;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Entity;
import model.Hero;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class Painter implements GamePainter {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 100;
	protected static final int HEIGHT = 100;
	private int x;
	private int y;

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeut est a afficher
	 */
	public Painter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(BufferedImage im, Hero hero) {
		int x = Entity.position.getxPos();
		int y = Entity.position.getyPos();
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(x,y,10,10);
	}

	@Override
	public int getWidth() {
		return WIDTH;
	}

	@Override
	public int getHeight() {
		return HEIGHT;
	}

}
