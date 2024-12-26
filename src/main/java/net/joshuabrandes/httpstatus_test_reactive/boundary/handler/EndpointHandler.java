package net.joshuabrandes.httpstatus_test_reactive.boundary.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class EndpointHandler {

    private final WebClient webClient;

    public EndpointHandler(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://httpstat.us").build();
    }

    public Mono<ServerResponse> getStatus() {
        return webClient.get()
                .uri("/200?sleep=5000")
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(responseBody -> ServerResponse.ok().bodyValue(responseBody))
                .onErrorResume(_ -> ServerResponse.status(500).bodyValue("Internal Server Error"));
    }
}
