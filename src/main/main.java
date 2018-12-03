import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import presentation.*;
import application.*;

public class main {

    public static void main(String[] args)throws InterruptedException{

     		// creation du jeu particulier et de son afficheur
     		LabyrinthGame game = new LabyrinthGame("resources/lvl1.txt");
     		LabyrinthPainter painter = new LabyrinthPainter(game);
     		LabyrinthController controller = new LabyrinthController();

     		// classe qui lance le moteur de jeu generique
     		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);

     		engine.run();

    }

}
