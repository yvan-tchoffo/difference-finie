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
public class Power implements Function {
    
    int power;
    
    public Power(){
        power = 1;
    }
    
    public Power(int power){
        if(power<0){
            this.power = 1;
        }
        else{
            this.power = power;
        }
    }
    
    public ArrayList values(int n){
        if(n<0){
            return null;
        }else{
            ArrayList values = new ArrayList<Double>();
            double x0 = 0;
            double x;
            for(int i=0;i!=n;i++){
                x = x0 + (i*1.0/n-1);
                values.add(Math.pow(x, power));
            }
            return values;
        }
    }
}
