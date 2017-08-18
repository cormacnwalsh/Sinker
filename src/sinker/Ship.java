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
    
    private static Random r = new Random();
    
    private static boolean orient;
    
    private static int shipStart;

    public static void setOrient(){
        orient = r.nextBoolean();
    }
    
    public static boolean getOrient(){
        return orient;
    }
    
    public static void setShipStart(int size){
        shipStart = r.nextInt(size*size)+1;
    }
    
    public static int getShipStart(){
        return shipStart;
    }
    
}//class