/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dfa;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Shaiduck
 */
public class DFA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        System.out.println("Escriba la ruta del archivo a evaluar\n");
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String path= br.readLine();
        File file = new File(path);
        Automata x = new Automata(path);//Se recibe el nombre del archivo   
        System.out.println("Ingrese la cadena a evaluar sin separacion\n");
        String cadena=br.readLine();
        Evaluacion z = new Evaluacion(x, cadena);
    }
    
}
