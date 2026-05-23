package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import model.Estacionamento;
import model.Movimentacao;

public class TelaVeiculosEstacionados extends JPanel {

    public TelaVeiculosEstacionados(
            Estacionamento estacionamento) {

        setLayout(new BorderLayout());

        String[] colunas = {
                "Placa",
                "Modelo",
                "Vaga",
                "Entrada"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modelo);

        for (Movimentacao m :
                estacionamento.getMovimentacoes()) {

            if (m.getDataSaida() == null) {

                Object[] linha = {

                        m.getVeiculo().getPlaca(),

                        m.getVeiculo().getModelo(),

                        m.getVaga().getNumero(),

                        m.getDataEntrada()
                };

                modelo.addRow(linha);
            }
        }

        JScrollPane scroll =
                new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);
    }
}