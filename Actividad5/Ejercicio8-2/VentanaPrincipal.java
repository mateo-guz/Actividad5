package Notas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaPrincipal extends JFrame implements ActionListener {
    private JTextField[] camposNotas;
    private JLabel promedio, desviacion, mayor, menor;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        setTitle("Notas");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Container contenedor = getContentPane();
        contenedor.setLayout(new GridLayout(9, 2));

        camposNotas = new JTextField[5];
        for (int i = 0; i < 5; i++) {
            contenedor.add(new JLabel("Nota " + (i + 1) + ":"));
            camposNotas[i] = new JTextField();
            contenedor.add(camposNotas[i]);
        }

        calcular = new JButton("Calcular");
        calcular.addActionListener(this);
        contenedor.add(calcular);

        limpiar = new JButton("Limpiar");
        limpiar.addActionListener(this);
        contenedor.add(limpiar);

        promedio = new JLabel("Promedio: ");
        contenedor.add(promedio);

        desviacion = new JLabel("Desviación estándar: ");
        contenedor.add(desviacion);

        mayor = new JLabel("Nota mayor: ");
        contenedor.add(mayor);

        menor = new JLabel("Nota menor: ");
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcular) {
            try {
                Notas notas = new Notas();
                for (int i = 0; i < 5; i++) {
                    notas.listaNotas[i] = Double.parseDouble(camposNotas[i].getText());
                }
                promedio.setText("Promedio: " + String.format("%.2f", notas.calcularPromedio()));
                desviacion.setText("Desviación estándar: " + String.format("%.2f", notas.calcularDesviacion()));
                mayor.setText("Nota mayor: " + notas.calcularMayor());
                menor.setText("Nota menor: " + notas.calcularMenor());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese solo números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == limpiar) {
            for (JTextField campo : camposNotas) {
                campo.setText("");
            }
        }
    }
}
