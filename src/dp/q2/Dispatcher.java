package dp.q2;

public class Dispatcher {
    private ProductList productList;
    int aa;
    
    public void dispatch(String request){
        
        productList = new ProductList();
        ProductView executive,executiveSorted,customer,customerSorted,customer2,customer2Sorted,buy;

        if(request.equalsIgnoreCase("executive")){
           executive =  new ProductViewNotSorted(new ExecutiveView(),productList.returnProducts());
           executive.view();
            
        }
        if(request.equalsIgnoreCase("executiveSorted")){
            executiveSorted = new ProductViewSorted(new ExecutiveView(), productList.returnProducts());
            executiveSorted.view();
        }
        if(request.equalsIgnoreCase("customer")){
            customer = new ProductViewNotSorted(new CustomerView(), productList.returnProducts());
            customer.view();
        }
        if(request.equalsIgnoreCase("customerSorted")){
            customerSorted = new ProductViewSorted(new CustomerView(), productList.returnProducts());
            customerSorted.view();
        }
        if(request.equalsIgnoreCase("buy")){
            buy = new ProductViewSorted(new BuyView(),productList.returnProducts());
            buy.view();
        }
        if(request.equalsIgnoreCase("customer2")){
            customer2 = new ProductViewNotSorted(new CustomerView2(), productList.returnProducts());
            customer2.view();  
        }
        if(request.equalsIgnoreCase("customer2Sorted")){
            customer2Sorted = new ProductViewSorted(new CustomerView2(), productList.returnProducts());
            customer2Sorted.view();  
        }
        if(request.equalsIgnoreCase("login")){
            Login login = new Login();
            login.Display();
        }
        
        
    }
    
}
