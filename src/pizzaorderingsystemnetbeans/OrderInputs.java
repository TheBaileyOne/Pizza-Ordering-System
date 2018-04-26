
package pizzaorderingsystemnetbeans;

/**
 *Class to get and validate inputs for the ordering system.
 * @author Alex
 */
public class OrderInputs {
    private KeyboardInput inputs;
    /**
     * Constructor for order inputs.
     */
    public OrderInputs(){
        inputs = new KeyboardInput();
    }
    /**
     * Method to get a valid pizza size from the user.
     * @return Returns the pizza size.
     */
    public int getSize(){
        int size;
        boolean valid;
        int[] sizes = new int[]{10,12,14};
        do{
            System.out.println("What size pizza would you like?");
            System.out.println("Sizes available: 1)Small(10\") 2)Medium(12\") 3)Large(14\")");
            System.out.println("Put Option number");
            size = inputs.getInputInteger();
            valid = validation(size, 1, 3);
        } while(!valid);
        System.out.println();
        return sizes[size - 1];
    }
    
    /**
     * Method to get a valid crust type from the user.
     * @return Returns the crust type.
     */
    public String getCrust(){
        boolean valid;
        int crust;
        String[] crusts = new String[]{"Thin Crust", "Deep Pan", "Stuffed Crust"};
        do {
            System.out.println("What type of crust would you like?");
            System.out.println("1)Thin Crust 2)Deep Pan 3)Stuffed Crust");
            System.out.println("Put option number:");  
            crust = inputs.getInputInteger();
            valid = validation(crust, 1, 3);
        }while(!valid);
        System.out.println();
        return crusts[crust - 1];
    }
    /**
     * Method to get the sauce used from user.
     * @return Returns boolean of whether to change sauce.
     */
    public boolean getBase(){
        boolean valid;
        boolean[] changeBase = new boolean[]{true, false};

        int option;
        
        do{
            System.out.println("Do you want to change base to BBQ?");
            System.out.println("1)Yes 2)No");
            System.out.println("Put option number:");
            option = inputs.getInputInteger();
            valid = validation(option, 1, 2);            
        }while(!valid);
        System.out.println();
        return changeBase[option - 1];
    }
    /**
     * Method to return true if more pizzas are required from user.
     * @return returns boolean of whether to add more pizzas.
     */
    public boolean morePizza(){
        boolean valid;
        boolean[] addPizza = new boolean[]{true, false};
        int option;
        
        do{
            System.out.println("Would you like more Pizza?");
            System.out.println("1)Yes 2)No");
            System.out.println("Put option number:");
            option = inputs.getInputInteger();
            valid = validation(option, 1, 2);            
        }while(!valid);
        System.out.println();
        return addPizza[option - 1];
        
    }
    /**
     * Method to get the number of toppings from the user.
     * @return returns the number of pizzas.
     */
    public int toppingNo(){
        int number;
        boolean valid;
        do{
            System.out.println("How many toppings would you like? 0, 1 or 2?");
            number = inputs.getInputInteger();
            valid = validation(number, 0, 2);
        } while(!valid);
        System.out.println();
        return number;
        
    }
    /**
     * Method to get the topping from the user.
     * @return Returns the topping.
     */
    public int toppingChoice(){
        boolean valid;
        int topping;
        
        do{
            System.out.println("Which Topping would you like?");
            System.out.println("1)Tuna 2)Pepper");
            System.out.println("Put option number:");
            topping = inputs.getInputInteger();
            valid = validation(topping, 1, 2);            
        }while(!valid);
        System.out.println();        
        return topping;
        
    }
    /**
     * Method to get whether the user would like to edit the order.
     * @return Returns boolean of if the order is to be edited.
     */
    public boolean editOrder(){
        boolean valid;
        boolean[] edit = new boolean[]{true, false};

        int option;
        
        do{
            System.out.println("Would you like to edit your order");
            System.out.println("1)Yes 2)No");
            System.out.println("Put option number:");
            option = inputs.getInputInteger();
            valid = validation(option, 1, 2);            
        }while(!valid);
        System.out.println();
        return edit[option - 1];
        
    }
    /**
     * Method to get whether the user wants to delete or change pizza.
     * @return Returns whether to delete of change pizza.
     */
    public int changePizza(){
        boolean valid;

        int change;
        
        do{
            System.out.println("How would you like to change your order?");
            System.out.println("1)Delete Pizza 2)Change Pizza");
            System.out.println("Put option number:");
            change = inputs.getInputInteger();
            valid = validation(change, 1, 2);            
        }while(!valid);
        System.out.println();
        return change;
        
    }
    /**
     * Method to return which pizza the user wants to change.
     * @return Returns pizza user wants to change.
     * @param pizzaNo The number of pizzas in the order.
     */
    public int pizzaTochange(int pizzaNo){
        boolean valid;
        int pizza;
        do{
            System.out.println("What Pizza would you like to edit? (1 - " + (pizzaNo) + ")");
            pizza = inputs.getInputInteger();
            valid = validation(pizza, 1, pizzaNo+1);            
        }while(!valid);
        System.out.println();
        return pizza - 1;
    }
    /**
     * Method to get whether the user wants to change screen in the foreground.
     * @return Returns boolean of if user is changing screen.
     */
    public boolean changeScreen(){
        boolean valid;
        boolean[] changeScreen = new boolean[]{true, false};

        int option;
        
        do{
            System.out.println("Would you like to change screen?");
            System.out.println("1)Yes 2)No");
            System.out.println("Put option number:");
            option = inputs.getInputInteger();
            valid = validation(option,1, 2);            
        }while(!valid);
        System.out.println();
        return changeScreen[option - 1];
        
    }
    /**
     * Method to get which screen the user wants to change to.
     * @param screens The number of screens there are.
     * @return Returns the screen number the user wants to change to.
     */
    public int screenTochange(int screens){
        boolean valid;
        
        int screenNo;
        do{
            System.out.println("What screen would you like to change to? (1 - " + (screens+1) + ")");
            screenNo = inputs.getInputInteger();
            valid = validation(screenNo, 1, screens + 1);            
        }while(!valid);
        System.out.println();
        return screenNo - 1;
    }
    /**
     * Method to validate the inputs.
     * @param option the number the user has input
     * @param minimum the minimum number that is valid
     * @param maximum the maximum number that is valid
     * @return returns whether the user input was valid
     */
    public boolean validation(int option, int minimum, int maximum){
        boolean valid;
            if(option >= minimum && option <= maximum){
                valid = true;
            }
            else{
                valid = false;
                System.out.println("Invalid choice. Please enter one of the valid options below");
            }

        return valid;
    }
}
