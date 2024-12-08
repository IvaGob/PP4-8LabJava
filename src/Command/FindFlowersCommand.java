package Command;

import Items.Bouquet;
import Items.Flower;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindFlowersCommand implements Command{
    private Bouquet bouquet;
    private Scanner in;

    public FindFlowersCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        System.out.println("Введіть за яким параметром шукати квіти:" +
                "\n1.За іменем" +
                "\n2.За кольором" +
                "\n3.За ціною" +
                "\n4.За довжиною стебла" +
                "\n5.За свіжістю" +
                "\n6.Назад");
        int searchChoice = in.nextInt();
        List<Flower> foundFlowers = new ArrayList<Flower>();
        if(searchChoice<6&&searchChoice>=1){
            switch(searchChoice){
                case 1:
                    System.out.println("Введіть ім'я квітки:");
                    String SearchName = in.next();
                    foundFlowers = bouquet.searchFlowers(SearchName);
                    break;
                case 2:
                    System.out.println("Введіть колір квітки:");
                    String SearchColor = in.next();
                    foundFlowers = bouquet.searchFlowersByColor(SearchColor);
                    break;
                case 3:
                    System.out.println("Введіть ціну квітки:");
                    float searchPrice = in.nextFloat();
                    foundFlowers = bouquet.searchFlowers(searchPrice);
                    break;
                case 4:
                    System.out.println("Введіть довжину стебла квітки:");
                    float searchLength = in.nextFloat();
                    foundFlowers = bouquet.searchFlowersByLength(searchLength);
                    break;
                case 5:
                    System.out.println("Введіть свіжість квітки:");
                    int searchFreshness = in.nextInt();
                    foundFlowers = bouquet.searchFlowers(searchFreshness);
                    break;

            }
            System.out.println("Знайдені квіти:");
            int i = 1;
            for(Flower flower : foundFlowers){
                System.out.println((i++)+". "+flower);
            }
        } else if(searchChoice==6){
            System.out.println("Повертаємось назад.");
        } else{
            System.out.println("Неправильна команда!");
        }
    }
}
