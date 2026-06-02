package panels;

import javax.swing.*;

import service.MovimentacaoApiService;

import java.awt.*;

public class EntradaPanel extends JPanel {

	public EntradaPanel() {

		setLayout(new GridLayout(5, 2, 10, 10));

		JTextField txtPlaca = new JTextField();
		JTextField txtVaga = new JTextField();
		JButton btnRegistrar = new JButton("Registrar Entrada");

		add(new JLabel("Placa"));
		add(txtPlaca);
		
		add(new JLabel("Número da Vaga"));
		add(txtVaga);
		
		add(new JLabel());
		add(btnRegistrar);
		
		btnRegistrar.addActionListener(e -> {

			try {

				MovimentacaoApiService service = new MovimentacaoApiService();

				String response = service.registrarEntrada(txtPlaca.getText(), Integer.parseInt(txtVaga.getText()));

				JOptionPane.showMessageDialog(this, response);

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		});
	}
}