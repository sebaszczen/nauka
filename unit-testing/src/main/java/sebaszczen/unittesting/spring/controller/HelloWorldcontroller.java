package sebaszczen.unittesting.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldcontroller {

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "hello-world";
    }
}
