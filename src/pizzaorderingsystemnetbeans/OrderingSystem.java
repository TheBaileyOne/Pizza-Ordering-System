package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.*;

/**
 * Class to manage the pizza order.
 * @author UP878976
 * 
 */

public class OrderingSystem 
{
    private ArrayList<Canvas> canvas;
    public KeyboardInput keyboardInput;
    private double totalPrice;
    private ArrayList<FlavouredPizza> pizzas;
    private int orderScreens;
    private int pizzaNo;
    private OrderInputs inputs;
    
    /**
     * Constructor for the ordering system.
     */
    public OrderingSystem()
    {
        canvas = new ArrayList<Canvas>(); 
        orderScreens = 0;
        keyboardInput = new KeyboardInput();
        totalPrice = 0;
        pizzas = new ArrayList<FlavouredPizza>();
        pizzaNo = 0;
        inputs = new OrderInputs();
    }
    
    /**
     * Method to draw the outline of the order screen.
     */
    public void drawOrderScreen()
    {
        canvas.add(new Canvas("Pizza Ordering", 900, 650));
        canvas.get(orderScreens).setForegroundColor(Color.BLACK);
        // vertical dividers
        canvas.get(orderScreens).drawLine(300, 0, 300, 600);
        canvas.get(orderScreens).drawLine(600, 0, 600, 600);
        
        // halfway divider
        canvas.get(orderScreens).drawLine(0, 300, 900, 300);
        
        // total price line
        updateTotalPrice(0);
       canvas.get(orderScreens).drawString("Total Price of the Order: £ " + totalPrice, 10, 640);
        
    }
    
    /**
     * Method to manage the ordering of the pizzas.
     */
    
    public void startOrdering()
    {
        boolean morePizza = false;
        int y = 0;
        do {
            do{ 
                int x = (pizzaNo % 3) * 300;
                int size = inputs.getSize();
                String crust = inputs.getCrust();
                boolean changeBase = inputs.getBase();
                int toppingNo;
                int option;
                //adds new pizza to order
                pizzas.add(new FlavouredPizza(canvas.get(orderScreens), x, y, size, crust, changeBase, pizzaNo));
                pizzas.get(pizzaNo).displayPizza();
                //adds toppings to pizza
                toppingNo = inputs.toppingNo();
                for(int i = 0; i<toppingNo;i++){
                    option = inputs.toppingChoice();
                    pizzas.get(pizzaNo).addTopping(i+1, option);
                }
                updateTotalPrice(pizzas.get(pizzaNo).getPrice());
                pizzaNo++;
                if(pizzaNo%6>2){
                    y = 300;
                }
                morePizza = inputs.morePizza();
            }while(morePizza && (pizzaNo%6)!=0);
            //adds a new canvas when 6 pizzas already on a screeen.
            if(morePizza){
                orderScreens++;
                drawOrderScreen();
                y = 0;
            }
        }while(morePizza);
        
        boolean screenChange;
        boolean edit;
        //for changing screen in the foreground
        do{
            screenChange= inputs.changeScreen();
            if(screenChange){
                changeScreen();
            }  
        }while(screenChange);
        do{
            edit = inputs.editOrder();
            if(edit){
                editOrder();
            }
        }while(edit);
               
    }
    /**
     * Method to update the total cost of the order.
     * @param price the cost to be added to the order
     */
    
    public void updateTotalPrice(double price){
        
        totalPrice += price;
        totalPrice = Math.round(totalPrice*100.0)/100.0;
        //erases the price displayed
        for(Canvas win: canvas){
            win.eraseRectangle(10, 610, 400, 50);
            win.setForegroundColor(Color.black);
            win.setFontSize(25);
            win.drawString("Total Price of the Order: £ " + totalPrice, 10, 640);
        }
    }
    /**
     * Method to edit the completed order.
     */
    public void editOrder(){
        int editPizza = inputs.changePizza();
        int pizzaToEdit;
        double price;
        //deletes pizza
        if(editPizza == 1){
            pizzaToEdit = inputs.pizzaTochange(pizzaNo);
            price = pizzas.get(pizzaToEdit).getPrice();
            deletePizza(pizzaToEdit);
            redrawScreen();           
            updateTotalPrice(-price);
            
        }
        //changes pizza
        else{
            pizzaToEdit = inputs.pizzaTochange(pizzaNo);
            price = pizzas.get(pizzaToEdit).getPrice();
            changePizza(pizzaToEdit);
            updateTotalPrice(-price);
            updateTotalPrice(pizzas.get(pizzaToEdit).getPrice());
            
        }
        boolean screenChange;
        do{
            screenChange= inputs.changeScreen();
            if(screenChange){
                changeScreen();
            }  
        }while(screenChange);
    }
    /**
     * Method to delete a pizza from the order.
     * @param pizzaToEdit number of the pizza to delete.
     */
    public void deletePizza(int pizzaToEdit){
        pizzas.remove(pizzaToEdit);
        pizzaNo--;
        
    }
    /**
     * Method to change a pizza in the order.
     * @param pizzaToEdit number of the pizza to edit.
     */
    public void changePizza(int pizzaToEdit){
        Canvas win = pizzas.get(pizzaToEdit).getCanvas();
        double x = pizzas.get(pizzaToEdit).getX();
        double y = pizzas.get(pizzaToEdit).getY();
        //gets inputs for new pizza
        int size = inputs.getSize();
        String crust = inputs.getCrust();
        boolean changeBase = inputs.getBase();
        pizzas.set(pizzaToEdit, new FlavouredPizza(win, x, y, size, crust, changeBase, pizzaToEdit));
        win.eraseRectangle(x +1, y+1, 298, 298);
        pizzas.get(pizzaToEdit).displayPizza();
        //adds toppings
        int toppingNo = inputs.toppingNo();
        for(int i = 0; i<toppingNo;i++){
            int option = inputs.toppingChoice();
            pizzas.get(pizzaToEdit).addTopping(i+1, option);
        }
    }
    /**
     * Method to redraw the pizzas in the new position.
     */
    public void redrawScreen(){
        int canvasCount = 0;
        int count = 0;
        boolean exitFor = false;
        do{
            for(int i = 0; i<2;i++){
                for(int j = 0; j<3; j++){
                    //erases the square the pizza was in
                    canvas.get(canvasCount).eraseRectangle(j*301, i*301, 298, 298);
                    if(count>=pizzaNo){
                        exitFor = true;
                        count++;
                        break;
                    }
                    //redraws pizza in new position
                    pizzas.get(count).setNewCoordinates(j*300, i*300); 
                    pizzas.get(count).setNewNumber(count + 1);
                    pizzas.get(count).setCanvas(canvas.get(canvasCount));
                    pizzas.get(count).displayPizza();
                    pizzas.get(count).addTopping1();
                    pizzas.get(count).addTopping2();
                    
                    count++;

                }
                if(exitFor){
                    break;
                }
            }
            canvasCount++;
        }while(count<=pizzaNo);
    }
    /**
     * Method to change the screen which is in the foreground.
     */
    public void changeScreen(){
        int screenChoice = inputs.screenTochange(orderScreens);
        canvas.get(screenChoice).setVisible(true);
        
    }
    
}
