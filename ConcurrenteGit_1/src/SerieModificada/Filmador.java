/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerieModificada;

/**
 *
 * @author Faustino
 */
public class Filmador implements Runnable {
    private Serie s;
    private int id;
    public void run(){
        while(true){
            s.agregarCapitulo(id);
        }
    }
    private void filmar(){
 
        Thread.sleep(3000*Math.Random()+1000);
}
