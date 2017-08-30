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
public class SinkerGame {

    public static int gridSize = 5;

    public static Grid g = new Grid(gridSize);//Creates hidden Grid
    public static Grid p = new Grid(gridSize);//Creates visible grid
    
    public void play() {

        Battleship b = new Battleship();
        Cruiser c = new Cruiser();
        Destroyer d = new Destroyer();//Generates Ship
        
        int hitcount = 0;
        int misscount = 0;
        
        int bHit = b.bSize;
        int cHit = c.cSize;
        int dHit = d.dSize;
        
        String btype = "BattleShip";
        String ctype = "Cruiser";
        String dtype = "Destroyer";

        JOptionPane.showMessageDialog(null, "Welcome to GridShip\n"
                                          + "by Cormac & Darragh");//Start Screen

        boolean bOrient = b.checkOrient(gridSize, b.bSize);
        b.spawn(bOrient, b.bSize, 'B');
        
        c.checkOrient(gridSize, c.cSize);
        c.spawn(bOrient, c.cSize, 'C');
        
        d.checkOrient(gridSize, d.dSize);
        d.spawn(bOrient, d.dSize, 'D');
        
        for (int i = 0; i < g.grid.length - gridSize; i++) {//Game Loop

            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(g.grid) + "\n"//selects target space
                    + "Select number: 1 - " + (g.grid.length - gridSize) + "\n" + "\nSelect Target now:"));

            if ((shot <= g.grid.length - gridSize) && (shot > 0)) {
                shot = transform(shot);

                if (p.grid[shot] == '~') {//checks if target space has not been selected before

                    if (g.grid[shot] == 'D') {//if target contains a ship
                        p.grid[shot] = 'H';
                        hitcount++;
                        dHit--;
                        sunk(dHit, dtype);
                    } else if (g.grid[shot] == 'C') {
                        p.grid[shot] = 'H';
                        hitcount++;
                        cHit--;
                        sunk(cHit, ctype);
                    } else if (g.grid[shot] == 'B') {
                        p.grid[shot] = 'H';
                        hitcount++;
                        bHit--;
                        sunk(bHit, btype);
                    } else if (g.grid[shot] == '~') {//if target is empty
                        p.grid[shot] = 'X';
                        misscount++;

                    } else if (p.grid[shot] == 'X') {//if target has been selected before
                        JOptionPane.showMessageDialog(null, "Please select an unrevealed space");
                        i--;
                    }
                } else {
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
    }

//    private void spawn(int gridSize, int shipSize, char shipType) {
//
//        for (int i = 1; i > 0; i--) {
//            Ship.setOrient();
//            boolean horizontal = Ship.getOrient();
//            Ship.setShipStart(gridSize);
//            int origin = Ship.getShipStart();
//
//            if (horizontal == true) {
//                if ((origin % gridSize <= (gridSize + 1) - shipSize) && (origin % gridSize > 0)) {
//                    origin = transform(origin);
//
//                    boolean check = checkHoriz(origin, shipSize);
//                    if (check == true) {
//                        fillHoriz(origin, shipSize, shipType);
//                    } else {
//                        i++;
//                    }
//                } else {
//                    i++;
//                }
//
//            } else if (horizontal == false) {
//                if (origin <= (gridSize * gridSize) - ((shipSize - 1) * gridSize)) {
//                    origin = transform(origin);
//
//                    boolean check = checkVert(origin, shipSize);
//                    if (check == true) {
//                        fillVert(origin, shipSize, shipType);
//                    } else {
//                        i++;
//                    }
//                } else {
//                    i++;
//                }
//            }
//        }
//    }

//    private boolean checkHoriz(int origin, int shipSize) {
//        boolean check = false;
//
//        while (shipSize > 0) {
//            if (g.grid[origin] == '~') {
//                check = true;
//                origin++;
//                shipSize--;
//            } else {
//                check = false;
//                break;
//            }
//        }
//        return check;
//    }
//
//    private void fillHoriz(int origin, int shipSize, char shipType) {
//        if (shipSize > 0) {
//            g.grid[origin] = shipType;
//            fillHoriz(origin + 1, shipSize - 1, shipType);
//        }
//    }
//
//    private boolean checkVert(int origin, int shipSize) {
//        boolean check = false;
//
//        while (shipSize > 0) {
//            if (g.grid[origin] == '~') {
//                check = true;
//                origin = origin + (gridSize + 1);
//                shipSize--;
//            } else {
//                check = false;
//                break;
//            }
//        }
//        return check;
//    }
//
//    private void fillVert(int origin, int shipSize, char shipType) {
//        if (shipSize > 0) {
//            g.grid[origin] = shipType;
//            fillVert(origin + (gridSize + 1), shipSize - 1, shipType);
//        }
//    }
    
    public static int transform(int num){        
        double offset = num / (gridSize + 0.1);
        num = (int) (offset + num);
        
        return num;
    }
    
    private void sunk(int hit, String type) {

        if (hit == 0) {
            JOptionPane.showMessageDialog(null, "You have sunk an enemy: " + type);
        }
    }
}//class