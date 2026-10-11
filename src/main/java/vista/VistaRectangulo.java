/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author USUARIO
 */
import controlador.ControladorRectangulo;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VistaRectangulo extends JFrame implements ActionListener {

    private ControladorRectangulo controlador;

    private JTextField txtX1 = new JTextField("0", 5);
    private JTextField txtY1 = new JTextField("0", 5);
    private JTextField txtX2 = new JTextField("4", 5);
    private JTextField txtY2 = new JTextField("3", 5);
    private JButton btnCrear = new JButton("Crear rectángulo");
    private JButton btnArea = new JButton("Calcular área");
    private JTextField txtDx = new JTextField("1", 5);
    private JTextField txtDy = new JTextField("1", 5);
    private JButton btnMover = new JButton("Mover");
    private JLabel lblResultado = new JLabel("Cree un rectángulo para comenzar.");

    public VistaRectangulo(ControladorRectangulo controlador) {
        super("Gestor de Figuras - Rectángulo");
        this.controlador = controlador;
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        panel.add(fila("Vértice 1  x:", txtX1, "y:", txtY1));
        panel.add(fila("Vértice 2  x:", txtX2, "y:", txtY2));
        panel.add(btnCrear);
        panel.add(btnArea);
        panel.add(fila("Mover  dx:", txtDx, "dy:", txtDy));
        panel.add(btnMover);
        panel.add(lblResultado);

        btnCrear.addActionListener(this);
        btnArea.addActionListener(this);
        
        btnMover.addActionListener(this);
        add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnCrear) {
                controlador.crearRectangulo(numero(txtX1), numero(txtY1), numero(txtX2), numero(txtY2));
                lblResultado.setText("Creado: " + controlador.descripcion());
                return;
            }
            if (!controlador.existeRectangulo()) {
                JOptionPane.showMessageDialog(this, "Primero cree un rectángulo.");
                return;
            }
            if (e.getSource() == btnArea) {
                lblResultado.setText("Área = " + controlador.calcularArea());
            }
            if (e.getSource() == btnMover) {
                controlador.mover(numero(txtDx), numero(txtDy));
                lblResultado.setText("Movido: " + controlador.descripcion());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese solo números válidos.");
        }
    }

    private JPanel fila(String etiqueta1, JTextField campo1, String etiqueta2, JTextField campo2) {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        p.add(new JLabel(etiqueta1));
        p.add(campo1);
        p.add(new JLabel(etiqueta2));
        p.add(campo2);
        return p;
    }

    private double numero(JTextField campo) {
        return Double.parseDouble(campo.getText().trim().replace(',', '.'));
    }
}
