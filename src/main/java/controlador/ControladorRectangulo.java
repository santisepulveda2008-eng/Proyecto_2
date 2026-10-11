/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USUARIO
 */
import modelo.Rectangulo;

public class ControladorRectangulo {

    private Rectangulo rectangulo;

    public void crearRectangulo(double x1, double y1, double x2, double y2) {
        rectangulo = new Rectangulo(x1, y1, x2, y2);
    }

    public boolean existeRectangulo() {
        return rectangulo != null;
    }

    public double calcularArea() {
        return rectangulo.calcularArea();
    }

    public String descripcion() {
        return rectangulo.toString();
    }
}