package panels;

import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.MovimentacaoResponseDTO;
import service.MovimentacaoApiService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.util.List;

public class HistoricoPanel extends JPanel {

	private JTable tabela;

	private DefaultTableModel model;

	public HistoricoPanel() {

		setLayout(new BorderLayout());

		String[] colunas = { "Placa", "Modelo", "Vaga", "Entrada", "Saída", "Valor", "Status" };

		model = new DefaultTableModel(colunas, 0);
		tabela = new JTable(model);

		JScrollPane scroll = new JScrollPane(tabela);

		add(scroll, BorderLayout.CENTER);

		carregarHistorico();
	}

	private void carregarHistorico() {

		try {

			MovimentacaoApiService service = new MovimentacaoApiService();

			String response = service.listarHistorico();
			ObjectMapper mapper = new ObjectMapper();

			List<MovimentacaoResponseDTO> movimentacoes = mapper.readValue(response,
					new TypeReference<List<MovimentacaoResponseDTO>>() {
					});

			model.setRowCount(0);

			for (MovimentacaoResponseDTO mov : movimentacoes) {
				model.addRow(new Object[] { mov.getPlaca(), mov.getModelo(), mov.getVaga(), mov.getDataEntrada(),
						mov.getDataSaida(), mov.getValorPago(), mov.getStatus() });
			}

		} catch (Exception ex) {

			JOptionPane.showMessageDialog(this, "Erro ao carregar histórico:\n" + ex.getMessage());
			ex.printStackTrace();
		}
	}
}