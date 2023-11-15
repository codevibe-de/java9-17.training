package h_httpclient.h1_basic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BasicHttpClientApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        simpleGet();
    }

    private static void simpleGet() throws IOException, InterruptedException {
        // there is no built-in way to add path/query parameters
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .GET()
                .build();

        final HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        final HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("status = " + response.statusCode());
        System.out.println("body   = " + response.body());
    }
}
