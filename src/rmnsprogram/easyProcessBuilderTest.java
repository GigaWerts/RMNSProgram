/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmnsprogram;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class easyProcessBuilderTest {
    
    public static void print(Object o){
        
        System.out.println(o);
        
    }

    public static Process easyProcessBuilder(String... Ss) {

        Process p = null;
        ProcessBuilder pb;

        pb = new ProcessBuilder(Ss);

        try {

            p = pb.start();

            
        } catch (IOException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p;

    }

    public static void main(String[] args) {

        File aux = new File("C:/rmns/RMNS79458605694900_2.jar");

        Process p = easyProcessBuilder("java","-jar", aux.getAbsolutePath());
        boolean b;

        do {

            b = p.isAlive();

            System.out.println(b);

        } while (b);

    }

}
