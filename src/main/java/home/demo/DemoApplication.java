package home.demo;

import home.demo.users.application.Handler;
import home.demo.users.application.Routs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

//        Handler handler = new Handler();
//        Routs rout = new Routs();
//        rout.route(handler);
        SpringApplication.run(DemoApplication.class, args);
    }

}
