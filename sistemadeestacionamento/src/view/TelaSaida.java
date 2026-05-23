package view;

import javax.swing.*;
import java.awt.*;

import model.Estacionamento;

public class TelaSaida extends JPanel {

    public TelaSaida(
            Estacionamento estacionamento) {

        setLayout(new GridLayout(2, 2, 10, 10));

        JTextField txtPlaca =
                new JTextField();

        JButton btn =
                new JButton("Registrar Saída");

        add(new JLabel("Placa"));
        add(txtPlaca);

        add(new JLabel());
        add(btn);

        btn.addActionListener(e -> {

            estacionamento.registrarSaida(
                    txtPlaca.getText()
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Saída registrada!"
            );
        });
    }
}