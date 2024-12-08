package Command;

import Items.Bouquet;

import java.util.Scanner;

public class SortFlowersCommand implements Command{
    private Bouquet bouquet;
    private Scanner in;

    public SortFlowersCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        System.out.println("Введіть критерій сортування:\n" +
                "1.За свіжістю\n" +
                "2.За довжиною стебла\n" +
                "3.За ціною\n" +
                "4.Назад");
        int sortChoice = in.nextInt();
        //Перевірка, чи правильно вказана команда
        if(sortChoice<4&&sortChoice>=1){
            System.out.println("Сортувати за зростанням?\n" +
                    "1.Так\n" +
                    "2.Ні\n");
            //Задавання параметра, чи сортування за зростанням, чи спаданням
            int ascendChoice = 0;
            ascendChoice=in.nextInt();

            boolean ascending = false;
            if(ascendChoice==1){
                ascending = true;
            } else if(ascendChoice ==2){
                ascending = false;
            } else{
                System.out.println("Неправильний вибір!");

            }
            if(ascendChoice!=0){
                switch(sortChoice){
                    case 1:
                        bouquet.sortFlowersByFreshness(ascending);
                        break;
                    case 2:
                        bouquet.sortFlowersByLength(ascending);
                        break;
                    case 3:
                        bouquet.sortFlowersByPrice(ascending);
                        break;
                    default:
                        break;
                }
            }

        } else if(sortChoice==4){
            System.out.println("Відміна.");
        } else{
            System.out.println("Неправильний вибір!");
        }
    }
}
