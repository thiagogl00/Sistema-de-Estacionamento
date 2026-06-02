package panels;

import javax.swing.*;

import service.MovimentacaoApiService;

import java.awt.*;

public class SaidaPanel extends JPanel {

	public SaidaPanel() {

		setLayout(new GridLayout(4, 2, 10, 10));

		JTextField txtPlaca = new JTextField();
		JButton btnSaida = new JButton("Registrar Saída");

		add(new JLabel("Placa"));
		add(txtPlaca);
		
		add(new JLabel());
		add(btnSaida);

		btnSaida.addActionListener(e -> {

			try {

				MovimentacaoApiService service = new MovimentacaoApiService();

				String response = service.registrarSaida(txtPlaca.getText());

				JOptionPane.showMessageDialog(this, response);

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		});
	}
}