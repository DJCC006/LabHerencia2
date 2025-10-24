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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author David
 */
public class ventanaRegistrarEmp {
    
    private static ArrayList<EmpleadoNormal> listaEmpleados;
    
    public ventanaRegistrarEmp(ArrayList<EmpleadoNormal> listaEmpleados){
        this.listaEmpleados=listaEmpleados;
         JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel titulo = new JLabel("Nuevo Empleado");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        
        JLabel codigoLabel= new JLabel("Ingrese el codigo del empleado: ");
        codigoLabel.setBounds(150, 180, 300, 25);
        
        JTextField codigotxt = new JTextField();
        codigotxt.setBounds(150, 200, 500, 25);
        
        
        JLabel nombreLabel= new JLabel("Ingrese el nombre del empleado: ");
        nombreLabel.setBounds(150, 330, 300, 25);
        
        JTextField nombretxt = new JTextField();
        nombretxt.setBounds(150, 350, 500, 25);
        
        String[] items ={"Normal", "Ventas", "Temporal"};
        JComboBox<String> tipoEmpleados = new JComboBox<>(items);
        JLabel tipoLabel= new JLabel("Selecccione el tipo de empleado: ");
        tipoLabel.setBounds(150, 260, 300, 25);
        tipoEmpleados.setBounds(150, 280, 300, 25);
        
        
        
        
        JButton btAgregar = new JButton("Registrar Empleado");
        btAgregar.setBounds(150,390, 200, 50);
         btAgregar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              String type = (String) tipoEmpleados.getSelectedItem();
              
              
              switch(type){
                  case "Normal":
                      
                      EmpleadoNormal newEmp = new EmpleadoNormal (Integer.valueOf(codigotxt.getText()), nombretxt.getText());
                      listaEmpleados.add(newEmp);
                      JOptionPane.showMessageDialog(screen, "Se ha agregado el empleado de forma exitosa");
                      break;

                      
                  case "Ventas":
                      /*
                      EmpleadoVentas newEmpV = new EmpleadoVentas(Integer.valueOf(codigotxt.getText()), nombretxt.getText(),0.5);
                      listaEmpleado.add(newEmpV);
                      System.out.println("Se ha agregado el empleado de forma exitosa");
                      break;
*/
                      
                  case "Temporal":
                      /*
                      EmpleadoTemporal newEmpT = new EmpleadoTemporal(Integer.valueOf(codigotxt.getText()), nombretxt.getText(),"2026/02/10");
                      listaEmpleado.add(newEmpT);
                      System.out.println("Se ha agregado el empleado de forma exitosa");
                      break;
*/
              }  
          }
                    
        });
        
         JButton btRegresar = new JButton("Regresar a Menu");
        btRegresar.setBounds(450,390, 200, 50);
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              Empresa ventana = new Empresa(listaEmpleados);
          }
                    
        });
         
         
        screen.add(tipoLabel);
        screen.add(tipoEmpleados);
        screen.add(btAgregar);
        screen.add(btRegresar);
        screen.add(titulo);
        screen.add(codigoLabel);
        screen.add(codigotxt);
        screen.add(nombreLabel);
        screen.add(nombretxt);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        ventanaRegistrarEmp ventana = new ventanaRegistrarEmp(listaEmpleados);
    }
    
    
}
