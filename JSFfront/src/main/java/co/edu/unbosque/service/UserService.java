package co.edu.unbosque.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class UserService {

	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1)
			.connectTimeout(Duration.ofSeconds(5)).build();

	public static String doPost(String url, String json) {
		HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
				.uri(URI.create(url)).setHeader("User-Agent", "Java 11 HttpClient Bot") 
				.header("Content-Type", "application/json").build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("status code -> " + response.statusCode());

		return response.statusCode()+"\n"+response.body();
	}
}
