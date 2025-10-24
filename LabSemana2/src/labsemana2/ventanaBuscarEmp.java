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
public class ventanaBuscarEmp {
        private static ArrayList<EmpleadoNormal> listaEmpleados;
        private EmpleadoNormal empBuscado;
        
        
        
        
    public ventanaBuscarEmp(ArrayList<EmpleadoNormal> listaEmpleados){
        this.listaEmpleados=listaEmpleados;
         JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);
        
        JLabel titulo = new JLabel("Buscador de Empleado");
        titulo.setBounds(150, 50, 700, 100);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        
        
        JLabel codigoLabel= new JLabel("Ingrese el codigo del empleado: ");
        codigoLabel.setBounds(150, 180, 300, 25);
        
        JTextField codigotxt = new JTextField();
        codigotxt.setBounds(150, 200, 200, 25);
        
        JLabel nameLabel= new JLabel("Nombre Empleado: ");
        nameLabel.setBounds(150, 380, 300, 25);
        
        JTextField nametxt = new JTextField();
        nametxt.setBounds(150, 400, 200, 25);
        
        
        
        JButton btBuscar = new JButton("Buscar Empleado");
        btBuscar.setBounds(150,290, 200, 50);
        btBuscar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              EmpleadoNormal temp= buscarEmpleado(Integer.valueOf(codigotxt.getText()));
              if(temp==null){
                  JOptionPane.showMessageDialog(screen, "El Empleado no Existe");
              }else{
                  empBuscado= temp;
                  nametxt.setText(empBuscado.nombre);
              }
          }
                    
        });
        
    
        
        
        //Botones de acciones
        JButton btRegHoras = new JButton("Registrar Horas Trabajadas");
        btRegHoras.setBounds(500, 180, 200, 50);
        
        btRegHoras.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              subVentHorasTrabajadas sub = new subVentHorasTrabajadas(empBuscado, listaEmpleados);
             
          }
                    
        });
        
        
         JButton btActFechaContrato = new JButton("Actualizar Fecha Contrato");
        btActFechaContrato.setBounds(500, 280, 200, 50);
        
        btActFechaContrato.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
                try{
                    String tipo= empBuscado.tipo;
                if(tipo.equals("Temporal")){
                      subVentActFechaCont sub = new subVentActFechaCont(empBuscado,listaEmpleados);
                }else{
                    JOptionPane.showMessageDialog(screen, "Esta opcion no esta disponible para este empleado");
                }
              }catch(NullPointerException a){
                  JOptionPane.showMessageDialog(screen, "Esta opcion no esta disponible para este empleado");
              }
          }
                    
        });
        
        
        
        
         JButton btRegVentas = new JButton("Registrar Ventas");
        btRegVentas.setBounds(500, 380, 200, 50);
        
        btRegVentas.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              try{
                    String tipo= empBuscado.tipo;
                if(tipo.equals("Ventas")){
                      subVentRegVentas sub = new subVentRegVentas(empBuscado,listaEmpleados);
                }else{
                    JOptionPane.showMessageDialog(screen, "Esta opcion no esta disponible para este empleado");
                }
              }catch(NullPointerException a){
                  JOptionPane.showMessageDialog(screen, "Esta opcion no esta disponible para este empleado");
              }
             
          }
                    
        });
        
        
        JButton btCalPago = new JButton("Calcular Pago Mensual");
        btCalPago .setBounds(500, 480, 200, 50);
        
        btCalPago .addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              subPago sub = new subPago(empBuscado,listaEmpleados);
             
          }
                    
        });
        
        
        
        
        
        
        JButton btRegresar = new JButton("Regresar a Menu");
        btRegresar.setBounds(100, 480, 200, 50);
        
        btRegresar.addActionListener(new ActionListener(){
          @Override 
          public void actionPerformed(ActionEvent e){
              screen.dispose();
              Empresa ventana = new Empresa(listaEmpleados);
          }
                    
        });
        
        
        
        
        
        screen.add(btCalPago );
        screen.add(btBuscar);
        screen.add(btRegHoras);
        screen.add(btActFechaContrato);
        screen.add(btRegVentas);
        screen.add(btRegresar);
        screen.add(btRegHoras);
        screen.add(nameLabel);
        screen.add(nametxt);
        screen.add(codigoLabel);
        screen.add(codigotxt);
        screen.add(titulo);
        screen.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        ventanaBuscarEmp ventana = new ventanaBuscarEmp(listaEmpleados);
    }
    
    
    private EmpleadoNormal buscarEmpleado(int codigo){
        for(EmpleadoNormal empleado: listaEmpleados){
            if(empleado.codigo==codigo){
                return empleado;
            }
        }
        return null;//Caso que no se haya encontrado nada
    }
    
    
}
