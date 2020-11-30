/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerieModificada;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Faustino
 */
public class Socio implements Runnable {
    private Serie s;
    private int id;
    public void run(){
        while(true){
            try {
                int n= s.getCantCapitulos();
                int numero = (int) (Math.random() * n) + 1;
                s.verCapitulo(id, numero);
            } catch (InterruptedException ex) {
                Logger.getLogger(Socio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
