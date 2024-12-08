package Command;

import Items.Bouquet;

public class PrintAccesoriesCommand implements Command{
    private Bouquet bouquet;

    public PrintAccesoriesCommand(Bouquet bouquet){
        this.bouquet = bouquet;
    }
    @Override
    public void execute(){
        bouquet.printAccessories();
    }
}
