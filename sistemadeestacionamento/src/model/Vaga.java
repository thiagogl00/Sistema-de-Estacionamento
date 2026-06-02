package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vaga {
	private int numero;
    private boolean ocupada;

    public Vaga(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    @Override
    public String toString() {
        return "Vaga " + numero +
               " | Ocupada: " + ocupada;
    }
}
