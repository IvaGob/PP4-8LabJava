package Command;

import Items.Accessory;
import Items.Bouquet;

import java.util.Scanner;

public class AddAccesorryCommand implements Command{
    private Bouquet bouquet;
    private Scanner in;

    public AddAccesorryCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        Accessory newAccessory = new Accessory();
        //
        System.out.println("Введіть назву аксесуару:");
        String AccesorryName = in.next();
        newAccessory.setName(AccesorryName);
        //
        System.out.println("Введіть опис аксесуару:");
        String AccesorryDescr = in.next();
        newAccessory.setDescription(AccesorryDescr);
        //
        System.out.println("Введіть ціну аксесуару:");
        float AccesorryPrice = in.nextFloat();
        newAccessory.setPrice(AccesorryPrice);
        bouquet.addAccessory(newAccessory);
    }
}
