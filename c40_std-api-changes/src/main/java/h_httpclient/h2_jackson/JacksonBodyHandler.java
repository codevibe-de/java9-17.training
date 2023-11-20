package h_httpclient.h2_jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodySubscriber;
import java.nio.charset.StandardCharsets;

public class JacksonBodyHandler<T> implements HttpResponse.BodyHandler<T> {

    private final Class<T> targetClass;
    private final ObjectMapper objectMapper;

    public JacksonBodyHandler(Class<T> targetClass) {
        this.targetClass = targetClass;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public BodySubscriber<T> apply(HttpResponse.ResponseInfo responseInfo) {
        BodySubscriber<String> upstream = HttpResponse.BodySubscribers.ofString(StandardCharsets.UTF_8);

        return HttpResponse.BodySubscribers.mapping(
                upstream,
                body -> {
                    try {
                        return objectMapper.readValue(body, targetClass);
                    } catch (IOException e) {
                        throw new UncheckedIOException(e);
                    }
                });
    }
}
