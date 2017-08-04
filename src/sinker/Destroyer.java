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
public class Destroyer extends Ship {

    int D;
    int S;

    public void placeShip() {

        

        for (int i = 1; i > 0; i--) {
            setOrient();
            boolean horizontal = getOrient();
            setShipStart();
            D = getShipStart();
            
            if (horizontal == true) {
                if ((D == 4) || (D == 8) || (D == 12) || (D == 16)) {
                    i++;
                } else if ((D) >= 5 && (D <= 7)) {
                    D = D + 1;
                } else if ((D >= 9) && (D <= 11)) {
                    D = D + 2;
                } else if ((D >= 13) && (D <= 15)) {
                    D = D + 3;
                }
                S = D + 1;

            } else if (horizontal == false) {
                if ((D >= 13) && (D <= 16)) {
                    i++;
                } else if ((D) >= 5 && (D <= 8)) {
                    D = D + 1;
                } else if ((D >= 9) && (D <= 12)) {
                    D = D + 2;
                }
                S = D + 5;
            }
        }
    }
}
