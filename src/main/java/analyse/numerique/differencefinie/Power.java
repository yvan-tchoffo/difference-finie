/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse.numerique.differencefinie;

import java.util.ArrayList;

/**
 *
 * @author Yvan TCHOFFO
 */
public class Power implements Function {

    int power;

    public Power() {
        power = 1;
    }

    public Power(int power) {
        if (power < 0) {
            this.power = 1;
        } else {
            this.power = power;
        }
    }

    public ArrayList<Double> values(int n) {
        if (n < 0) {
            return null;
        } else {
            ArrayList<Double> values = new ArrayList<>();
            double x0 = 0;
            double x;
            for (int i = 1; i != n - 1; i++) {
                x = x0 + (i * 1.0 / n - 1);
                values.add(Math.pow(x, power));
            }
            return values;
        }
    }
}
