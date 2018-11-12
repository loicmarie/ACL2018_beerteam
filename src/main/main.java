import model.Hero;
import model.Action;

import java.util.Scanner;

import Develop.GameEngineGraphical;
import Develop.HeroController;
import Develop.HeroGame;
import Develop.Painter;

public class main {
	
	

    public static void main(String[] args)throws InterruptedException{

        Hero hero = new  Hero(100,25);
        
     // creation du jeu particulier et de son afficheur
     		HeroGame game = new HeroGame("helpFilePacman.txt");
     		Painter painter = new Painter();
     		HeroController controller = new HeroController();

     		// classe qui lance le moteur de jeu generique
     		GameEngineGraphical engine = new GameEngineGraphical(game, painter, controller);
     		engine.run();
        
        /*System.out.print("Votre héro est en position" + hero.position.toString());
        for (int i=0; i < 10; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez commande (L/R/B/U/S)");
            char direction = sc.nextLine().charAt(0);
            Action action = Action.STOP;
            switch(direction) {
	        	case 'U': action = Action.UP; 	  break;
	        	case 'R': action = Action.RIGHT;  break;
	        	case 'B': action = Action.BOTTOM; break;
            	case 'L': action = Action.LEFT;   break;
            }
            hero.move(action);
            System.out.print("Votre héro est en position" + hero.position.toString());*/

        }
    	
		
    	
    
}
