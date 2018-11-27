package presentation;

import javax.swing.JFrame;

import model.Game;
import application.GameController;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface  {

	/**
	 * le Panel pour l'afficheur
	 */
	private static final int windowWidth = 1024;
	private static final int windowHeight = 768;
	private DrawingPanel panel;
	/**
	* model
	*/
	private Game game;

	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 *
	 * @param gamePainter l'afficheur a utiliser dans le moteur
	 * @param gameController l'afficheur a utiliser dans le moteur
	 * @param game model du heros
	 *
	 */
	public GraphicalInterface(GamePainter gamePainter, GameController gameController, Game game){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// attacher le panel contenant l'afficheur du game
		this.panel=new DrawingPanel(gamePainter, game);
		f.setContentPane(this.panel);

		// attacher controller au panel du game
		this.panel.addKeyListener(gameController);

		this.game = game;

		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}

	/**
	 * mise a jour du dessin
	 */
	public void paint() {
		this.panel.drawGame();
	}

}
