/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsemana2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class subPago {
     private static EmpleadoNormal empleado;
    private static ArrayList<EmpleadoNormal> lista;
    
    public subPago(EmpleadoNormal empleado, ArrayList<EmpleadoNormal> lista){
         this.lista=lista;
        this.empleado= empleado;
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Calcular Pago");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 40));
        
        
        JLabel pagoLabel= new JLabel("Pago de Empleado: ");
        pagoLabel.setBounds(150, 180, 300, 25);
        
        JTextField pagotxt = new JTextField();
        pagotxt.setBounds(150, 200, 200, 25);
        pagotxt.setEnabled(false);
       
        
        
       
        
        
        
        //Botones de acciones
        JButton btCalcPago = new JButton("Calcular Pago");
        btCalcPago.setBounds(500, 180, 200, 50);
        
        btCalcPago.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
            if(empleado!=null){
                double pago = empleado.calcularPago();
                pagotxt.setText(String.valueOf(pago));
            }
            
          }
                    
        });
        
        
        JButton btRegresar = new JButton("Regresar");
        btRegresar.setBounds(500, 280, 200, 50);
        
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              ventanaBuscarEmp ventana = new ventanaBuscarEmp(lista);
          }
                    
        });
        
        
        
        screen.add(btRegresar);
        screen.add(btCalcPago);
        screen.add(pagotxt);
        screen.add(pagoLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        subPago ventana = new subPago(empleado, lista);
    }
}
