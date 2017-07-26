/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinker;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Cormac
 */
public class Sinker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,"Welcome to GridShip by Old Man Lally and that weird guy in the corner");
        JOptionPane.showMessageDialog(null,"Welcome to GridShip by Old Man Lally and that weird guy in the corner");
        
        Grid g = new Grid();
        
        g.fillGrid();
        
        Ship s = new Ship();
        
        g.grid[(int)(Math.random()*6)] = (s.ship1);
        
        char[] play = new char[6];

        for(int i = 0; i < g.grid.length; i++){
            
            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(g.grid) + "\n"
            + "Select Target"))-1;
            
            if(g.grid[shot]=='V'){
                JOptionPane.showMessageDialog(null,"You sunk my gridShip TM.\n"
                        + "BINGO");
                break;
             }//if
            else if(g.grid[shot]=='-'){
                g.grid[shot]='X';
            }//else if
        }//for loop
        
        
    }//main
    
}//class
