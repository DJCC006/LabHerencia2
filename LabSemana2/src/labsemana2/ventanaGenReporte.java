/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsemana2;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
 
/**
 *
 * @author David
 */
public class ventanaGenReporte {

    private JTextArea areaTexto;
    private static ArrayList<EmpleadoNormal> listaEmpleados;

    public ventanaGenReporte(ArrayList<EmpleadoNormal> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;

        JFrame screen = new JFrame();
        screen.setSize(800, 600);  //Tamaño standard para menus
        screen.setResizable(false);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setLocationRelativeTo(null);
        screen.setLayout(null);

        JLabel tituloPrincipal = new JLabel("Lista de Reportes Empleados");
        tituloPrincipal.setBounds(150, 50, 800, 85);
        tituloPrincipal.setFont(new Font("Serif", Font.BOLD, 30));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Serif", Font.BOLD, 30));
        
        JScrollPane scroll=new JScrollPane(areaTexto);
        scroll.setBounds(50,80,700,400);
        screen.add(scroll);

        JButton btMostrar = new JButton("Mostrar Empleados");
        btMostrar.setBounds(150,390, 200, 50);
        screen.add(btMostrar, BorderLayout.SOUTH);
        btMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
             mostrarEmpleados();
            }
        });
        screen.setVisible(true);
    }
    //Mostrar los Datos
    private void mostrarEmpleados() {
        StringBuilder sb=new StringBuilder();
        sb.append("----Empleados Registrados----\n\n");
        for(EmpleadoNormal emp:listaEmpleados){
            sb.append(emp.toString()).append("\n");
        }
        if(listaEmpleados.isEmpty()){
            sb.append("No hay empleados registrados.\n");
        }
        areaTexto.setText(sb.toString());
    }
}
