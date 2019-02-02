
package dp.q2;

public abstract class ProductView {
    ViewAPI viewAPI;
    ProductView(ViewAPI viewAPI){
        this.viewAPI = viewAPI;
    }
    public abstract void view();
    
}
