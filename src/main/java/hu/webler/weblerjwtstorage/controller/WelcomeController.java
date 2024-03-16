package hu.webler.weblerjwtstorage.controller;

import hu.webler.weblerjwtstorage.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class WelcomeController {

    private final JwtService jwtService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(HttpServletRequest request) {
        String token = jwtService.extractToken(request);
        if (token == null) {
            return ResponseEntity.status(401).body("Unauthorized");
        }
        String email = jwtService.extractUsername(token);
        String message = format("Welcome! User: %s. Token: %s", email, token);
        return ResponseEntity.status(200).body(message);
    }
}
