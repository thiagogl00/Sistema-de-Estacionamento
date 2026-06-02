package service;

public class VeiculoApiService {

	public String cadastrar(String placa, String modelo, String cor, String tipo) throws Exception {

		String json = """

				    {
				        "placa":"%s",
				        "modelo":"%s",
				        "cor":"%s",
				        "tipo":"%s"
				    }

				""".formatted(placa, modelo, cor, tipo);

		return ApiClient.post("/veiculos", json);
	}

	public String listarTodos() throws Exception {

		return ApiClient.get("/veiculos");
	}

	public String buscarPorPlaca(String placa) throws Exception {

		return ApiClient.get("/veiculos/" + placa);
	}
}