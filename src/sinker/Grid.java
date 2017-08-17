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
public class Grid {
    
    int gridSize;
    char grid[];
    
    public Grid(int size){
        
        gridSize = (size*size)+size;
        grid = new char[gridSize];
        
        for (int i = 0; i < grid.length; i++) {
            grid[i] = '~';
            if (i % (size+1) == 0) {
                grid[i] = '\n';
            }//if
        }
    }
}//class