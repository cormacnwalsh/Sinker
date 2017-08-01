/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinker;

/**
 *
 * @author Cormac
 */
public class Destroyer extends Ship {

    int D;
    int S;
    
    public void placeShip(){
        
        setShipStart();
        setOrient();
        
        int position = getShipStart();
        boolean horizontal = getOrient();
        
        if((position)>=5&&(position<=8)){
            position = position + 1;
        }else if((position>=9)&&(position<=12)){
            position = position + 2;
        }else if((position>=13)&&(position<=16)){
            position = position + 3;
        }
        D = position;
        
        if((horizontal==true)){
            S = D + 1;
        }else if((horizontal==false)){
            S = D + 5;
        }
        
        
    }
    
}
