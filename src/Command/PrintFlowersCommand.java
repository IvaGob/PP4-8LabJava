package Command;

import Items.Bouquet;

import java.util.Scanner;

public class PrintFlowersCommand implements Command{
    private Bouquet bouquet;

    public PrintFlowersCommand(Bouquet bouquet){
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        bouquet.printFlowers();
    }
}
