import model.Hero;
import model.Action;

import java.util.Scanner;

public class main {

    public static void main(String[] args){

        Hero hero = new  Hero(100,25);
        System.out.print("Votre héro est en position" + hero.position.toString());
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
            System.out.print("Votre héro est en position" + hero.position.toString());

        }
    }
}
