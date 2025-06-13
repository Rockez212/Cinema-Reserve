package project.cinemareserve.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cinemareserve.command.LoginCommand;
import project.cinemareserve.command.RegisterCommand;
import project.cinemareserve.command.TokenResponse;
import project.cinemareserve.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    public final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterCommand command) {
        authService.register(command);
        return ResponseEntity.ok("Successfully registered");
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(LoginCommand command) {
        TokenResponse accessToken = authService.login(command);
        return ResponseEntity.ok(accessToken);
    }
}
