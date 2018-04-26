package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.*;
/**
 * Class to create a new flavoured Pizza, that extends pizza
 * @author up878976
 */
public class FlavouredPizza extends Pizza {
    private int topping1;
    private int topping2;
    private double gridX;
    private double gridY;    
    /**
     * Constructor for the flavoured pizza class.
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw pizza on
     * @param startY the top-left y coordinate for the section of screen to draw pizza on
     * @param pizzaSize the size of the pizza base
     * @param crustOption the chosen crust type
     * @param changeSauce if true changes the base sauce to BBQ
     * @param number the number of the pizza
     */
    public FlavouredPizza(Canvas win, double startX, double startY, double pizzaSize, String crustOption, boolean changeSauce, int number){
        super(win, startX, startY, pizzaSize, crustOption, changeSauce, number);
        gridX = startX + 105;
        gridY = startY + 105;   
        
    }
    /**
     * Method to determine which topping to add to the pizza.
     * @param number The number of the topping (1 or 2)
     * @param type the type of topping(tuna or pepper)
     */
    public void addTopping(int number, int type){
        if(number == 1){
            topping1 = type;
            addTopping1(); 
            addToppingPrice1();
        }
        else{
            topping2 = type;
            addTopping2();
            addToppingPrice2();
        }
    }
    /**
     * Method to add first topping to the pizza.
     */
    public void addTopping1(){
        int count = 0;
        double toppingX;
        double toppingY;
        for(int i =0; i<3; i++){
            toppingY = gridY + (i*30);
            for(int j = 0; j<3; j++){
                toppingX = gridX +(j*30);
                if(count%2 == 0){
                    if(topping1 == 1){
                        drawTuna(toppingX, toppingY);
                    }
                    else if(topping1 ==2){
                        drawPepper(toppingX, toppingY);
                    }
                }
                count++;
            }
            
        }
    }
    /**
     * Method to add second topping to the pizza.
     */
    public void addTopping2(){
        int count = 0;
        double toppingX;
        double toppingY;
        for(int i =0; i<3; i++){
            toppingY = (gridY - 10) + (i*40);
            for(int j = 0; j<3; j++){
                toppingX = (gridX - 10) +(j*40);
                if(count%2 == 1){
                    if(topping2 == 1){
                        drawTuna(toppingX, toppingY);
                    }
                    else if(topping2 ==2){
                        drawPepper(toppingX, toppingY);
                    }
                }
                count++;
            }
            
        }
    }
    /**
     * Method to draw a piece of pepper.
     * @param topX the top X coordinate of where to draw the pepper.
     * @param topY the top Y coordinate of where to draw the pepper.
     */
    public void drawPepper(double topX, double topY){
        canvas.setForegroundColor(Color.ORANGE);
        canvas.fillCircle(topX + 10, topY +10, 20);
        canvas.fillCircle(topX + 20, topY +10, 20);
        canvas.fillCircle(topX + 15, topY +20, 20);
        canvas.setForegroundColor(Color.white);
        canvas.fillCircle(topX+10, topY + 10, 15);
        canvas.fillCircle(topX+20, topY + 10, 15);
        canvas.fillCircle(topX+15, topY + 20, 15);
    }
    /**
     * Method to draw a piece of tuna.
     * @param x The top left x coordinate of where to draw the tuna.
     * @param y the top left y coordinate of where to draw the tuna.
     */
    public void drawTuna(double x, double y){
        double topX = x + 15;
        double topY = y;
        int colour = 1;
        for(int i = 5; i>0; i--){
                if(colour%2 == 1){
                    canvas.setForegroundColor(Color.RED);
                    
                }
                else{
                    canvas.setForegroundColor(Color.PINK);
                }
                canvas.fillTriangle(topX, topY, topX - (i*3), topY +(i*3), topX + (i*3), topY +(i*3));
                colour++;
            
        }
    }   
    /**
     * Method to add the price of the first topping to the pizza cost.
     */
    public void addToppingPrice1(){
        double toppingPrice1;
        if(topping1 == 1){
            toppingPrice1 = 0.08*5;
        }
        else{
            toppingPrice1 = 0.02*5;
        }
        price+=toppingPrice1;
    }
    /**
     * Method to add the price of the second topping to the pizza cost.
     */
    public void addToppingPrice2(){
        double toppingPrice2;
        if(topping2 == 1){
            toppingPrice2 = 0.08*4;
        }
        else{
            toppingPrice2 = 0.02*2;
        }
        price+=toppingPrice2;
    }
    /**
     * Method to set the new coordinates of the top left X of the pizza and recalculate the grid positions.
     * @param topx New top x coordinates of pizza.
     * @param topy New top y coordinates of pizza.
     */
    public void setNewCoordinates(double topx, double topy){
        topLeftX = topx;
        topLeftY = topy;
        gridX = topLeftX + 105;
        gridY = topLeftY + 105;
    }

    
    
}
    
