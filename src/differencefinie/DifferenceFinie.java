/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differencefinie;

import java.util.ArrayList;
import solver.*;
/**
 *
 * @author Yvan TCHOFFO
 */
public class DifferenceFinie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        DefaultFunction f = new DefaultFunction(0.0);
        Power g = new Power(2);
        int n = 101;
        SimpleSolver solver = new SimpleSolver();
        ArrayList<Double> solution1 = solver.solve(n,f.values(n),0,1);
        for(int i=0; i!=solution1.size();i++){
            System.out.println(solution1.get(i));
        }
    }
    
}
