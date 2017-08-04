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
public class Battleship extends Ship {
    
    int B;
    int A;
    int T;
    int L;
    
    public void placeShip() {
        

        for (int i = 1; i > 0; i--) {
            setOrient();
            boolean horizontal = getOrient();
            setShipStart();
            B = getShipStart();

            if (horizontal == true) {
                if ((B == 2)||(B == 3) || (B == 4) ||(B == 6)|| (B == 7) || (B == 8) ||(B == 10) || (B == 11) || (B == 12) || (B == 14) || (B == 15) ||(B == 16)) {
                    i++;
                } else if ((B == 5)) {
                    B = B + 1;
                } else if ((B == 9)) {
                    B = B + 2;
                } else if ((B == 13)) {
                    B = B + 3;
                }
                A = B + 1;
                T = A + 1;
                L = T + 1;

            } else if (horizontal == false) {
                if ((B >= 5) && (B <= 16)) {
                    i++;
                }
                A = B + 5;
                T = A + 5;
                L = T + 5;
            }
        }

    }
}
