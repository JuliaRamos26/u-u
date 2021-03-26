/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanapruebatiempo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Julia Ramos Lopez
 */
public class Ventanapruebatiempo extends JFrame {
    private Tiempo tiempo;
    private JLabel horaEtiqueta,minutoEtiqueta,segundoEtiqueta;
    private JTextField horaCampo,minutoCampo,segundoCampo,pantallaCampo;
    private JButton salirBoton;
    
    public Ventanapruebatiempo(){
        super("Demostración de clase interna");
        tiempo=new Tiempo();
        Container contenedor =getContentPane();
        contenedor.setLayout (new FlowLayout());
        
        horaEtiqueta=new JLabel("Ajuste hora");
        horaCampo=new JTextField(10);
        contenedor.add(horaEtiqueta);
        contenedor.add(horaCampo);
        
        minutoEtiqueta=new JLabel("Ajuste minuto");
        minutoCampo=new JTextField(10);
        contenedor.add(minutoEtiqueta);
        contenedor.add(minutoCampo);
        
        segundoEtiqueta=new JLabel("Ajuste segundo");
        segundoCampo=new JTextField(10);
        contenedor.add(segundoEtiqueta);
        contenedor.add(segundoCampo);
        
        pantallaCampo=new JTextField(30);
        pantallaCampo.setEditable(false);
        contenedor.add(pantallaCampo);
        
        salirBoton=new JButton("Salir");
        contenedor.add(salirBoton);
        
        ActionEventHandler manejador=new ActionEventHandler();
        
        horaCampo.addActionListener(manejador);
        minutoCampo.addActionListener(manejador);
        segundoCampo.addActionListener(manejador);
        salirBoton.addActionListener(manejador);
    }
            public void mostrarTiempo(){
                pantallaCampo.setText("La hora es:"+tiempo);
            }
            
    public static void main(String[] args) {
     Ventanapruebatiempo ventana=new
            Ventanapruebatiempo();
     ventana.setSize(400,140);
     ventana.setVisible(true);
    }
    private class ActionEventHandler implements ActionListener{
       
        public void actionPerformed(ActionEvent evento){
            if(evento.getSource()==salirBoton){
                System.exit(0);
            }
            else if(evento.getSource()==horaCampo){
                tiempo.establecerHora(Integer.parseInt(
                evento.getActionCommand()));
                
                horaCampo.setText("");
            }
            else if(evento.getSource()== minutoCampo){
                tiempo.establecerMinuto(Integer.parseInt(
                        evento.getActionCommand()));
                minutoCampo.setText("");
            }
            else if(evento.getSource()==segundoCampo){
                tiempo.establecerSegundo(Integer.parseInt(
                        evento.getActionCommand()));
                segundoCampo.setText("");
            }
            mostrarTiempo();
        }
    }
}
