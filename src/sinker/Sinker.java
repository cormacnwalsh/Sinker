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
        int hitcount = 0;
        int misscount =0;
        
        JOptionPane.showMessageDialog(null,"Welcome to GridShip");//Start Screen
        
        Grid g = new Grid();//Creates hidden Grid
        Grid p = new Grid();//Creates visible grid
        g.fillGrid();//Fills the grid with water
        p.fillGrid();
        
        Ship ds = new Ship();//Generates Ship
        
        int D = ds.d;
        int S = ds.s;
        
        //g.grid[(int)(Math.random()*6)] = (s.ship1);//Places Ship in random space
        
        g.grid[D] = 'd';
        g.grid[S] = 's';

        for(int i = 0; i < g.grid.length; i++){//Game Loop
            
            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(p.grid) + "\n"//selects target space
            + "Select number: 1 - 16" + "\n" + "\nSelect Target now:"));
            
            if(shot >=5 && shot <=8){
            shot = shot+1;
            }
            else if (shot >=9 && shot <=12){
                shot = shot+2;
            }
            else if (shot >=13 && shot <=16){
                shot = shot+3;
            } 
            
            if(p.grid[shot]=='~'){//checks if target space has not been selected before
                
                if(g.grid[shot]=='d'||g.grid[shot]=='s'){//if target contains a ship
                    p.grid[shot]='H';

                }else if(g.grid[shot]=='~'){//if target is empty
                    p.grid[shot]='X';
                }
            }else if(p.grid[shot]=='X'){//if target has been selected before
                JOptionPane.showMessageDialog(null, "Please select an unrevealed space");
                i--;
            }
            
            if(p.grid[shot]== 'H'){
                hitcount++;
                    }
                    if(hitcount == 2){
                    JOptionPane.showMessageDialog(null,Arrays.toString(p.grid)+ "\nCongrats! Game Over");
                    break;
                    }
                    
        
    }
    
    }//main
}//class
    