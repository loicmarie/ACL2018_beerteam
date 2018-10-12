import model.Hero;

import java.util.Scanner;

public class main {

    public static void main(String[] args){

        Hero hero = new  Hero(100,25);
        System.out.print("Votre héro est en position" + hero.position.toString());
        for (int i=0; i < 10; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Entrez commande (L/R/D/U/S)");
            String direction = sc.nextLine();
            hero.move(direction);
            System.out.print("Votre héro est en position" + hero.position.toString());

        }
    }
}
