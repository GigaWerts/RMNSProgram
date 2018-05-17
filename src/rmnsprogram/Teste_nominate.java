/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmnsprogram;

import java.io.File;

/**
 *
 * @author Felipe
 */
public class Teste_nominate {
    
    private static String nominate(File o) {

        String aux1;
        String aux2;

        try {

            aux1 = o.getName();

            aux2 = aux1.substring(aux1.indexOf("_") + 1, aux1.indexOf("."));
            
            aux2 = Integer.toString(Integer.valueOf(aux2)+1);

            //System.out.println(aux2);

        } catch (NumberFormatException e) {

            aux2 = "2";

        }
        
        return "RMNS"+System.nanoTime()+"_"+aux2+".jar";

    }
    
    public static void main(String[] args){
        
        File a = new File("RMNS.jar");
        File b = new File(nominate(a));
        File c = new File(nominate(b));
        File d = new File(nominate(c));
        File e = new File(nominate(d));
        
        System.out.println(a.getName());
        
        System.out.println(nominate(a));
        System.out.println(nominate(b));
        System.out.println(nominate(c));
        System.out.println(nominate(d));
        System.out.println(nominate(e));
        
        
        a.delete();
        b.delete();
        c.delete();
        d.delete();
        e.delete();
        
        
        
        
    }
    
}
