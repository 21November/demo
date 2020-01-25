package home.demo.users.application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class Routs {
    @Bean
    public RouterFunction<ServerResponse> route(Handler handler) {

        return RouterFunctions
                .route(
                    RequestPredicates.GET("/users"),
                    handler::getUsers
                );

        //TEXT_PLAIN -> APPLICATION_JSON
    }


}
