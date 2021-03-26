
package ventanapruebatiempo;
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Julia Ramos Lopez
 */
public class Tiempo {
    
    private int hora;
    private int minuto;
    private int segundo;
    
    private static DecimalFormat dosDigitos =new DecimalFormat("00");
    
    public Tiempo(){
        this(0,0,0);
    }
    public Tiempo (int h){
        this(h,0,0);
    }
    public Tiempo (int h, int m){
        this(h,m,0);
    }
    public Tiempo (int h, int m, int s){
      establecerTiempo(h,m,s);  
    }
    public Tiempo (Tiempo tiempo){
        this(tiempo.obtenerHora(), tiempo.obtenerMinuto(), tiempo.obtenerSegundo());
    }

    private void establecerTiempo(int h, int m, int s) {
     establecerHora(h);
     establecerMinuto(m);
     establecerSegundo(s);
    }

    private void establecerHora(int h) {
      hora=((h>=0&&h<24)?h:0);
    }

    private void establecerMinuto(int m) {
       minuto=((m>=0&&m<60)?m:0);
    }

    private void establecerSegundo(int s) {
        segundo=((s>=0&&s<60)?s:0);
    }
   public int obtenerHora(){
       return hora;
   }
       public int obtenerMinuto(){
           return minuto;
       } 
       public int obtenerSegundo(){
           return segundo;
       }
       public String aStringUniversal(){
           return dosDigitos.format(obtenerHora())+":"
           +dosDigitos.format(obtenerMinuto())+ ":"
                   +dosDigitos.format(obtenerSegundo());
       }
       public String toString(){
           return((obtenerHora()==12||obtenerHora()==0)?
                   12: obtenerHora()%12)+":"+
                   dosDigitos.format(obtenerMinuto())
                   +":"+dosDigitos.format(obtenerSegundo())
                   +(obtenerHora()<12?"AM":"PM");
       }
}
