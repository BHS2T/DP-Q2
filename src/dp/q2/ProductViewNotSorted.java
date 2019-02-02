package dp.q2;

import java.util.List;

public class ProductViewNotSorted extends ProductView {
    
    private List<Product> productList;
    
    ProductViewNotSorted(ViewAPI viewAPI, List<Product> productList){
     super(viewAPI);   
     this.productList = productList;
    }
    
    @Override
    public void view() {
        viewAPI.DisplayProduct(productList);
    }
}
