/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package differencefinie;

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
    
    public ArrayList<Double> values(int n){
        if(n<0) {
            return null;
        }else{
            ArrayList values = new ArrayList<Double>();
            for(int i=0;i!=n;i++){
                values.add(constant);
            }
            return values;
        }
        
    }
}
