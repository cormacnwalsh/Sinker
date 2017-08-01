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

    int d =(int) (Math.random()*5);
    int s = d+1;

    
    private Random r = new Random();
    
    private boolean orient;
    
    private int shipStart;
    private int crusierStart;
    
        
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
