import model.Hero;
import model.Action;

import java.util.Scanner;

import Develop.GameEngineGraphical;
import Develop.HeroController;
import Develop.HeroGame;
import Develop.Painter;

public class main {

    public static void main(String[] args)throws InterruptedException{

     		// creation du jeu particulier et de son afficheur
     		HeroGame game = new HeroGame("helpFilePacman.txt");
     		Painter painter = new Painter();
     		HeroController controller = new HeroController();

     		// classe qui lance le moteur de jeu generique
     		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
     		engine.run();

    }

}
