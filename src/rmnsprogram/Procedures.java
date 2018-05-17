package rmnsprogram;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author brwsprpn0099
 */
public class Procedures {
    
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

    public static int Random_Int(int min, int max) {


        if (max == min) {

            return min;

        } else {

            if (min > max) {

                int aux = min;
                min = max;
                max = aux;

            }

            return min + (int) (Math.random() * (max - min + 1));

        }

    }

    //out = arquivo a ser escrito
    //in = arquivo a ser lido
    public static void easyFileCopier(File out, File in) {

        easyFileWriter(out, corruptedFileReader(in));

    }

    public static void easyFileWriter(File out, String s) {

        FileOutputStream writer;

        try {

            writer = new FileOutputStream(out);
            new DataOutputStream(writer).writeBytes(s);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public static String easyFileReader(File in) {

        int aux;
        String ret = "";
        DataInputStream dis;
        int add = 0;

        //System.out.println(in.getAbsolutePath());

        try {

            dis = new DataInputStream(new FileInputStream(in.getPath()));

            //System.out.println(dis.available());

            while (((aux = dis.read())) != -1) {

                ret += (char) aux;


            }

            //System.out.println(add);                

            dis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;

    }
    
    public static String corruptedFileReader(File in) {//esta funcao le um arquivo e retorna o seu conteudo, porem adiciona
        //um caracter aleatório em uma posicao tambem aleatória no meio deste texto.

        int aux;//variavel usada para verificar o final do arquivo, ao receber o valor -1, percebe-se que o texto acabou
        
        String ret = "";//variavel que recebe a copia do texto, que depois será devolvido pela funcao
        DataInputStream dis; //variavel que se liga ao arquivo de texto para le-lo
        
        int file_size_counter = 0;//variavel que tem duas funcoes, verificar o tamanho do arquivo de texto e para identificar 
        //a posicao que será colocada o character aleatório
        
        int error_position;//variavel que recebe a posicao que será colocado o caracter aleatório        
        
        //double replacing_error = 0.00003;
        
        try {
            
            dis = new DataInputStream(new FileInputStream(in.getPath()));//cria a ligacao de leitura do texto            

            while (((aux = dis.read())) != -1) {//enquanto nao acabar o texto(-1), continue
                
                file_size_counter++;//

            }
            
            //System.out.println(file_size_counter);
            
            error_position = Procedures.Random_Int(0, file_size_counter);
            
            //System.out.println("ERROR POSITION "+error_position);
            
            file_size_counter = 0;
            
            dis = new DataInputStream(new FileInputStream(in.getPath()));            

            while (((aux = dis.read())) != -1) {
                
                //System.out.println(file_size_counter+" ==? "+error_position);
                
                if (file_size_counter == error_position){
                    
                    char random_aux = (char) (int) (Math.random() * 256);
                    
                    ret += random_aux;
                    
                    //System.out.println("RAMDOM CHAR: "+random_aux);
                    
                }

                ret += (char) aux;
                file_size_counter++;

            }
            
            dis.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Procedures.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public static String easyStreamReader(InputStream in) {

        BufferedInputStream bis;

        int aux;
        String ret = "";

        try {

            bis = new BufferedInputStream(in);

            while (((aux = bis.read())) != -1) {

                ret += (char) aux;

            }

            bis.close();


        } catch (IOException ex) {
            Logger.getLogger(Procedures.class
                    .getName()).log(Level.SEVERE, null, ex);

        }

        return ret;


    }
}
