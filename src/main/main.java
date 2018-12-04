import java.util.ArrayList;
import java.util.Scanner;

import model.*;
import presentation.*;
import application.*;

public class main {

    public static void main(String[] args)throws InterruptedException{

        int maxLvl = 5;
        int lvl = 1;

        while (lvl <= maxLvl) {

       		// creation du jeu particulier et de son afficheur
       		LabyrinthGame game = new LabyrinthGame("resources/lvl" + Integer.toString(lvl) + ".txt");
       		LabyrinthPainter painter = new LabyrinthPainter(game);
       		LabyrinthController controller = new LabyrinthController();

       		// classe qui lance le moteur de jeu generique
       		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);

          if (lvl == 1)
            game.showHelp("resources/help/help.txt");

       		engine.run();

          if (game.getHero().isDead()) {
            System.out.println("Votre heros est mort.");
            break;
          }
          System.out.println("Vous avez passe le niveau " + Integer.toString(lvl) + "/" + Integer.toString(maxLvl) + " !");
          lvl++;
        }
        if (lvl > maxLvl) {
          System.out.println("Felicitations ! Vous avez fini tous les niveaux !");
        }
        System.exit(0);

    }

}
