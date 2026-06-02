package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Veiculo {
	private String placa;
    private String modelo;
    private String cor;

    public abstract double calcularValor(int horas);

}
