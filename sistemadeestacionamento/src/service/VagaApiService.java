package service;

public class VagaApiService {

	public String criarVaga(Integer numero) throws Exception {

		String json = """

				    {
				        "numero":%d
				    }

				""".formatted(numero);

		return ApiClient.post("/vagas", json);
	}

	public String listarLivres() throws Exception {

		return ApiClient.get("/vagas/livres");
	}
}
