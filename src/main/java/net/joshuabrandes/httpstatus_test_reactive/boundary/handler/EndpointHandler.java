package net.joshuabrandes.httpstatus_test_reactive.boundary.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class EndpointHandler {

    public Mono<ServerResponse> getStatus() {
        // sleep for 5 seconds and then return 200 with Body "OK"
        return Mono.delay(Duration.ofSeconds(5))
                .then(ServerResponse.ok().bodyValue("OK"));
    }
}
