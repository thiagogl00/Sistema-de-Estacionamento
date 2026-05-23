package view;

import javax.swing.*;
import java.awt.*;

import model.Caminhonete;
import model.Carro;
import model.Estacionamento;
import model.Moto;
import model.Veiculo;

public class TelaCadastroVeiculo extends JPanel {

    public TelaCadastroVeiculo(
            Estacionamento estacionamento) {

        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField txtPlaca = new JTextField();
        JTextField txtModelo = new JTextField();
        JTextField txtCor = new JTextField();

        JComboBox<String> cbTipo =
                new JComboBox<>(
                        new String[]{
                                "Carro",
                                "Moto",
                                "Caminhonete"
                        }
                );

        JButton btnCadastrar =
                new JButton("Cadastrar");

        add(new JLabel("Placa"));
        add(txtPlaca);

        add(new JLabel("Modelo"));
        add(txtModelo);

        add(new JLabel("Cor"));
        add(txtCor);

        add(new JLabel("Tipo"));
        add(cbTipo);

        add(new JLabel());
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {

            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            String cor = txtCor.getText();

            Veiculo veiculo = null;

            switch (cbTipo.getSelectedIndex()) {

                case 0:
                    veiculo = new Carro(
                            placa,
                            modelo,
                            cor
                    );
                    break;

                case 1:
                    veiculo = new Moto(
                            placa,
                            modelo,
                            cor
                    );
                    break;

                case 2:
                    veiculo = new Caminhonete(
                            placa,
                            modelo,
                            cor
                    );
                    break;
            }

            estacionamento.cadastrarVeiculo(
                    veiculo
            );

            JOptionPane.showMessageDialog(
                    null,
                    "Veículo cadastrado!"
            );
        });
    }
}