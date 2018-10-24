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
public class Sinker {

    /**
     * @param args the command line arguments
     */
    static int gridSize = 5; //The length of one side of the grid

    static Grid g = new Grid(gridSize); //Creates hidden grid used by computer
    static Grid p = new Grid(gridSize); //Creates visible grid used by player

    static Battleship b = new Battleship(); //Generates new ships
    static Cruiser c = new Cruiser();
    static Destroyer d = new Destroyer();

    public static void main(String[] args) {

        int hitcount = 0; //tracks hits
        int misscount = 0; //tracks misses
<<<<<<< HEAD
        
        int bHit = b.bSize; //tracks ship hitpoints
        int cHit = c.cSize;
        int dHit = d.dSize;
        
=======
        
        int bHit = b.bSize; //tracks ship hitpoints
        int cHit = c.cSize;
        int dHit = d.dSize;
        
>>>>>>> parent of 611c20f... Merge origin/Darragh
        String btype = "BattleShip"; //String for sink message
        String ctype = "Cruiser";
        String dtype = "Destroyer";

        JOptionPane.showMessageDialog(null, "Welcome to GridShip\n" //Start Screen
                                          + "by Cormac Walsh & Darragh Lally");

        spawn(gridSize, b.bSize, 'B'); //spawns ships
        spawn(gridSize, c.cSize, 'C');
        spawn(gridSize, d.dSize, 'D');

        for (int i = 0; i < g.grid.length - gridSize; i++) {//Game Loop

            int shot = Integer.parseInt(JOptionPane.showInputDialog(Arrays.toString(p.grid) + "\n"//selects target space
                    + "Select number: 1 - " + (g.grid.length - gridSize) + "\n" + "\nSelect Target now:"));

            if ((shot <= g.grid.length - gridSize) && (shot > 0)) { //checks if shot is legal
                
                shot = transform(shot); //converts shot into numbers used internally, see method

                if (p.grid[shot] == '~') {//checks if target space has not been selected before

                    if (g.grid[shot] == 'D') {//if target contains a ship segment
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

    public static void spawn(int gridSize, int shipSize, char shipType) { //places ship

        for (int i = 1; i > 0; i--) {
            Ship.setOrient();   //horizontal or vertical
            boolean horizontal = Ship.getOrient();
            
            Ship.setShipStart(gridSize); //start position of ship
            int origin = Ship.getShipStart();

            if (horizontal == true) {
                
                if ((origin % gridSize <= (gridSize + 1) - shipSize) && (origin % gridSize > 0)) { //formula checks if there is horizontal space for the ship                    

                    origin = transform(origin); //converts origin into internally used number

                    boolean check = checkHoriz(origin, shipSize); // checks if spaces are empty
                    
                    if (check == true) {
                        fillHoriz(origin, shipSize, shipType); //places the ship segments
                        
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }

            } else if (horizontal == false) {
                
                if (origin <= (gridSize * gridSize) - ((shipSize - 1) * gridSize)) { //formula checks if there is vertical space for the ship
                    
                    origin = transform(origin); //converts origin into internally used number

                    boolean check = checkVert(origin, shipSize); //checks if spaces are empty
                    
                    if (check == true) {
                        fillVert(origin, shipSize, shipType); //places ship segments
                        
                    } else {
                        i++;
                    }
                } else {
                    i++;
                }
            }
        }
    }

    public static boolean checkHoriz(int origin, int shipSize) {
        boolean check = false;

        while (shipSize > 0) {
            if (g.grid[origin] == '~') {
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

    public static void fillHoriz(int origin, int shipSize, char shipType) { //recursive method to place ship segments horizontally 
        if (shipSize > 0) {
            g.grid[origin] = shipType;
            fillHoriz(origin + 1, shipSize - 1, shipType);
        }
    }

    public static boolean checkVert(int origin, int shipSize) {
        boolean check = false;

        while (shipSize > 0) {
            if (g.grid[origin] == '~') {
                check = true;
                origin = origin + (gridSize + 1);
                shipSize--;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void fillVert(int origin, int shipSize, char shipType) { //recursive method to place ship segments vertically
        if (shipSize > 0) {
            g.grid[origin] = shipType;
            fillVert(origin + (gridSize + 1), shipSize - 1, shipType);
        }
    }
    
    public static int transform(int num){ //generates offset number to add to method argument
        double offset = num / (gridSize + 0.1); //the addition of 0.1 solves an edge case where the resulting number goes out of bounds
                                                //e.g. gridSize = 5; meaning the playable grid is 25 spaces out of 30. If 25 is the input number then 25/5 = 5
        num = (int) (offset + num);             //5+25 = 30, the array is [0-29], therefore 30 is out of bounds.
                                                //25/5.1 = 4, when cast to int, 25+4 = 29, fitting within the array
        return num;
    }
    
    public static void sunk(int hit, String type) { //checks if a ship is sunk

        if (hit == 0) {
            JOptionPane.showMessageDialog(null, "You have sunk an enemy: " + type);
        }
    }
}