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
        JOptionPane.showMessageDialog(null,"Welcome to GridShip");//Start Screen
        
        Grid g = new Grid();//Creates hidden Grid
        
        g.fillGrid();//Fills the grid with water
        
        Ship s = new Ship();//Generates Ship
        
        g.grid[(int)(Math.random()*6)] = (s.ship1);//Places Ship in random space
        
        char[] play = new char[6];//Creates visible grid
        
        for(int i = 0; i<play.length; i++){
            play [i] = '-';//Fills visible grid with blank spaces
        }

        for(int i = 0; i < g.grid.length; i++){//Game Loop
            
            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(play) + "\n"//selects target space
            + "Select Target"))-1;
            
            if(play[shot]=='-'){//checks oof target space has not been selected before
                
                if(g.grid[shot]=='V'){//if target contains a ship
                    JOptionPane.showMessageDialog(null,"You sunk my gridShip TM.\n"
                            + "BINGO");
                    break;

                }else if(g.grid[shot]=='-'){//if target is empty
                    play[shot]='X';
                }
            }else if(play[shot]=='X'){//if target has been selected before
                JOptionPane.showMessageDialog(null, "Please select an unrevealed space");
                i--;
            }
        }
        
        
    }//main
    

}//class