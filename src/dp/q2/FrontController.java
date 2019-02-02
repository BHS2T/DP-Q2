package dp.q2;

public class FrontController {
    private Dispatcher dispatcher;
    
    public FrontController(){
        dispatcher = new Dispatcher();
    }
    
    public void dispatchRequest(String request){
        dispatcher.dispatch(request);
    }
    
}
