package home.demo.users.application;

import home.demo.users.InputProcessor;
import home.demo.users.application.services.UserService;
import home.demo.users.domain.User;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Handler {
    private final UserService userService;

    public Handler() throws SQLException {
        this.userService = new UserService();
    }

//    public Mono<ServerResponse> getUsers(ServerRequest request){
//        return ServerResponse.ok()
//                .body(BodyInserters.fromObject("Hello world!"));
//    }

    public Mono<ServerResponse> getUsers(ServerRequest request){
        List<User> users = this.userService.getUsers();

        return ServerResponse.ok()
                .body(BodyInserters.fromValue(users));
    }

}
