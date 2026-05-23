package model;

public class Carro extends Veiculo{
	public Carro(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double calcularValor(int horas) {

        double valor;

        if (horas <= 1) {
            valor = 5.0;
        } else {
            valor = 5.0 + ((horas - 1) * 3.0);
        }

        return valor;
    }
}
