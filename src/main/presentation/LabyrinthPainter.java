package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

import model.*;

enum Tile {
	WALL_12, WALL_08, T002, T003, WALL_09, T005, T006, T007, T008, T009, T010, T011, T012, T013, T014, T015, T016, T017, T018, T019, T020,
	WALL_04, WALL_00, T023, T024, WALL_01, T026, T027, T028, T029, T030, T031, T032, T033, T034, T035, T036, T037, T038, T039, T040, T041,
	T042, T043, T044, T045, T046, T047, T048, T049, T050, T051, T052, T053, T054, T055, T056, T057, T058, T059, T060, T061, T062,
	T073, T074, T075, T076, T077, T078, T079, T080, T081, T082, T083, T084, T085, T086, T087, T088, T089, T090, T091, T092, T093,
	WALL_06, WALL_02, T096, T097, WALL_03, T099, T100, T101, T102, T103, T104, T105, T106, T107, T108, T109, T110, T111, T112, T113, T114,
	T115, T116, T117, T118, T119, T120, T121, T122, T123, T124, T125, T126, T127, T128, T129, T130, T131, T132, T133, T134, T135,
	WALL_14, T136, T137, T138, T139, T140, T141, T142, T143, T144, T145, T146, T147, T148, T149, T150, T151, T152, T153, T154, T155, T156

}

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 *
 */
public class LabyrinthPainter implements GamePainter, ImageObserver {

	/**
	 * la taille de l'interface
	 */
	// protected static final int WIDTH = 1024;
	// protected static final int HEIGHT = 768;
	/**
	 * la taille des cases
	 */
	protected static final int CELL_WIDTH = 32;
	protected static final int CELL_HEIGHT = 32;

  private static final int tW = 16;
  private static final int tH = 16;
	// private static final Tile map[][] = {
	// 	{Tile.WALL_12, Tile.WALL_08, Tile.T02, Tile.T03, Tile.WALL_09, Tile.T05, Tile.T06, Tile.T07, Tile.T08, Tile.T09, Tile.T10, Tile.T11, Tile.T12, Tile.T13, Tile.T14, Tile.T15, Tile.T16, Tile.T17, Tile.T18, Tile.T19, Tile.T20},
	// 	{Tile.WALL_04, Tile.T22, Tile.T23, Tile.T24, Tile.WALL_01, Tile.T26, Tile.T27, Tile.T28, Tile.T29, Tile.T30, Tile.T31, Tile.T32, Tile.T33, Tile.T34, Tile.T35, Tile.T36, Tile.T37, Tile.T38, Tile.T39, Tile.T40, Tile.T41}
	// };

	/**
	* jeu à afficher
	*/
	private Game game;

	private Image tileset;

	private boolean[][] canAccess;

	/**
	 * appelle constructeur parent
	 *
	 * @param game
	 *            le jeu est a afficher
	 */
	public LabyrinthPainter(Game game) {
		this.game = game;
		this.canAccess = new boolean[game.getHeight()][game.getWidth()];
		this.tileset = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("resources/tileset_01.png"));
		loadAccess(this.game.getHero().getX(), this.game.getHero().getY());
	}

	private void loadAccess(int x, int y) {
		if (this.canAccess[y][x]) return;
		this.canAccess[y][x] = true;
		if (x < this.game.getWidth()-1 && !this.game.isWall(x+1, y)) this.loadAccess(x+1, y);
		if (y < this.game.getHeight()-1 && !this.game.isWall(x, y+1)) this.loadAccess(x, y+1);
		if (x > 0 && !this.game.isWall(x-1, y)) this.loadAccess(x-1, y);
		if (y > 0 && !this.game.isWall(x, y-1)) this.loadAccess(x, y-1);
	}

	private void drawEntities(Graphics2D crayon) {
		int x = this.game.getHero().getX();
		int y = this.game.getHero().getY();
		crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH,
		(y+1)*CELL_HEIGHT, 12*16-8, 11*16+4, 12*16+12, 12*16+12, null);
		x = this.game.getTreasure().getX();
		y = this.game.getTreasure().getY();
		crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH,
		(y+1)*CELL_HEIGHT, 9*16-4, 7*16-4, 10*16, 8*16+4, null);
		for (Monster monster: this.game.getMonsters()) {
			int xm = monster.getX(),
					ym = monster.getY();
			if (monster instanceof Ghost) {
				crayon.drawImage(tileset, xm*CELL_WIDTH, ym*CELL_HEIGHT, (xm+1)*CELL_WIDTH,
				(ym+1)*CELL_HEIGHT, 13*16-4, 11*16+4, 13*16+16, 12*16+12, null);
			} else {
				crayon.drawImage(tileset, xm*CELL_WIDTH, ym*CELL_HEIGHT, (xm+1)*CELL_WIDTH,
				(ym+1)*CELL_HEIGHT, 11*16, 10*16, 12*16+4, 11*16+4, null);
			}
		}
	}

	private void drawCells(JPanel panel, Graphics crayon) {
		for (int y = 0; y < this.game.getHeight(); y++) {
			for (int x = 0; x < this.game.getWidth(); x++) {
				if (this.game.isTeleporter(x,y)) {
					crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH,
					(y+1)*CELL_HEIGHT, 13*16+8, 3*16, 14*16+8, 4*16, null);
				} else if (this.canAccess[y][x]) {
					int wallsBin = 0;
					if (x >= this.game.getWidth()-1  || this.game.isWall(x+1, y)) wallsBin += 1;
					if (y >= this.game.getHeight()-1 || this.game.isWall(x, y+1)) wallsBin += 2;
					if (x <= 0 || this.game.isWall(x-1, y)) wallsBin += 4;
					if (y <= 0 || this.game.isWall(x, y-1)) wallsBin += 8;
					drawWall(panel, crayon, wallsBin, x, y);
				} else if (y > 0 && this.canAccess[y-1][x]) {
					crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH,
					(y+1)*CELL_HEIGHT, 2*16, 7*16, 3*16, 8*16, null);
				}
				if (this.game.isTrap(x,y)) {
					crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH,
					(y+1)*CELL_HEIGHT, 12*16-8, 8*16, 12*16+12, 10*16-8, null);
				}
			}
		}
	}

	protected void drawWall(JPanel panel, Graphics crayon, int wallsBin, int x, int y) {
		int sx = 0, sy = 0;
		switch(wallsBin) {
			case 0: sx = 32+tW; sy = 32+tH; break;
			case 1: sx = 32+4*tW; sy = 32+1*tH; break;
			case 2: sx = 32+1*tW; sy = 32+4*tH; break;
			case 3: sx = 32+4*tW; sy = 32+4*tH; break;
			case 4: sx = 32+0*tW; sy = 32+1*tH; break;
			case 5: sx = 32+5*tW+tW/4; sy = 32+5*tH-tH/2; break;
			case 6: sx = 32+0*tW; sy = 32+4*tH; break;
			case 7: sx = 32+5*tW+tW/4; sy = 32+5*tH; break;
			case 8: sx = 32+1*tW; sy = 32+0*tH; break;
			case 9: sx = 32+4*tW; sy = 32+0*tH; break;
			case 10: sx = 32+0*tW+tW/2; sy = 32+6*tH; break;
			case 11: sx = 32+1*tW; sy = 32+6*tH; break;
			case 12: sx = 32+0*tW; sy = 32+0*tH; break;
			case 13: sx = 32+5*tW+tW/4; sy = 32+4*tH; break;
			case 14: sx = 32+0*tW; sy = 32+6*tH; break;
			case 15: sx = 32+2*tW+tW/4; sy = 32+6*tH; break;
			default: sx = 0; y = 0; break;
		}
		crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH, (y+1)*CELL_HEIGHT, sx, sy, sx+tW, sy+tH, null);
	}

	protected void drawTile(JPanel panel, Graphics crayon, Tile t, int x, int y) {
      int mx = t.ordinal()%21;
      int my = t.ordinal()/21;
			crayon.drawImage(tileset, x*CELL_WIDTH, y*CELL_HEIGHT, (x+1)*CELL_WIDTH, (y+1)*CELL_HEIGHT, 32+mx*tW, 32+my*tH, 32+(mx+1)*tW, 32+(my+1)*tH, null);
  }

	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		return false;
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	@Override
	public void draw(JPanel panel, BufferedImage im) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setPaint (new Color(30, 30, 40));
		crayon.fillRect (0, 0, im.getWidth(), im.getHeight());
		drawCells(panel, crayon);
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
