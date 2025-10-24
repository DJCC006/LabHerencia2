/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsemana2;

import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Nathan
 */
public class EmpleadoTemporal extends EmpleadoNormal {

    private Calendar FechaFinContrato;

    public EmpleadoTemporal(int codigo, String nombre, String fechaVencimiento) {
        
        super(codigo, nombre);
        super.tipo="Temporal";
        int year;
        String yearSt = "";
        int month;
        String monthSt = "";
        int day;
        String daySt = "";

        for (int i = 0; i < fechaVencimiento.length(); i++) {
            if (i >= 0 && i <= 3) {
                yearSt += fechaVencimiento.charAt(i);
            } else if (i >= 5 && i <= 6) {
                monthSt += fechaVencimiento.charAt(i);
            } else if (i >= 8 && i <= 9) {
                daySt += fechaVencimiento.charAt(i);
            }
        }

        year = Integer.valueOf(yearSt);
        month = Integer.valueOf(monthSt);
        day = Integer.valueOf(daySt);
        FechaFinContrato.set(year, month, day);
    }

    public double calcularPago() {
        if (super.fechaContratacion.before(FechaFinContrato) || super.fechaContratacion.equals(FechaFinContrato)) {
            return super.calcularPago();
        }
        return 0;
    }

    public void actualizarFechaContrato(String nuevaFecha) {
        int year;
        String yearSt = "";
        int month;
        String monthSt = "";
        int day;
        String daySt = "";

        for (int i = 0; i < nuevaFecha.length(); i++) {
            if (i >= 0 && i <= 3) {
                yearSt += nuevaFecha.charAt(i);
            } else if (i >= 5 && i <= 6) {
                monthSt += nuevaFecha.charAt(i);
            } else if (i >= 8 && i <= 9) {
                daySt += nuevaFecha.charAt(i);
            }
        }

        year = Integer.valueOf(yearSt);
        month = Integer.valueOf(monthSt);
        day = Integer.valueOf(daySt);
        FechaFinContrato.set(year, month, day);

        JOptionPane.showMessageDialog(null, "La Fecha de fin de contrato se ha actualizado Exitosamente");
    }

    public String toString() {
        String nuevaInfo = super.toString() + "\nFin de Contrato: " + FechaFinContrato.getTime();
        return nuevaInfo;
    }
}
