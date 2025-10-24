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

/**
 *
 * @author David
 */
public class Empresa {
    public static ArrayList<EmpleadoNormal> listaEmpleados;
    
    
    public Empresa(ArrayList<EmpleadoNormal> lista){
        listaEmpleados = lista;
        
        
        JFrame screen = new JFrame();
        screen.setSize(1000, 800);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel tituloPrincipal =  new JLabel("MENU PRINCIPAL DE EMPRESA");
        tituloPrincipal.setBounds(150, 50, 800, 85);
        tituloPrincipal.setFont(new Font("Serif", Font.BOLD, 30));
        
        
        JButton btRegistrar = new JButton("Registrar Empleados");
        btRegistrar.setBounds(200, 180, 200, 50);
        
        btRegistrar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              ventanaRegistrarEmp ventana = new ventanaRegistrarEmp(listaEmpleados);
             
          }
                    
        });
        
        
        
        JButton btBuscarEmp = new JButton("Buscar Empleado");
        btBuscarEmp.setBounds(200, 280, 200, 50);
        
        btBuscarEmp.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              ventanaBuscarEmp ventana = new ventanaBuscarEmp(listaEmpleados);
              
             
          }
                    
        });
        
        
        JButton btGenReporte = new JButton("Generar Reporte");
        btGenReporte.setBounds(200, 380, 200, 50);
        
        btGenReporte.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              
          }
                    
        });
        
        
        
        JButton btSalir = new JButton("Salir");
        btSalir.setBounds(200, 480, 200, 50);
        
        btGenReporte.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
          }
                    
        });
        
        
        
        screen.add(btSalir);
        screen.add(btRegistrar);
        screen.add(btBuscarEmp);
        screen.add(btGenReporte);
        screen.add(tituloPrincipal);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        Empresa ventana = new Empresa(listaEmpleados);
    }
    
}
