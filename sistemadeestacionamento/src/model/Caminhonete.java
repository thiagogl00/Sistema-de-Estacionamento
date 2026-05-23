package model;

public class Caminhonete extends Veiculo{
	public Caminhonete(String placa, String modelo, String cor) {
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

        // Caminhonete paga 150%
        return valor * 1.5;
    }
}
