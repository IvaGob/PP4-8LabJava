package Command;

import Items.Bouquet;

import java.util.Scanner;

public class DeleteFlowerCommand implements Command{
    private Bouquet bouquet;
    private Scanner in;

    public DeleteFlowerCommand(Scanner in,Bouquet bouquet){
        this.in=in;
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        System.out.println("Введіть ім'я квітки:");
        String deleteFlowerName = in.next();
        bouquet.deleteFlower(deleteFlowerName);
    }
}
