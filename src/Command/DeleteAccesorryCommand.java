package Command;

import Items.Accessory;
import Items.Bouquet;

import java.util.Scanner;

public class DeleteAccesorryCommand implements Command{
    private Bouquet bouquet;
    private Scanner in;

    public DeleteAccesorryCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        System.out.println("Введіть ім'я аксесуару:");
        String deleteAccName = in.next();
        bouquet.deleteAccessory(deleteAccName);
    }
}
