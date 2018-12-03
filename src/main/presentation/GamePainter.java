package presentation;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import model.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * represente la maniere de dessiner sur un JPanel
 *
 */
public interface GamePainter {

	/**
	 * methode dessiner a completer. Elle construit une image correspondant au
	 * jeu. Game est un attribut de l'afficheur
	 *
	 * @param image
	 *            image sur laquelle dessiner
	 */
	public abstract void draw(JPanel panel, BufferedImage image);

	public abstract int getWidth();

	public abstract int getHeight();

}
