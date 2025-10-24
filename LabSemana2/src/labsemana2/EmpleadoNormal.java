/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labsemana2;

import java.util.Calendar;

/**
 *
 * @author Nathan
 */
public class EmpleadoNormal {

    protected int codigo;
    protected String nombre;
    protected Calendar fechaContratacion;
    protected double salarioBase;
    protected int horasTrabajadas;
    protected String tipo;

    public EmpleadoNormal(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        fechaContratacion = Calendar.getInstance();
        salarioBase = 1300;
        horasTrabajadas = 0;
    }

    public void registrarHoras(int horas) {
        horasTrabajadas = horas;
    }

    public double calcularPago() {
        if (horasTrabajadas < 160) {
            return ((salarioBase * horasTrabajadas) - (salarioBase * 0.035));
        }
        return ((salarioBase * 160) - (salarioBase * 0.035));
    }
    
    @Override
    public String toString(){
        return "Código: "+codigo
                +"\nNombre: "+nombre
                +"\nFecha de Contratación: "+fechaContratacion.getTime();
    }
}
