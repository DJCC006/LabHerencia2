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
public class subVentRegVentas {
    
    private static EmpleadoNormal empleado;
    private static ArrayList<EmpleadoNormal> lista;
    
    public subVentRegVentas(EmpleadoNormal empleado, ArrayList<EmpleadoNormal> lista){
        this.lista=lista;
        this.empleado= empleado;
        
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Registrar Ventas");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 40));
        
        
        JLabel MesLabel= new JLabel("Ingrese el Mes en donde desea registrar la venta (1-12): ");
        MesLabel.setBounds(150, 180, 300, 25);
        
        JTextField Mestxt = new JTextField();
        Mestxt.setBounds(150, 200, 200, 25);
        Mestxt.setEnabled(false);
       
        
        
        
        JLabel VentasLabel= new JLabel("Ingrese la cantidad de ventas a registrar: ");
        VentasLabel.setBounds(150, 280, 300, 25);
        
        JTextField Ventastxt = new JTextField();
        Ventastxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton btRegistrar = new JButton("Registrar Ventas");
        btRegistrar.setBounds(500, 180, 200, 50);
        
        btRegistrar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
            
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
        screen.add(btRegistrar);
        screen.add(VentasLabel);
        screen.add(Ventastxt);
        screen.add(Mestxt);
        screen.add(MesLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
}
