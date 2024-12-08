package Items;

public class Flower {
    private String name;
    private String color;
    private float length;
    private int freshness;
    private float maxPrice;

    public Flower(){
        //Нічого :(
    }
    public Flower(String iname, String icolor, float length,int ifreshness,float price){
        this.name=iname;
        this.color=icolor;
        this.length=length;
        this.freshness=ifreshness;
        this.maxPrice=price;
    }
    //Get methods
    public String getName(){
        return this.name;
    }
    public String getColor(){
        return this.color;
    }
    public float getLength(){
        return this.length;
    }
    public int getFreshness(){
        return this.freshness;
    }
    public float getMaxPrice(){
        return this.maxPrice;
    }
    //Set methods
    public void setName(String name){
        this.name=name;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void getLength(float length){
        this.length = length;
    }
    public void setFreshness(int freshness){
        this.freshness = freshness;
    }
    public void setMaxPrice(float maxPrice){
        this.maxPrice = maxPrice;
    }


    @Override
    public String toString() {
        return this.name+
                "\n\tКолір: "+this.color+
                "\n\tДовжина стебла: "+this.length+
                "\n\tСвіжість: "+this.freshness+
                "\n\tЦіна: "+this.calculatePrice();
    }

    float calculatePrice(){
        return maxPrice*((float) freshness /100);
    }
}
