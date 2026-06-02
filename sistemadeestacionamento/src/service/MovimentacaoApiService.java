package service;

public class MovimentacaoApiService {

	public String registrarEntrada(String placa, Integer vaga) throws Exception {

		String json = """

				    {
				        "placa":"%s",
				        "numeroVaga":%d
				    }

				""".formatted(placa, vaga);

		return ApiClient.post("/entrada", json);
	}

	public String registrarSaida(String placa) throws Exception {

		String json = """

				    {
				        "placa":"%s"
				    }

				""".formatted(placa);

		return ApiClient.post("/saida", json);
	}

	public String listarHistorico() throws Exception {

		return ApiClient.get("/movimentacoes/historico");
	}

	public String listarEstacionados() throws Exception {

		return ApiClient.get("/movimentacoes/estacionados");
	}
}
