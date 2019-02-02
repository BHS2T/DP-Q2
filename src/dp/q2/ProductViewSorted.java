package dp.q2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductViewSorted extends ProductView{

    private List<Product> productList;
    List<String> s;
    List <String> sorted;
    ProductViewSorted(ViewAPI viewAPI, List<Product> productList){
     super(viewAPI);   
     this.productList = productList;
    }
    
    @Override
    public void view() {
        
        Collections.sort(productList, (Product p1, Product p2) -> {
            int result = p1.name.compareToIgnoreCase(p2.name);
            if(result>0) return 1;   //p1 is more than p2
            if(result<0) return -1;
            return 0;
        });
        viewAPI.DisplayProduct(productList);
    }

    
}
