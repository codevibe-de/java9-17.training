package h_httpclient.h1_basic;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BasicHttpClientApp {

    @Test
    void simpleGet() throws IOException, InterruptedException {
        // there is no built-in way to add path/query parameters
        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();

        final HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        final HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("status = " + response.statusCode());
        System.out.println("body   = " + response.body());
    }


    @Test
    void getWithBasicAuth() throws IOException, InterruptedException {
        // there is no built-in way to add path/query parameters
        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://postman-echo.com/basic-auth"))
                .build();

        final HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("postman", "password".toCharArray());
                    }
                })
                .build();

        final HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("status = " + response.statusCode());
        System.out.println("body   = " + response.body());
    }

}
