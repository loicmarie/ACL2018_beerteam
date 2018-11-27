import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import presentation.*;
import application.*;

public class main {

    public static void main(String[] args)throws InterruptedException{

     		// creation du jeu particulier et de son afficheur
     		LabyrinthGame game = new LabyrinthGame();
     		LabyrinthPainter painter = new LabyrinthPainter();
     		LabyrinthController controller = new LabyrinthController();

     		// classe qui lance le moteur de jeu generique
     		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
     		
     		// on crée le labyrinthe
     		ArrayList<Position> walls = new ArrayList<Position>();
     		walls.add(new Position(0, 0));
     		
     		engine.run();

    }

}
