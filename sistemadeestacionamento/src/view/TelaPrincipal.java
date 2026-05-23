package view;

import javax.swing.*;
import java.awt.*;

import model.Estacionamento;

public class TelaPrincipal extends JFrame {

    private Estacionamento estacionamento;

    private JPanel painelConteudo;

    public TelaPrincipal(Estacionamento estacionamento) {

        this.estacionamento = estacionamento;

        setTitle("Sistema de Estacionamento");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // SIDEBAR
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(6, 1, 10, 10));
        sidebar.setBackground(new Color(30, 30, 30));
        sidebar.setPreferredSize(new Dimension(220, 600));

        JButton btnCadastrar =
                criarBotao("🚗 Cadastrar");

        JButton btnEntrada =
                criarBotao("⬅ Registrar Entrada");

        JButton btnSaida =
                criarBotao("➡ Registrar Saída");

        JButton btnEstacionados =
                criarBotao("📋 Estacionados");

        JButton btnHistorico =
                criarBotao("📜 Histórico");

        sidebar.add(btnCadastrar);
        sidebar.add(btnEntrada);
        sidebar.add(btnSaida);
        sidebar.add(btnEstacionados);
        sidebar.add(btnHistorico);

        // ÁREA CENTRAL
        painelConteudo = new JPanel();
        painelConteudo.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(
                "Sistema de Estacionamento",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 28));

        painelConteudo.add(titulo, BorderLayout.CENTER);

        add(sidebar, BorderLayout.WEST);
        add(painelConteudo, BorderLayout.CENTER);

        // EVENTOS
        btnCadastrar.addActionListener(e ->
                trocarPainel(
                        new TelaCadastroVeiculo(estacionamento)
                )
        );

        btnEntrada.addActionListener(e ->
                trocarPainel(
                        new TelaEntrada(estacionamento)
                )
        );

        btnSaida.addActionListener(e ->
                trocarPainel(
                        new TelaSaida(estacionamento)
                )
        );

        btnEstacionados.addActionListener(e ->
                trocarPainel(
                        new TelaVeiculosEstacionados(estacionamento)
                )
        );

        btnHistorico.addActionListener(e ->
                trocarPainel(
                        new TelaHistorico(estacionamento)
                )
        );

        setVisible(true);
    }

    private JButton criarBotao(String texto) {

        JButton botao = new JButton(texto);

        botao.setFocusPainted(false);

        botao.setBackground(new Color(45, 45, 45));

        botao.setForeground(Color.WHITE);

        botao.setFont(new Font("Arial", Font.BOLD, 15));

        return botao;
    }

    private void trocarPainel(JPanel novoPainel) {

        painelConteudo.removeAll();

        painelConteudo.add(novoPainel, BorderLayout.CENTER);

        painelConteudo.revalidate();

        painelConteudo.repaint();
    }
}