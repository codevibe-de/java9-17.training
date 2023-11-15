package h_httpclient.h2_jackson;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JacksonHttpClientApp {

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

        final HttpResponse<TodoResponse> response =
                client.send(request, new JacksonBodyHandler<>(TodoResponse.class));

        System.out.println("status = " + response.statusCode());
        System.out.println("body   = " + response.body());
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record TodoResponse(
            String id,
            String userId
    ) {
    }
}
