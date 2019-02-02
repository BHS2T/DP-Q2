
package dp.q2;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    List<Product> productList = new ArrayList<>();
    public List returnProducts(){
        Product product1 = new Product();
        product1.name = "Smart Watch";
        product1.quantity = 1000;
        product1.quantityShipped = 5000;
        productList.add(product1);
        
        Product product2 = new Product();
        product2.name = "Smart Remote Control";
        product2.quantity = 20000;
        product2.quantityShipped = 3233;
        productList.add(product2);
        
        Product product3 = new Product();
        product3.name = "Smart Wristband";
        product3.quantity = 5000;
        product3.quantityShipped = 3233;
        productList.add(product3);
        
        Product product4 = new Product();
        product4.name = "Box Mod Kits";
        product4.quantity = 9000;
        product4.quantityShipped = 545;
        productList.add(product4);
        
        Product product5 = new Product();
        product5.name = "Ebook Readers";
        product5.quantity = 3000;
        product5.quantityShipped = 4545;
        productList.add(product5);
        
        Product product6 = new Product();        
        product6.name = "Laser Pointers";
        product6.quantity = 100;
        product6.quantityShipped = 40;
        productList.add(product6);

        Product product7 = new Product();
        product7.name = "Graphics Cards";
        product7.quantity = 800;
        product7.quantityShipped = 434;
        productList.add(product7);
        
        return productList;
    
}
}