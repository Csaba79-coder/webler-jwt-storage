package hu.webler.weblerjwtstorage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.status(200).body("Hello from secured endpoint!");
    }
}
