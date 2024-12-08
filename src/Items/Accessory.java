package Items;

public class Accessory {
    String name;
    String description;
    float price;

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return description;
    }
    public Float getPrice(){
        return this.price;
    }
    //
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPrice(float price){
        this.price = price;
    }
    @Override
    public String toString() {
        return this.name+
                "\n\tОпис: "+this.description;
    }

    float calculatePrice(){
        return price;
    }
}
