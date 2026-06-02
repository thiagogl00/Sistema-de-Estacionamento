package panels;

import javax.swing.*;

import service.VagaApiService;

import java.awt.*;

public class VagasPanel extends JPanel {

	public VagasPanel() {

		setLayout(new GridLayout(5, 2, 10, 10));

		JTextField txtNumero = new JTextField();
		JButton btnCriar = new JButton("Criar Vaga");

		add(new JLabel("Número"));
		add(txtNumero);

		add(new JLabel());
		add(btnCriar);

		btnCriar.addActionListener(e -> {

			try {

				VagaApiService service = new VagaApiService();
				String response = service.criarVaga(Integer.parseInt(txtNumero.getText()));

				JOptionPane.showMessageDialog(this, response);

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		});
	}
}
