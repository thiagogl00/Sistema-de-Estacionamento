package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

	private static final String BASE_URL = "http://localhost:8080";
	private static final HttpClient client = HttpClient.newHttpClient();

	public static String get(String endpoint) throws Exception {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + endpoint)).GET().build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}

	public static String post(String endpoint, String json) throws Exception {

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL + endpoint))
				.header("Content-Type", "application/json").POST(HttpRequest.BodyPublishers.ofString(json)).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		return response.body();
	}
}