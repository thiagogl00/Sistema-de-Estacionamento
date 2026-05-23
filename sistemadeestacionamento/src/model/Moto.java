package model;

public class Moto extends Veiculo{
	public Moto(String placa, String modelo, String cor) {
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

        // Moto paga 50%
        return valor * 0.5;
    }
}
