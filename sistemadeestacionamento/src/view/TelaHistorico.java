package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import model.Estacionamento;
import model.Movimentacao;

public class TelaHistorico extends JPanel {

    public TelaHistorico(
            Estacionamento estacionamento) {

        setLayout(new BorderLayout());

        String[] colunas = {

                "Placa",
                "Modelo",
                "Entrada",
                "Saída",
                "Valor"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modelo);

        for (Movimentacao m :
                estacionamento.getMovimentacoes()) {

            Object[] linha = {

                    m.getVeiculo().getPlaca(),

                    m.getVeiculo().getModelo(),

                    m.getDataEntrada(),

                    m.getDataSaida(),

                    "R$ " + m.getValorPago()
            };

            modelo.addRow(linha);
        }

        JScrollPane scroll =
                new JScrollPane(tabela);

        add(scroll, BorderLayout.CENTER);
    }
}