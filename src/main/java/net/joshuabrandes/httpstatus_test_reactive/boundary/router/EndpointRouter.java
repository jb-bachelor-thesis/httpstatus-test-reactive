package net.joshuabrandes.httpstatus_test_reactive.boundary.router;

import net.joshuabrandes.httpstatus_test_reactive.boundary.handler.EndpointHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EndpointRouter {

    private final EndpointHandler endpointHandler;

    public EndpointRouter(EndpointHandler endpointHandler) {
        this.endpointHandler = endpointHandler;
    }

    @Bean
    RouterFunction<ServerResponse> getStatus() {
        return route(GET("/v1/status"), _ -> endpointHandler.getStatus());
    }
}
