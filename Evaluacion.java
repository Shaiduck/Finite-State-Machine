/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dfa;

import java.util.Arrays;

/**
 *
 * @author Shaiduck
 */
public class Evaluacion {
    Automata x;
    String alfabeto;
    
    public Evaluacion(Automata x, String alfabeto){
        int indiceActual = 0;
        int indiceTrans = 0;
        int indiceTrans2 = 0;
        int indiceEval = 0;
        int loop = 0;
        String estadoActual = x.getStart();
        String[] evaluar = alfabeto.split("(?!^)"); //devuelve [a][a][b][b][a]
        while (indiceEval!=evaluar.length){
            String shala = x.getTransicion().get(indiceTrans).toString(); //devuelve A,a,A
            String[] letras=shala.split(","); // devuelve [A][a][A]
            if (letras[indiceActual].equals(estadoActual)){ // si el estado en SHALA es igual al estadoActual, entonces
                if (evaluar[indiceEval].equals(letras[1])){ // Si la entrada es igual al estado de Transición
                    estadoActual=letras[2]; //El estado actual se vuelve el estado de la transición
                    indiceTrans=0; //Se reinicia el contador de la línea con el camino a evaluar
                    indiceEval++; //Se cambia el indice para la entrada a Evaluar
                }
                else{
                    indiceTrans++; // Aumenta el contador de la línea con el camino a evaluar para encontrar la transición correspondiente con el estado
                }
            }
            else{
                indiceTrans++; // Aumenta el contador de la línea con el camino a evaluar para encontrar el estado correspondiente
            }
            loop++;
        }
        String[] finales = x.getEnding().split(","); // En caso de ser varios finales, se dividen
        int largo= finales.length; // sirve para saber cuando hemos llegado al final de la cadena y evitar un loop infinito
        int marca = 0; //indice para evitar loop infinito
        while (marca < largo){
            if (estadoActual.equals(finales[marca])){ //si el estado actual es el mismo que el estado final en el indice
                System.out.println("La Cadena "+alfabeto+" ha sido aceptada por el automata"); // se declara la aceptación del autómata
                break;
            }
            else{
                marca++; //se busca otro estado de aceptación
            }
        }
        if (marca==largo){ //Si se agotaron los estados de aceptación y el estado actual no es igual a ninguno de ellos
            System.out.println("La Cadena "+alfabeto+" no ha sido aceptada por el automata. El estado en el que termina es "+estadoActual.toString());
        }
    }
}
