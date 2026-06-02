package panels;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {

	public DashboardPanel() {

		setLayout(new BorderLayout());

		JLabel titulo = new JLabel("Sistema de Estacionamento", SwingConstants.CENTER);

		titulo.setFont(new Font("Arial", Font.BOLD, 28));

		add(titulo, BorderLayout.CENTER);
	}
}