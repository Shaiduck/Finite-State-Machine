/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dfa;
import java.io.*;
import java.util.ArrayList;


/**
 *
 * @author Shaiduck
 */
public class Automata {
    
    private String file;
    private ArrayList transicion;
    private ArrayList todo;
    private String alfa;
    private String states;
    private String start;
    private String ending;
    
    public String getFile(){
        return file;
    }
    
    public ArrayList getTransicion(){
        return transicion;
    }
    
    public ArrayList getTodo(){
        return todo;
    }
    
    public String getAlfa(){
        return alfa;
    }
    
    public String getStates(){
        return states;
    }
    
    public String getStart(){
        return start;
    }
    
    public String getEnding(){
        return ending;
    }
    
    private void iniciar(){
        String linea;
        int x=0;
        try{
            FileInputStream archivo = new FileInputStream(getFile());
            DataInputStream input = new DataInputStream(archivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            while ((linea = br.readLine())!=null){
                x++;
                switch(x){
                    case 1:
                        states= linea;
                        todo.add(linea);
                        break;
                    case 2:
                        alfa = linea;
                        todo.add(linea);
                        break;
                    case 3:
                        start=linea;
                        todo.add(linea);
                        break;
                    case 4:
                        ending = linea;
                        todo.add(linea);
                        break;
                    default:
                        getTransicion().add(linea);
                        todo.add(linea);
                }
            }
            input.close();
        }
        catch (IOException z){
            System.out.println("Error Fatal. ¿Que hiciste? D:");
        }
    }
    
    public Automata(String file){
        this.file=file;
        alfa=states=start=ending="";
        todo = new ArrayList();
        transicion = new ArrayList();
        iniciar();
        
    }
}
