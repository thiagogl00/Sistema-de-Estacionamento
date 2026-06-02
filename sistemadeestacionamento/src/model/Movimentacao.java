package model;

import java.time.Duration;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class Movimentacao {
	private Veiculo veiculo;
    private Vaga vaga;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private double valorPago;

    public Movimentacao(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.dataEntrada = LocalDateTime.now();
    }
    // Registrar saída
    public void registrarSaida() {

        this.dataSaida = LocalDateTime.now();

        long horas = Duration.between(dataEntrada, dataSaida).toHours();

        // Se ficar menos de 1h cobra mínimo
        if (horas == 0) {
            horas = 1;
        }

        // Polimorfismo
        this.valorPago = veiculo.calcularValor((int) horas);

        vaga.setOcupada(false);
    }

    @Override
    public String toString() {

        return "\nVeículo: " + veiculo.getPlaca() +
               "\nVaga: " + vaga.getNumero() +
               "\nEntrada: " + dataEntrada +
               "\nSaída: " + dataSaida +
               "\nValor Pago: R$ " + valorPago;
    }
}
