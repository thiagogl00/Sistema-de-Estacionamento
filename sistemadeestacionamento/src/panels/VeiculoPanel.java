package panels;

import javax.swing.*;

import service.ApiClient;

import java.awt.*;

public class VeiculoPanel extends JPanel {

	public VeiculoPanel() {

		setLayout(new GridLayout(6, 2, 10, 10));

		JTextField txtPlaca = new JTextField();
		JTextField txtModelo = new JTextField();
		JTextField txtCor = new JTextField();
		JComboBox<String> comboTipo = new JComboBox<>(new String[] { "CARRO", "MOTO", "CAMINHONETE" });
		JButton btnSalvar = new JButton("Cadastrar");

		add(new JLabel("Placa"));
		add(txtPlaca);

		add(new JLabel("Modelo"));
		add(txtModelo);

		add(new JLabel("Cor"));
		add(txtCor);

		add(new JLabel("Tipo"));
		add(comboTipo);

		add(new JLabel());
		add(btnSalvar);

		btnSalvar.addActionListener(e -> {

			try {

				String json = """

						    {
						        "placa":"%s",
						        "modelo":"%s",
						        "cor":"%s",
						        "tipo":"%s"
						    }

						""".formatted(

						txtPlaca.getText(), txtModelo.getText(), txtCor.getText(), comboTipo.getSelectedItem());

				String response = ApiClient.post("/veiculos", json);

				JOptionPane.showMessageDialog(this, "Veículo cadastrado!\n" + response);

			} catch (Exception ex) {

				JOptionPane.showMessageDialog(this, ex.getMessage());
			}
		});
	}
}
