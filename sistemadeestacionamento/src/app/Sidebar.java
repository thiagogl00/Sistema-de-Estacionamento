package app;

import javax.swing.*;

import panels.EntradaPanel;
import panels.HistoricoPanel;
import panels.SaidaPanel;
import panels.VagasPanel;
import panels.VeiculoPanel;

import java.awt.*;

public class Sidebar extends JPanel {

	public Sidebar(MainFrame frame) {

		setPreferredSize(new Dimension(250, 700));
		setBackground(new Color(30, 30, 30));
		setLayout(new GridLayout(10, 1, 10, 10));

		JButton btnVeiculos = criarBotao("Veículos");
		JButton btnEntrada = criarBotao("Entrada");
		JButton btnSaida = criarBotao("Saída");
		JButton btnHistorico = criarBotao("Histórico");
		JButton btnVagas = criarBotao("Vagas");

		btnVeiculos.addActionListener(e -> frame.mostrarPainel(new VeiculoPanel()));

		btnEntrada.addActionListener(e -> frame.mostrarPainel(new EntradaPanel()));

		btnSaida.addActionListener(e -> frame.mostrarPainel(new SaidaPanel()));

		btnHistorico.addActionListener(e -> frame.mostrarPainel(new HistoricoPanel()));

		btnVagas.addActionListener(e -> frame.mostrarPainel(new VagasPanel()));

		add(btnVeiculos);
		add(btnEntrada);
		add(btnSaida);
		add(btnHistorico);
		add(btnVagas);
	}

	private JButton criarBotao(String texto) {

		JButton button = new JButton(texto);

		button.setFocusPainted(false);
		button.setBackground(new Color(45, 45, 45));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.BOLD, 16));

		return button;
	}
}