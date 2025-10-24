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
public class subVentHorasTrabajadas {
    
    private static EmpleadoNormal empleado;
    private static ArrayList<EmpleadoNormal> lista;
    
    public subVentHorasTrabajadas(EmpleadoNormal empleado, ArrayList<EmpleadoNormal> lista){
        this.lista=lista;
        this.empleado= empleado;
        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        
        
        JLabel titulo = new JLabel("Agregar Horas Trabajadas");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        JLabel horasActualesLabel= new JLabel("Horas Actuales del Empleado: ");
        horasActualesLabel.setBounds(150, 180, 300, 25);
        
        JTextField actualHrstxt = new JTextField();
        actualHrstxt.setBounds(150, 200, 200, 25);
        actualHrstxt.setEnabled(false);
        if(empleado!=null){
            actualHrstxt.setText(String.valueOf(empleado.horasTrabajadas));
        }
        
        
        
        JLabel newHoursLabel= new JLabel("Ingrese horas a sumar: ");
        newHoursLabel.setBounds(150, 280, 300, 25);
        
        JTextField newHourstxt = new JTextField();
        newHourstxt.setBounds(150, 300, 200, 25);
        
        
        
        //Botones de acciones
        JButton btAddHoras = new JButton("Agregar Horas");
        btAddHoras.setBounds(500, 180, 200, 50);
        
        btAddHoras.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              int horas = Integer.valueOf(newHourstxt.getText());
              if(horas!=0 && horas>0){
                empleado.registrarHoras(horas);
                JOptionPane.showMessageDialog(screen, "Horas Agregadas Exitosamente");  
              }else{
                  JOptionPane.showMessageDialog(screen, "AVISO: Porfavor introducir valores validos");
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
        screen.add(actualHrstxt);
        screen.add(horasActualesLabel);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    public static void main(String[] args) {
        subVentHorasTrabajadas ventana = new subVentHorasTrabajadas(empleado, lista);
    }
    
    
}
