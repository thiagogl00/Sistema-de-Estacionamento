package model;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Veiculo> veiculos;
    private List<Vaga> vagas;
    private List<Movimentacao> movimentacoes;

    public Estacionamento() {

        veiculos = new ArrayList<>();
        vagas = new ArrayList<>();
        movimentacoes = new ArrayList<>();
    }

    // Cadastrar veículo
    public void cadastrarVeiculo(Veiculo veiculo) {

        for (Veiculo v : veiculos) {

            if (v.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {

                System.out.println("ERRO: Placa já cadastrada.");
                return;
            }
        }

        veiculos.add(veiculo);

        System.out.println("Veículo cadastrado com sucesso.");
    }

    // Adicionar vaga
    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    // Registrar entrada
    public void registrarEntrada(String placa, int numeroVaga) {

        Veiculo veiculoEncontrado = null;

        for (Veiculo v : veiculos) {

            if (v.getPlaca().equalsIgnoreCase(placa)) {
                veiculoEncontrado = v;
                break;
            }
        }

        if (veiculoEncontrado == null) {

            System.out.println("ERRO: Veículo não encontrado.");
            return;
        }

        // Verifica se já está estacionado
        for (Movimentacao m : movimentacoes) {

            if (m.getVeiculo().getPlaca().equalsIgnoreCase(placa)
                    && m.getDataSaida() == null) {

                System.out.println("ERRO: Veículo já estacionado.");
                return;
            }
        }

        Vaga vagaEncontrada = null;

        for (Vaga vaga : vagas) {

            if (vaga.getNumero() == numeroVaga) {

                vagaEncontrada = vaga;
                break;
            }
        }

        if (vagaEncontrada == null) {

            System.out.println("ERRO: Vaga não encontrada.");
            return;
        }

        if (vagaEncontrada.isOcupada()) {

            System.out.println("ERRO: Vaga ocupada.");
            return;
        }

        vagaEncontrada.setOcupada(true);

        Movimentacao movimentacao =
                new Movimentacao(veiculoEncontrado, vagaEncontrada);

        movimentacoes.add(movimentacao);

        System.out.println("Entrada registrada com sucesso.");
    }

    // Registrar saída
    public void registrarSaida(String placa) {

        for (Movimentacao m : movimentacoes) {

            if (m.getVeiculo().getPlaca().equalsIgnoreCase(placa)
                    && m.getDataSaida() == null) {

                m.registrarSaida();

                System.out.println("Saída registrada.");
                System.out.println("Valor pago: R$ " + m.getValorPago());

                return;
            }
        }

        System.out.println("ERRO: Veículo não está estacionado.");
    }

    // Listar veículos estacionados
    public void listarVeiculosEstacionados() {

        System.out.println("\nVEÍCULOS ESTACIONADOS:");

        for (Movimentacao m : movimentacoes) {

            if (m.getDataSaida() == null) {

                System.out.println(
                        m.getVeiculo().getPlaca() +
                        " - Vaga " +
                        m.getVaga().getNumero()
                );
            }
        }
    }

    // Histórico
    public void historicoMovimentacoes() {

        System.out.println("\nHISTÓRICO:");

        for (Movimentacao m : movimentacoes) {

            System.out.println(m);
        }
    }
    
    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }
}
