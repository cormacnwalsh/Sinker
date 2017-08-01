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
public class Cruiser extends Ship {

    int C;
    int R;
    int U;

    public void placeShip() {

        setShipStart();
        setOrient();

        int position = getShipStart();
        boolean horizontal = getOrient();

        for (int i = 1; i > 0; i--) {
            setShipStart();
            C = getShipStart();

            if (horizontal == true) {
                if ((C == 3) || (C == 4) || (C == 7) || (C == 8) || (C == 11) || (C == 12) || (C == 15) ||(C == 16)) {
                    i++;
                } else if ((C) >= 5 && (C <= 6)) {
                    C = C + 1;
                } else if ((C >= 9) && (C <= 10)) {
                    C = C + 2;
                } else if ((C >= 13) && (C <= 14)) {
                    C = C + 3;
                }
                R = C + 1;
                U = R + 1;

            } else if (horizontal == false) {
                if ((C >= 9) && (C <= 16)) {
                    i++;
                } else if ((C) >= 5 && (C <= 8)) {
                    C = C + 1;
                } else if ((C >= 9) && (C <= 12)) {
                    C = C + 2;
                }
                R = C + 5;
                U = R +1;
            }
        }

    }
}
