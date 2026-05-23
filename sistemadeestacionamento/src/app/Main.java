package app;

import model.Estacionamento;
import model.Vaga;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		
		// Número total de vagas(10)
        for (int i = 1; i <= 10; i++) {
            estacionamento.adicionarVaga(new Vaga(i));
        }

        new TelaPrincipal(estacionamento);
    }

}
