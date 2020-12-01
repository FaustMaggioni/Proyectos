/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerieModificada;

import TP4.Punto7.Lista;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Faustino
 */
public class Serie {
    private ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
    private Condition verCap= lock1.writeLock().newCondition();
    private int cantCaps=1;
    private Lista caps= new Lista();
    
    public Serie(){
        caps.insertar("Trailer", caps.longitud()+1);
    }
        
    public void agregarCapitulo(int id){
        lock1.writeLock().lock();
        System.out.println("####### Filmador "+id+" va a AGREGAR el capitulo "+cantCaps+1);
        caps.insertar("Capitulo "+cantCaps+1, cantCaps+1);
        cantCaps++;
        System.out.println("$$$$$$ Nuevo capitulo agregado!");
        lock1.writeLock().lock();
    }
    
    public int getCantCapitulos(){
        int cap;
        lock1.readLock().lock();
        cap= this.cantCaps;
        lock1.readLock();
        return cap;
    }
    
    public void verCapitulo(int nroSocio, int nroCapitulo) throws InterruptedException{
        lock1.readLock().lock();
        System.out.println("Socio "+nroSocio+" mirando: "+caps.recuperar(nroCapitulo));
        Thread.sleep((long) (3000*Math.random()+1000));
        lock1.readLock().unlock();
    }
}
