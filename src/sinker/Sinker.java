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
        boolean check;

        int hitcount = 0;
        int misscount = 0;

        int dshit = 2;
        int cruhit = 3;
        int batlhit = 4;

        String ctype = "Cruiser";
        String btype = "Battle Ship";
        String dtype = "Destroyer";

        JOptionPane.showMessageDialog(null, "Welcome to GridShip");//Start Screen

        Grid g = new Grid();//Creates hidden Grid
        Grid p = new Grid();//Creates visible grid
        g.fillGrid();//Fills the grid with water
        p.fillGrid();
        
        Battleship batl = new Battleship();
        batl.placeShip();
        g.grid[batl.B] = 'b';
        g.grid[batl.A] = 'a';
        g.grid[batl.T] = 't';
        g.grid[batl.L] = 'l';

        Cruiser cru = new Cruiser();
        boolean cruSpawn = false;
        
        while(cruSpawn==false){ 
            cru.placeShip();
            if((g.grid[cru.C] == '~')&&(g.grid[cru.R]=='~')&&(g.grid[cru.U]=='~')){
            g.grid[cru.C] = 'c';
            g.grid[cru.R] = 'r';
            g.grid[cru.U] = 'u';
            cruSpawn = true;
            }
        }

        Destroyer ds = new Destroyer();//Generates Ship
        boolean destSpawn = false;
        
        while(destSpawn==false){
            ds.placeShip();
            if((g.grid[ds.D]=='~')&&(g.grid[ds.S]=='~')){
                g.grid[ds.D] = 'd';
                g.grid[ds.S] = 's';
                destSpawn = true;
            }
        }

        for (int i = 0; i < g.grid.length - 4; i++) {//Game Loop

            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(p.grid) + "\n"//selects target space
                    + "Select number: 1 - 16" + "\n" + "\nSelect Target now:"));

            if (shot >= 1 && shot <= 16) {

                if (shot >= 5 && shot <= 8) {
                    shot = shot + 1;
                } else if (shot >= 9 && shot <= 12) {
                    shot = shot + 2;
                } else if (shot >= 13 && shot <= 16) {
                    shot = shot + 3;
                }

                if (p.grid[shot] == '~') {//checks if target space has not been selected before

                    if (g.grid[shot] == 'd' || g.grid[shot] == 's') {//if target contains a ship
                        p.grid[shot] = 'H';
                        hitcount++;
                        dshit--;
                        sunk(dshit, dtype);
                    } else if (g.grid[shot] == 'c' || g.grid[shot] == 'r' || g.grid[shot] == 'u') {
                        p.grid[shot] = 'H';
                        hitcount++;
                        cruhit--;
                        sunk(cruhit, ctype);
                    } else if (g.grid[shot] == '~') {//if target is empty
                        p.grid[shot] = 'X';
                        misscount++;
                    } else if (p.grid[shot] == 'X') {//if target has been selected before
                        JOptionPane.showMessageDialog(null, "Please select an unrevealed space");
                        i--;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Space has already been selected");
                    i--;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select a valid space");
                i--;
            }

            if (hitcount == 9) {
                JOptionPane.showMessageDialog(null, Arrays.toString(p.grid) + "\nCongrats! Game Over It took you " + (hitcount + misscount) + " shots");
                break;
            }

        }

    }//main

    public static void sunk(int hit, String type) {

        if (hit == 0) {
            JOptionPane.showMessageDialog(null, "You have sunk an enemy: " + type);
        }
    }
}//class

