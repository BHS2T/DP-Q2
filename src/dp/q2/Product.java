package dp.q2;

import java.io.Serializable;


public class Product implements Serializable{
    String name;
    int quantity;
    int quantityShipped;
    public String getName(){
        return name;
    }
    public int quantity(){
        return quantity;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantityShipped(){
        return quantityShipped;
    }
    public void setQuantityShipped(int quantityShipped){
        this.quantityShipped = quantityShipped;
    }
    
}
