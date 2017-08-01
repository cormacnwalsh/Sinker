/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinker;

import java.util.Random;

/**
 *
 * @author Cormac
 */

public class Ship {
    
    private Random r = new Random();
    
    private boolean orient;
    
    private int shipStart;
    
    public void setOrient(){
        orient = r.nextBoolean();
    }
    
    public boolean getOrient(){
        return orient;
    }
    
    public void setShipStart(){
        shipStart = r.nextInt(15) + 1;
    }
    
    public int getShipStart(){
        setShipStart();
        return shipStart;
    }
    
}//class
