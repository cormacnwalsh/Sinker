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
    
    ;
    
    private Random r = new Random(); //RNG
    
    private boolean orient; //true = horizontal
    
    private int shipStart; //origin space of ship

    public void setOrient(){
        orient = r.nextBoolean();
    }
    
    public boolean getOrient(){
        return orient;
    }
    
    public void setShipStart(int size){
        shipStart = r.nextInt(size*size)+1; //generates number between 1 and gridsize
    }
    
    public int getShipStart(){
        return shipStart;
    }
    
    public boolean checkOrient(int gridSize, int shipSize){
        
        boolean orient = false;
        
        for (int i = 1; i > 0; i--) {
            setOrient();
            boolean horizontal = getOrient();
            setShipStart(gridSize);
            int origin = getShipStart();
            
            if (horizontal == true) {
                if ((origin % gridSize <= (gridSize + 1) - shipSize) && (origin % gridSize > 0)) {
                    origin = SinkerGame.transform(origin);
                } else {
                    i++;
                }

            } else if (horizontal == false) {
                if (origin <= (gridSize * gridSize) - ((shipSize - 1) * gridSize)) {
                    origin = SinkerGame.transform(origin);
                } else {
                    i++;
                }
            }
        }
        return orient;
    }
    
    public void spawn(boolean orient, int shipSize, char shipType) {
        int origin = getShipStart();
        if(orient == true){
            fillHoriz(origin, shipSize, shipType);
        }else{
            fillVert(origin, shipSize, shipType);
        }
        
    }
    
    private boolean checkHoriz(int origin, int shipSize) {
        boolean check = false;
        
        while (shipSize > 0) {
            if (SinkerGame.g.grid[origin] == '~') {
                check = true;
                origin++;
                shipSize--;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    private void fillHoriz(int origin, int shipSize, char shipType) {
        if (shipSize > 0) {
            SinkerGame.g.grid[origin] = shipType;
            fillHoriz(origin + 1, shipSize - 1, shipType);
        }
    }

    private boolean checkVert(int origin, int shipSize) {
        boolean check = false;

        while (shipSize > 0) {
            if (SinkerGame.g.grid[origin] == '~') {
                check = true;
                origin = origin + (SinkerGame.gridSize + 1);
                shipSize--;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    private void fillVert(int origin, int shipSize, char shipType) {
        if (shipSize > 0) {
            SinkerGame.g.grid[origin] = shipType;
            fillVert(origin + (SinkerGame.gridSize + 1), shipSize - 1, shipType);
        }
    }
    
}