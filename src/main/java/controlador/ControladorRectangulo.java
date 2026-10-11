/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author USUARIO
 */

import modelo.Punto;
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
    public void mover(double dx, double dy) {
        rectangulo.mover(dx, dy);
    }
    public void escalar(double factor) {
        Punto p1 = rectangulo.getP1();
        Punto p2 = rectangulo.getP2();
        p2.setX(p1.getX() + (p2.getX() - p1.getX()) * factor);
        p2.setY(p1.getY() + (p2.getY() - p1.getY()) * factor);
    }
    public boolean puntoDentro(double x, double y) {
        Punto p1 = rectangulo.getP1();
        Punto p2 = rectangulo.getP2();
        double xMin = Math.min(p1.getX(), p2.getX());
        double xMax = Math.max(p1.getX(), p2.getX());
        double yMin = Math.min(p1.getY(), p2.getY());
        double yMax = Math.max(p1.getY(), p2.getY());
        return x >= xMin && x <= xMax && y >= yMin && y <= yMax;
    }
}