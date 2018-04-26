package pizzaorderingsystemnetbeans;

import java.awt.*;
import java.util.*;

/**
 * Class to represent a single pizza.
 * @author UP878976
 */
public class Pizza 
{
    protected Canvas canvas;
    protected double topLeftX;
    protected double topLeftY;
    protected String sizeString;
    protected double area;
    protected String crustType;
    protected String base;
    protected boolean baseChange;
    protected int pizzaNum;
    protected double price;
    
    /**
     * Constructor for pizza.
     * @param win the window to draw the pizza on
     * @param startX the top-left x coordinate for the section of screen to draw pizza on
     * @param startY the top-left y coordinate for the section of screen to draw pizza on
     * @param pizzaSize the size of the pizza base
     * @param crustOption the chosen crust type
     * @param changeBase if true changes the base sauce to BBQ
     * @param number the number of the pizza
     */
    public Pizza(Canvas win, double startX, double startY, double pizzaSize, String crustOption, boolean changeBase, int number)
    {      
        canvas = win;
        topLeftX = startX;
        topLeftY = startY;
        pizzaNum = number + 1;
        crustType = crustOption;
        area = Math.PI * Math.pow((pizzaSize/2),2);
        baseChange = changeBase;       
        if(pizzaSize == 10){
            sizeString = "Small";
        }
        else if(pizzaSize == 12){
            sizeString = "Medium";
        }
        else{
            sizeString = "Large";
        }
        
        if(baseChange){
            base = "BBQ Sauce";
            updateCost(0.5);
        }
        else{
            base = "Tomato Sauce";
        }
        getBasePrice();
    }
    
    /**
     * Method to display the pizza information on the screen.
     */
    public void displayPizza()
    {
        
        drawPizza();
        drawTopLine();
        drawBottomLine();
    }
    
    /**
     * Method to update the cost with the price of the base.
     */
    private void getBasePrice(){
        if("Deep Pan".equals(crustType)){
            updateCost(area * 0.11);
        } 
        else if("Thin Crust".equals(crustType)){
            updateCost(area * 0.08);            
        }
        else{
            updateCost(area * 0.14);
        }
       
    }
    /**
     * Method to draw the Pizza on the screen
     */
    private void drawPizza()
    {
        //draws pizza base
        canvas.setForegroundColor(Color.YELLOW);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 200);
        //draws pizz sauce
        if(baseChange){
            canvas.setForegroundColor(Color.ORANGE);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 170);

        }
        else{
            canvas.setForegroundColor(Color.RED);
            canvas.fillCircle(topLeftX + 150, topLeftY + 150, 170);
        }
        //draws mozzaralla
        canvas.setForegroundColor(Color.WHITE);
        canvas.fillCircle(topLeftX + 150, topLeftY + 150, 150);
    }

    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen.
     */
    private void drawTopLine()
    {
        String topLine = "Pizza " + pizzaNum +"(" + sizeString + ")";
                
        double stringX = topLeftX+10;
        double stringY = topLeftY + 25;
        
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(topLine, stringX, stringY);
    }
    
    /**
     * Method to write the information shown in the bottom line of the 
     * individual pizza on the screen. 
     */
    private void drawBottomLine()
    {
        String bottomLine = "Crust: " + crustType + "(" + base + ")";
                
        double stringX = topLeftX+10;
        double stringY = topLeftY + 290;
        
        canvas.setForegroundColor(Color.BLACK);
        canvas.setFontSize(15);
        canvas.drawString(bottomLine, stringX, stringY);
    }
    
    /**
     * Method to update the price of the pizza.
     * @param cost amount to change cost by.
     */
    public void updateCost(double cost){
        price += cost;
    }
    /**
     * Method to return the price of the pizza.
     * @return Returns the price of the pizza.
     */
    public double getPrice(){
        return price;
    }
    /**
     * Method to return the topLeftX value of the pizza.
     * @return Returns the topLeftX value of the pizza.
     */
    public double getX(){
        return topLeftX;
    }
    /**
     * Method to return the topLeftY value of the pizza.
     * @return Returns the topLeftY value of the pizza.
     */
    public double getY(){
        return topLeftY;
    }
    /**
     * Method to return which canvas the pizza is on.
     * @return returns the canvas the pizza is on.
     */
    public Canvas getCanvas(){
        return canvas;
    }
    /**
     * Method to change the number of the pizza.
     * @param newPizzaNumber the new number of the pizza.
     */
    public void setNewNumber(int newPizzaNumber){
        pizzaNum = newPizzaNumber;
    }
    /**
     * Method to change the canvas the pizza is on.
     * @param canvasNo the new number of the canvas that the pizza is on.
     */
    public void setCanvas(Canvas canvasNo){
        canvas = canvasNo;
    }
        
}
