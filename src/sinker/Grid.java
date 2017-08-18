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
        
        gridSize = (size*size)+size; //generates grid as square with an extra column used by computer
        grid = new char[gridSize];
        
        for (int i = 0; i < grid.length; i++) {
            grid[i] = '~';
            if (i % (size+1) == 0) { //makes the grid display in 2 dimensions by putting '\n' into the spare column
                grid[i] = '\n';
            }
        }
    }
}
