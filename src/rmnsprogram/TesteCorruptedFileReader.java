/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmnsprogram;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class TesteCorruptedFileReader {
    
    public static String corruptedFileReader(File in) {//esta funcao le um arquivo e retorna o seu conteudo, porem adiciona
        //um caracter aleatório em uma posicao tambem aleatória no meio deste texto.

        int aux;//variavel usada para verificar o final do arquivo, ao receber o valor -1, percebe-se que o texto acabou
        
        String ret = "";//variavel que recebe a copia do texto, que depois será devolvido pela funcao
        DataInputStream dis; //variavel que se liga ao arquivo de texto para le-lo
        
        int file_size_counter = 0;//variavel que tem duas funcoes, verificar o tamanho do arquivo de texto e para identificar 
        //a posicao que será colocada o character aleatório
        
        int error_position = 0;//variavel que recebe a posicao que será colocado o caracter aleatório        
        
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
    
    public static void main(String[] args){
        
        File arquivo = new File("existe.txt");
        
        System.out.println(corruptedFileReader(arquivo));     
        
        
        
    }
    
}
