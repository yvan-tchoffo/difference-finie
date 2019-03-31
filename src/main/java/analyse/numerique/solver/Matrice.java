/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analyse.numerique.solver;

/**
 *
 * @author Yvan TCHOFFO
 */
public interface Matrice {
    
    public double get(int row,int pos) throws Exception;
    public void set(int row,int pos,double x) throws Exception;
    
}
