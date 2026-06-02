package model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimentacaoResponseDTO {
	
	private String id;

	private String placa;

	private String modelo;

	private Integer vaga;

	private String dataEntrada;

	private String dataSaida;

	private BigDecimal valorPago;

	private String status;

}