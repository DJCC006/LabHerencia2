/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labsemana2;

import java.awt.event.ActionEvent;
import static labsemana2.Empresa.listaEmpleados;

/**
 *
 * @author David
 */
public class LabSemana2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
              ventanaGenReporte ventana= new ventanaGenReporte(listaEmpleados);
    } 
}
