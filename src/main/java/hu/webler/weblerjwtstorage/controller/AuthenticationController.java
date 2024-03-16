package hu.webler.weblerjwtstorage.controller;

import hu.webler.weblerjwtstorage.auth.AuthenticationRequest;
import hu.webler.weblerjwtstorage.auth.AuthenticationResponse;
import hu.webler.weblerjwtstorage.auth.RegistrationRequest;
import hu.webler.weblerjwtstorage.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.status(201).body(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.status(200).body(authenticationService.authenticate(request));
    }
}
