package Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bouquet {
    String name;
    List<Flower> flowers;
    List<Accessory> accessories;
    //float totalPrice;

    public Bouquet(String iName){
        this.name = iName;
        this.flowers = new ArrayList<Flower>();
        this.accessories = new ArrayList<Accessory>();
    }
    public Bouquet(){
        this.flowers = new ArrayList<Flower>();
        this.accessories = new ArrayList<Accessory>();
    }


    public void setName(String iName){
        this.name = iName;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public String toString()
    {
        return this.name+
                "\n\tЦіна: "+this.calculateTotalPrice();
    }
    public void addFlower(Flower flower){
        this.flowers.add(flower);
    }
    public void deleteFlower(String name){
        boolean foundAny = false;
        int i = 0;
        for(Flower flower: flowers){
            if(flower.getName().equals(name)){
                foundAny=true;
                break;
            }
            i++;
        }
        if(foundAny){
            flowers.remove(i);
        } else{
            System.out.println("Квітки з таким іменем нема в букеті!");
        }
    }
    public void addAccessory(Accessory accessory){
        this.accessories.add(accessory);
    }
    public void deleteAccessory(String name){
        boolean foundAny = false;
        int i = 0;
        for(Accessory accessory: accessories){
            if(accessory.getName().equals(name)){
                foundAny=true;
                break;
            }
            i++;
        }
        if(foundAny){
            accessories.remove(i);
        } else{
            System.out.println("Аксесуару з таким іменем нема в букеті!");
        }
    }


    //Сортування гнома за свіжістю
    public void sortFlowersByFreshness(Boolean ascending){
        int pos = 0;
        while (pos < this.flowers.size()){
            if(pos == 0||(this.flowers.get(pos).getFreshness()>=this.flowers.get(pos-1).getFreshness()&&ascending)||(this.flowers.get(pos).getFreshness()<=this.flowers.get(pos-1).getFreshness()&&!ascending)){
                pos +=1;
            } else{
                Flower temp = this.flowers.get(pos);
                this.flowers.set(pos,this.flowers.get(pos-1));
                this.flowers.set(pos-1,temp);
            }
        }
        System.out.println("Квіти успішно відсортовано!");
    }
    //Сортування гнома за довжиною стебла
    public void sortFlowersByLength(Boolean ascending){
        int pos = 0;
        while (pos < this.flowers.size()){
            if(pos == 0||(this.flowers.get(pos).getLength()>=this.flowers.get(pos-1).getLength()&&ascending)||(this.flowers.get(pos).getLength()<=this.flowers.get(pos-1).getLength()&&!ascending)){
                pos +=1;
            } else{
                Flower temp = this.flowers.get(pos);
                this.flowers.set(pos,this.flowers.get(pos-1));
                this.flowers.set(pos-1,temp);
            }
        }
        System.out.println("Квіти успішно відсортовано!");
    }
    //Сортування гнома за ціною
    public void sortFlowersByPrice(Boolean ascending){
        int pos = 0;
        while (pos < this.flowers.size()){
            if(pos == 0||(this.flowers.get(pos).calculatePrice()>=this.flowers.get(pos-1).calculatePrice()&&ascending)||(this.flowers.get(pos).calculatePrice()<=this.flowers.get(pos-1).calculatePrice()&&!ascending)){
                pos +=1;
            } else{
                Flower temp = this.flowers.get(pos);
                this.flowers.set(pos,this.flowers.get(pos-1));
                this.flowers.set(pos-1,temp);
            }
        }
        System.out.println("Квіти успішно відсортовано!");
    }

    public void printFlowers(){
        System.out.println("Квіти в букеті:");
        int i = 1;
        for(Flower flower : flowers)System.out.println((i++)+". "+flower);
    }
    public void printAccessories(){
        System.out.println("Аксесуари в букеті:");
        int i = 1;
        for(Accessory accessory : accessories)System.out.println((i++)+". "+accessory);
    }
    public float calculateTotalPrice(){
        float totalPrice = 0;
        for(Flower flower:flowers){
            totalPrice += flower.calculatePrice();
        }
        for(Accessory accessory: accessories){
            totalPrice += accessory.calculatePrice();
        }
        return totalPrice;
    }
    public List<Flower> searchFlowers(String name){
        List<Flower>foundFlowers = new ArrayList<Flower>();
        for(Flower flower : flowers){
            if(flower.getName().equals(name)){
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }
    public List<Flower> searchFlowersByColor(String color){
        List<Flower>foundFlowers = new ArrayList<Flower>();
        for(Flower flower : flowers){
            if(flower.getColor().equals(color)){
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }
    //Шукає квіти з ціною рівною або більше шуканої
    public List<Flower> searchFlowers(float price){
        List<Flower>foundFlowers = new ArrayList<Flower>();
        for(Flower flower : flowers){
            if(flower.calculatePrice() >= price){
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }
    //Шукає квіти з довжиною стебла рівною або більше шуканої
    public List<Flower> searchFlowersByLength(float length){
        List<Flower>foundFlowers = new ArrayList<Flower>();
        for(Flower flower : flowers){
            if(flower.getLength() >= length){
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }
    //Шукає квіти зі свіжістю рівною або більше шуканої
    public List<Flower> searchFlowers(int freshness){
        List<Flower>foundFlowers = new ArrayList<Flower>();
        for(Flower flower : flowers){
            if(flower.getFreshness()>=freshness){
                foundFlowers.add(flower);
            }
        }
        return foundFlowers;
    }
}
