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
public class DefaultFunction implements Function {
    
    double constant;
    
    public DefaultFunction(){
        this.constant = 0;
    }
    
    public DefaultFunction(double constant){
        this.constant = constant;
    }
    
    @Override
    public ArrayList<Double> values(int n){
        if(n<2) {
            return null;
        }else{
            ArrayList<Double> values = new ArrayList<>();
            for(int i=0;i!=n-2;i++){
                values.add(constant);
            }
            return values;
        }
        
    }
}
