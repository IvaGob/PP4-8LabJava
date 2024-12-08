package general;

import Command.*;
import Items.Accessory;
import Items.Bouquet;
import Items.Flower;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FloristSystem {
    private List<Bouquet> bouquets;
    private Scanner in;

    public FloristSystem(){
        bouquets = new ArrayList<Bouquet>();
        in = new Scanner(System.in);
    }

    public void start(){
        showOptions();
    }
    void showHelp(){
        System.out.println("Доступні команди:" +
                "\nСтворити новий букет - задаєте ім'я букета, створюється новий букет з таким ім'ям і додається в список букетів" +
                "\nВибрати букет для редагування - обираєте за іменем букет зі списку і працюєте з ним, доступні такі команди:" +
                "\n   Додати квітку - вводите дані нової квітки, квітка створюється і додається в список квітів" +
                "\n   Видалити квітку - задаєте ім'я, якщо така квітка є, вона видаляється" +
                "\n   Додати аксесуар - вводите дані аксесуару, він створюється і додається в список аксесуарів" +
                "\n   Видалити аксесуар - задаєте ім'я, якщо такий аксесуар є він видаляється" +
                "\n   Відсортувати квіти - задаєте параметри і за ними сортується список квітів" +
                "\n   Вивести список квітів - виводить список квітів" +
                "\n   Вивести список аксесуарів - виводить список аксесуарів" +
                "\n   Знайти квітку в букеті - задаєте параметр і за ним шукаються квіти" +
                "\n   Назад - завершуєте роботу над поточним букетом" +
                "\nВивести всі створені букети - списком виводить назви всіх букетів" +
                "\nВидалити букет - пишете ім'я букета,який хочете видалити і він видаляється зі списку" +
                "\nДопомога - виводить список всіх доступних команд" +
                "\nЗавершити програму - закінчує програму");
    }

    void showOptions(){
        int choice = -1;
        System.out.println("Вітаємо в квітковому магазині \"Є-квіти\"!");
        while(choice != 6){
            System.out.println("Що ви хочете зробити?\n" +
                    "1.Створити новий букет\n" +
                    "2.Вибрати букет для редагування\n" +
                    "3.Вивести всі створені букети\n" +
                    "4.Видалити букет\n" +
                    "5.Допомога\n" +
                    "6.Завершити програму\n");
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                choice = -1;
            }

            switch (choice){
                case 1:
                    createBouquet();
                    break;
                case 2:
                    selectBouquet();
                    break;
                case 3:
                    displayBouquets();
                    break;
                case 4:
                    deleteBouquet();
                    break;
                case 5:
                    showHelp();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Неправильна команда!Спробуйте ще раз.");
                    break;
            }
        }

    }

    void displayBouquets(){
        int i = 1;
        for(Bouquet bouquet : bouquets){
            System.out.println((i++)+". " + bouquet);
        }
    }

    void createBouquet(){
        System.out.println("Введіть назву букета:");
        String bouquetName = in.next();
        Bouquet newBouquet = new Bouquet(bouquetName);
        bouquets.add(newBouquet);
    }

    void deleteBouquet(){
        System.out.println("Введіть назву букета, який хочете видалити:");
        String name = in.next();


        boolean foundAny = false;
        int i = 0;
        for(Bouquet bouquet:bouquets){
            if(bouquet.getName().equals(name)){
                foundAny=true;
                break;
            }
            i++;
        }
        if(foundAny){
            bouquets.remove(i);
        } else{
            System.out.println("Букету з таким іменем нема в букеті!");
        }
    }

    void selectBouquet(){
        displayBouquets();
        System.out.println("Введіть назву букета з яким ви хочете працювати:");
        String name = in.next();
        Bouquet currBouquet = new Bouquet();
        boolean foundBouquet=false;
        for(Bouquet bouquet : bouquets){
            if(bouquet.getName().equals(name)){
                currBouquet = bouquet;
                foundBouquet = true;
                break;
            }
        }
        if(!foundBouquet){
            System.out.println("Такого букета немає!");
        } else{
            List<Command> bouquetCommands = new ArrayList<Command>();

            bouquetCommands.add(new AddFlowerCommand(in,currBouquet));
            bouquetCommands.add(new DeleteFlowerCommand(in,currBouquet));
            bouquetCommands.add(new AddAccesorryCommand(in,currBouquet));
            bouquetCommands.add(new DeleteAccesorryCommand(in,currBouquet));
            bouquetCommands.add(new SortFlowersCommand(in,currBouquet));
            bouquetCommands.add(new PrintFlowersCommand(currBouquet));
            bouquetCommands.add(new PrintAccesoriesCommand(currBouquet));
            bouquetCommands.add(new FindFlowersCommand(in,currBouquet));
            int choice = -1;
            while(true){
                System.out.println("Що ви хочете зробити з цим букетом?\n" +
                        "1.Додати квітку\n" +
                        "2.Видалити квітку\n" +
                        "3.Додати аксесуар\n" +
                        "4.Видалити аксесуар\n" +
                        "5.Відсортувати квіти за критерієм\n" +
                        "6.Вивести список квітів в букеті\n" +
                        "7.Вивести список аксесуарів в букеті\n" +
                        "8.Знайти квіти в букеті\n" +
                        "9.Назад\n");
                choice = in.nextInt();
                if(choice >=1&&choice<9){
                    bouquetCommands.get(choice-1).execute();
                } else if(choice == 9){
                    break;
                } else{
                    System.out.println("Невідома команда!");
                }

            }
        }
    }
}


