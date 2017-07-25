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
        JOptionPane.showMessageDialog(null,"Welcome to GridShip");
        
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
                        + "griShip is the intellectual property of cormacnwsalsh.\n"
                        + "The work of darragh-l is subject to a waiver on his moral rights\n"
                        + "in perpetuity throughout the cosmos.\n"
                        + "Your statutary rights are unaffected.");
                break;
                
            }else if(g.grid[shot]=='-'){
                g.grid[shot]='X';
            }
        }
        
        
    }
    
}