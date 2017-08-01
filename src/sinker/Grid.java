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
    char[] grid = new char[20];

    public void fillGrid() {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = '~';
            if (i % 5 == 0) {
                grid[i] = '\n';
            }//if
        }//for loop
    }//method
}//class