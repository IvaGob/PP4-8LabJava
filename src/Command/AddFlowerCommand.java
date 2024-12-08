package Command;

import Items.Bouquet;
import Items.Flower;

import java.util.Scanner;

public class AddFlowerCommand implements Command {
    private Bouquet bouquet;
    private Scanner in;

    public AddFlowerCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute() {
        Flower newFlower = new Flower();
        //
        System.out.println("Введіть назву квітки:");
        String FlowerName = in.next();
        newFlower.setName(FlowerName);
        //
        System.out.println("Введіть колір квітки:");
        String FlowerColor = in.next();
        newFlower.setColor(FlowerColor);
        //
        System.out.println("Введіть довжину стебла квітки:");
        float FlowerLength = in.nextFloat();
        newFlower.getLength(FlowerLength);
        //
        System.out.println("Введіть свіжість квітки:");
        int FlowerFreshness= in.nextInt();
        newFlower.setFreshness(FlowerFreshness);
        //
        System.out.println("Введіть максимальну ціну квітки:");
        float flowerMaxPrice = in.nextFloat();
        newFlower.setMaxPrice(flowerMaxPrice);
        bouquet.addFlower(newFlower);
    }
}
