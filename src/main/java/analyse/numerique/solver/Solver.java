/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse.numerique.solver;

import java.util.ArrayList;

/**
 *
 * @author Yvan TCHOFFO
 */
public interface Solver {
    public ArrayList<Double> solve(int dim, ArrayList<Double> val, double u0,double u1);
}
