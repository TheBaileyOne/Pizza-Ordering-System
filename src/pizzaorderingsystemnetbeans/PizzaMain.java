package pizzaorderingsystemnetbeans;

/**
 * Class to start the running of the Pizza Ordering System.
 * @author Claire Ancient
 */
public class PizzaMain 
{

    public static void main(String[] args) 
    {        
        OrderingSystem orders = new OrderingSystem();
        orders.drawOrderScreen();
        orders.startOrdering();
    }
    
}
