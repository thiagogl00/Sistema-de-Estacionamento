package app;

import javax.swing.*;

import panels.DashboardPanel;

import java.awt.*;

public class MainFrame extends JFrame {

	private JPanel contentPanel;

	public MainFrame() {

		setTitle("Sistema de Estacionamento");
		setSize(1200, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		Sidebar sidebar = new Sidebar(this);
		add(sidebar, BorderLayout.WEST);

		contentPanel = new JPanel(new BorderLayout());
		add(contentPanel, BorderLayout.CENTER);

		mostrarPainel(new DashboardPanel());
	}

	public void mostrarPainel(JPanel panel) {

		contentPanel.removeAll();
		contentPanel.add(panel);
		contentPanel.revalidate();
		contentPanel.repaint();
	}

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {

			new MainFrame().setVisible(true);
		});
	}
}