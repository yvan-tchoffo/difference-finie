/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solver;

import java.util.ArrayList;

/**
 *
 * @author Yvan TCHOFFO
 */
public class SimpleSolver implements Solver {
    private static int dim;
    private static ArrayList<Double> solution;
    private static ArrayList<Double> val;
    private static double[] a;
    private static double[] b;
    
    public  ArrayList<Double> solve(int dim, ArrayList<Double> val, double u0,double u1){
        if(dim<=1){
            return null;
        }
        SimpleSolver.dim = dim;
        SimpleSolver.val = val;
        SimpleSolver.solution = new ArrayList<Double>();
        a = new double[dim-2];
        b = new double[dim-2];
        double h = Math.pow(1.0/(dim-1), 2);
      
        for(int i=0;i!=dim-2;i++){
            if(i == 0){
                a[i] = 2;
                b[i] = (SimpleSolver.val.get(i)*h + u0)/a[i];
            }
            else{
                a[i] = 2 - 1/a[i-1];
                if(i == dim-3){
                    b[i] = (SimpleSolver.val.get(i)*h + u1 + b[i-1])/a[i];
                }
                else{
                    b[i] = (SimpleSolver.val.get(i)*h + b[i-1])/a[i];
                }
            }
            SimpleSolver.solution.add(0.0);
        }
        for(int i = dim-3;i!=-1;i--){
            if(i == dim-3){
                SimpleSolver.solution.set(dim-3 , b[i]);
            }else{
                SimpleSolver.solution.set(i, b[i] + SimpleSolver.solution.get(i + 1)/a[i]);
            }
        }
        
        return SimpleSolver.solution;
    }
    
}
