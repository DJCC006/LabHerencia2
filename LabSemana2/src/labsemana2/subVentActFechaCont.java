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
public class subVentActFechaCont {
    
    private static EmpleadoNormal empleado;
    private static ArrayList<EmpleadoNormal> lista;
    
    
    public subVentActFechaCont(EmpleadoNormal empleado, ArrayList<EmpleadoNormal> lista){
         this.lista=lista;
        this.empleado= empleado;
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Actualizar Fecha de Fin de Contrato");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 40));
        
        
        JLabel NewFechaLabel= new JLabel("Ingrese la Nueva Fecha Final de Contrato Formato(yyyy/MM/dd): ");
        NewFechaLabel.setBounds(150, 180, 300, 25);
        
        JTextField NewFechatxt = new JTextField();
        NewFechatxt.setBounds(150, 200, 200, 25);
        NewFechatxt.setEnabled(false);
       
        
        
        
        JLabel newHoursLabel= new JLabel("Ingrese horas a sumar: ");
        newHoursLabel.setBounds(150, 280, 300, 25);
        
        JTextField newHourstxt = new JTextField();
        newHourstxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton btAddHoras = new JButton("Actualizar Fecha");
        btAddHoras.setBounds(500, 180, 200, 50);
        
        btAddHoras.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
            if(empleado!=null){
                if(NewFechatxt.getText()!=null){
                    EmpleadoTemporal temp =(EmpleadoTemporal) empleado;
                    String fecha = NewFechatxt.getText();
                    temp.actualizarFechaContrato(fecha);
                    JOptionPane.showMessageDialog(screen, "Fecha actualizada correctamente");
                }else{
                    JOptionPane.showMessageDialog(screen, "Aviso: No deje casillas en blanco");
                }
                
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
        screen.add(btAddHoras);
        screen.add(newHoursLabel);
        screen.add(newHourstxt);
        screen.add(NewFechatxt);
        screen.add(NewFechaLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        subVentActFechaCont ventana = new subVentActFechaCont(empleado, lista);
    }
            
    
}
