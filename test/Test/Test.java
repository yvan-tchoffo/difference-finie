/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import differencefinie.DefaultFunction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import solver.*;

/**
 *
 * @author Yvan TCHOFFO
 */
public class Test {
    static String fileName = "data.txt";
    static String line = null;
    private static final double absTol = 1e-15;
    public static double test(Solver solver){
        double successrate = 0;
        double total = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Double> result = new ArrayList<Double>();
            while((line = bufferedReader.readLine()) != null) {
                total++;
                String[] values = line.split(" ");
                int i = Integer.parseInt(values[0]);
                int dim = Integer.parseInt(values[1]);
                switch(i){
                    case(0):{
                        DefaultFunction f = new DefaultFunction(0);
                        result = solver.solve(dim, f.values(dim), 0, 0);
                        if(oracle(result,i,dim))
                            successrate++;
                        break;
                    }
                    case(1):{
                        DefaultFunction f = new DefaultFunction(0);
                        result = solver.solve(dim, f.values(dim), 1, 1);
                        if(oracle(result,i,dim))
                            successrate++;
                        break;
                    }
                    case(2):{
                        DefaultFunction f = new DefaultFunction(0);
                        result = solver.solve(dim, f.values(dim), 0, 1);
                        if(oracle(result,i,dim))
                            successrate++;
                        break;
                    }
                    case(3):{
                        DefaultFunction f = new DefaultFunction(-2);
                        result = solver.solve(dim, f.values(dim), 0, 1);
                        if(oracle(result,i,dim))
                            successrate++;
                        break;
                    }
                }
            }   
            bufferedReader.close();
            System.out.println("Taux : " +successrate*100/total+"%" );
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
        }
        
        return successrate;
    }
    
    public static boolean oracle(ArrayList<Double> values, int u, int dim){
        if(dim<=1 && values==null){
            return true;
        }else if(dim>1 && values == null){
                return false;
        }else{
            switch(u){
                case(0):{
                    double max = 0;
                    for(Double i:values){
                        if(Math.abs(i) > max)
                            max = Math.abs(i); 
                    }
                    if(max<absTol)
                        return true;
                    else 
                        return false;
                }
                case(1):{
                    double max = 0;
                    double x = 0;
                    for(Double i : values){
                        x = Math.abs(i-1); 
                        if(x > max)
                            max = x; 
                    }
                    if(max<absTol)
                        return true;
                    else 
                        return false;
                }
                
                case(2):{
                    double x =0;
                    double max = 0 ;
                    for(int i =0; i!=values.size();i++){
                        x = Math.abs(values.get(i) - ((i+1)*1.0/dim-1)); 
                        if( x > max)
                            max = x;
                        
                    }
                    if(max<absTol)
                        return true;
                    else 
                        return false;
                }
                
                case(3):{
                    double x =0;
                    double max = 0 ;
                    for(int i =0; i!=values.size();i++){
                        x = Math.abs(values.get(i) - Math.pow(((i+1)*1.0/dim-1), 2)); 
                        if( x > max)
                            max = x;
                        
                    }
                    if(max<absTol)
                        return true;
                    else 
                        return false;
                }
                
                default:{
                    return false ;
                }
                
            }
        }
        
    }
    
    public static void main(String args[]){
        test(new SimpleSolver());
    }
    
    
    
}