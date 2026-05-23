package view;

import javax.swing.*;
import java.awt.*;

import model.Estacionamento;

public class TelaEntrada extends JPanel {

    public TelaEntrada(
            Estacionamento estacionamento) {

        setLayout(new GridLayout(3, 2, 10, 10));

        JTextField txtPlaca =
                new JTextField();

        JTextField txtVaga =
                new JTextField();

        JButton btn =
                new JButton("Registrar Entrada");

        add(new JLabel("Placa"));
        add(txtPlaca);

        add(new JLabel("Vaga"));
        add(txtVaga);

        add(new JLabel());
        add(btn);

        btn.addActionListener(e -> {

            estacionamento.registrarEntrada(

                    txtPlaca.getText(),

                    Integer.parseInt(
                            txtVaga.getText()
                    )
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Entrada registrada!"
            );
        });
    }
}